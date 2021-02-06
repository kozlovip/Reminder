package com.example.reminder.adapters

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter

@BindingAdapter("drawableByResId")
fun bindDrawableByResId(view: ImageView, resourceId: Int?) {
    resourceId?.let{
        val resources = view.context.resources
        val drawable = resources.getDrawable(resourceId, null)
        view.setImageDrawable(drawable)
    }
}

@BindingAdapter("textByResId")
fun bindTextByResId(view: TextView, resourceId: Int?) {
    resourceId?.let{
        val resources = view.context.resources
        val str = resources.getString(resourceId)
        view.text = str
    }
}