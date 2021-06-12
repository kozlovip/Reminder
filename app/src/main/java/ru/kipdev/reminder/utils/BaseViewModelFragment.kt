package ru.medicalapps.medicalapps.demo.utils

import android.content.Context
import android.os.Bundle
import android.view.*
import android.widget.RelativeLayout
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.LayoutRes
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.distinctUntilChanged
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavDirections
import com.github.ybq.android.spinkit.SpinKitView
import com.github.ybq.android.spinkit.SpriteFactory
import com.github.ybq.android.spinkit.Style
import com.google.gson.Gson
import dagger.android.support.AndroidSupportInjection
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import retrofit2.HttpException
import ru.kipdev.reminder.R
import ru.kipdev.reminder.model.DataResult
import java.lang.Exception
import java.net.UnknownHostException
import javax.inject.Inject

abstract class BaseViewModelFragment<T : ViewDataBinding, V : BaseViewModel> : Fragment() {

    lateinit var binding: T

    @Inject
    lateinit var viewModel: V

    @get:LayoutRes
    abstract val layoutId: Int

    abstract val navigationId: Int

    private var originalMode : Int? = null

    interface Callback {
        fun onFragmentAttached()
        fun onFragmentDetached(tag: String?)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activity?.window?.let {
            originalMode = (it.attributes as WindowManager.LayoutParams).softInputMode
        }
    }

    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, layoutId, container, false)
        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        originalMode?.let { activity?.window?.setSoftInputMode(it) }
    }

    private lateinit var loadingIndicator: SpinKitView

    private fun getParamRelative(view: ViewGroup): RelativeLayout.LayoutParams {
        val param = RelativeLayout.LayoutParams(view.layoutParams)
        param.addRule(RelativeLayout.CENTER_IN_PARENT, RelativeLayout.TRUE)
        param.width = 100
        param.height = 100
        return param
    }

    private fun getParamConstraint(view: ViewGroup): ConstraintLayout.LayoutParams {
        val params = ConstraintLayout.LayoutParams(view.layoutParams)
        params.startToStart = ConstraintSet.PARENT_ID
        params.topToTop = ConstraintSet.PARENT_ID
        params.bottomToBottom = ConstraintSet.PARENT_ID
        params.endToEnd = ConstraintSet.PARENT_ID
        params.width = 100
        params.height = 100
        return params
    }

    private fun initLoading() {

        val style = Style.MULTIPLE_PULSE
        val drawable = SpriteFactory.create(style)

        loadingIndicator = SpinKitView(requireContext(), null, 0)
        loadingIndicator.setIndeterminateDrawable(drawable)
        val view = this.view ?: return // returns base view of the fragment
        if (view is ViewGroup) {
            if (view is ConstraintLayout)
                loadingIndicator.layoutParams = getParamConstraint(view)
            else
                loadingIndicator.layoutParams = getParamRelative(view)
            view.addView(loadingIndicator)
        } else
            print("Can't found view for loading indicator.")
    }

    private fun showLoading() {
        if (!::loadingIndicator.isInitialized)
            initLoading()
        loadingIndicator.visibility = View.VISIBLE
        loadingIndicator.invalidate()
    }

    private fun hideLoading() {
        if (::loadingIndicator.isInitialized)
            loadingIndicator.visibility = View.GONE
    }

    fun <L>LiveData<DataResult<L>>.dataObserver(showLoading: Boolean = false, handleOnce: Boolean = false, error: (Throwable?) -> Unit = {}, loading: () -> Unit = {}, block: (L?) -> Unit){
        distinctUntilChanged().observe(viewLifecycleOwner, {
            when (it.status) {
                DataResult.Status.SUCCESS -> {
                    if (showLoading)
                        hideLoading()
                    if(!handleOnce || !it.handeled)
                        block(it.data)
                    it.handeled = true
                }
                DataResult.Status.ERROR -> {
                    if(showLoading)
                        hideLoading()

                    error(it.exception)

                    when(it.exception){
                        is UnknownHostException -> showToast(getString(R.string.text_unknown_error))
                        is HttpException -> {
                            val gson = Gson()
                            try {
                                val map: Map<*, *> = gson.fromJson(it.exception.response()?.errorBody()?.charStream(), MutableMap::class.java)
                                if(map.containsKey("detail"))
                                    showToast(map["detail"] as String)
                                else{
                                    if(map.containsKey("error_detail"))
                                        showToast(map["error_detail"] as String)
                                    else{
                                        showToast(it.exception.message.toString())
                                    }
                                }
                            }
                            catch (ex: Exception){
                                showToast(it.exception.message.toString())
                            }
                        }
                        else -> showToast(it.exception?.message.toString())
                    }
                }
                DataResult.Status.LOADING -> {
                    if (showLoading)
                        showLoading()
                    loading()
                }
                DataResult.Status.DONT_SUPPORT -> { }
            }
        })
    }

    fun safeNavigate(direction: NavDirections){
        if(navigationId == (requireActivity() as BaseActivity<*>).navController?.currentDestination?.id)
            (requireActivity() as BaseActivity<*>).navController?.navigate(direction)
    }

    fun showToast(text: String?) {
        text?.let{
            Toast.makeText(requireContext(), text, Toast.LENGTH_SHORT).show()
        }
    }

    val requestMultiplePermissions =
        registerForActivityResult(ActivityResultContracts.RequestMultiplePermissions()) { permissions ->
            onMultiplePermissionsResult(permissions)
        }

    val requestPermission =
        registerForActivityResult(ActivityResultContracts.RequestPermission()) { isGranted ->
            onSinglePermissionsResult(isGranted)
        }

    open fun onSinglePermissionsResult(isGranted: Boolean){ }
    open fun onMultiplePermissionsResult(permissions: MutableMap<String, Boolean>){ }

    private lateinit var timerJob: Job

    fun startTimer(timeTillRetry: Long, onTick: (Int, Int, String, String) -> Unit, onFinish: () -> Unit) {
        if(::timerJob.isInitialized)
            timerJob.cancel()
        timerJob = lifecycleScope.launch {
            val totalSeconds = (timeTillRetry / 1000).toInt()
            val tickSeconds = 1
            for (second in totalSeconds downTo tickSeconds) {
                val mins = second / 60
                val secs = second - mins * 60
                val minsText = if (mins > 10) mins.toString() else (if (mins > 0) ("0$mins") else "00")
                val secsText = if (secs > 10) secs.toString() else (if (secs > 0) ("0$secs") else "00")
                onTick(mins, secs, minsText, secsText)
                delay(1000)
            }
            onFinish()
        }
    }
}