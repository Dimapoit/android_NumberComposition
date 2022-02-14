package com.dm_blinov.udemynumbercomposition.presentation.game

import android.content.Context
import android.content.res.ColorStateList
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter

@BindingAdapter("numberAsText")
fun sum(textView: TextView, number: Int){
    textView.text = number.toString()
}

@BindingAdapter("answersProgressColor")
fun answersProgressColor(textView: TextView, enoughCount: Boolean) {
    val colorResId = getColorByState(textView.context, enoughCount)
    textView.setTextColor(colorResId)
}
//@BindingAdapter("progressAnswers")
//fun progressAnswers(textView: TextView, progressAnswers: String){
//    textView.text = progressAnswers
//}
//
//
//@BindingAdapter("setProgress")
//fun setProgress(progressBar: ProgressBar, percentOfRightAnswers: Int){
//    progressBar.setProgress(percentOfRightAnswers)
//}
//
//@BindingAdapter("setSecondaryProgress")
//fun setSecondaryProgress(progressBar: ProgressBar, minPercent: Int){
//    progressBar.secondaryProgress = minPercent
//}

interface OnOptionClickListener {
    fun onOptionClick(option: Int)
}

@BindingAdapter("onOptionClickListener")
fun onOptionClickListener(textView: TextView, clickListener: OnOptionClickListener) {
    textView.setOnClickListener {
        clickListener.onOptionClick(textView.text.toString().toInt())
    }
}

@BindingAdapter("setProgressTint")
fun setProgressTint(progressBar: ProgressBar, enoughPercent: Boolean) {
    val colorResId = getColorByState(progressBar.context, enoughPercent)
    progressBar.progressTintList = ColorStateList.valueOf(colorResId)
}

private fun getColorByState(context: Context, state: Boolean) : Int {
    val colorResId = if (state){
        android.R.color.holo_green_light
    } else{
        android.R.color.holo_red_light
    }
    return ContextCompat.getColor(context, colorResId)
}


