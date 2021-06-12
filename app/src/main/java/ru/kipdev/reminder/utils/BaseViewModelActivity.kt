package ru.medicalapps.medicalapps.demo.utils

import android.os.Bundle
import androidx.databinding.ViewDataBinding
import dagger.android.AndroidInjection
import javax.inject.Inject

abstract class BaseViewModelActivity<T : ViewDataBinding, V : BaseViewModel> :
    BaseActivity<T>(), BaseViewModelFragment.Callback {

    @Inject
    lateinit var viewModel: V

    override fun onFragmentAttached() {}
    override fun onFragmentDetached(tag: String?) {}

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
    }
}