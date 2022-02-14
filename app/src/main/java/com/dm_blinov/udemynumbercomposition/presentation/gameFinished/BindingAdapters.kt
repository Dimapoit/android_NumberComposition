package com.dm_blinov.udemynumbercomposition.presentation.gameFinished

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.dm_blinov.udemynumbercomposition.R
import com.dm_blinov.udemynumbercomposition.domain.entity.GameResult

@BindingAdapter("requiredAnswers")
fun requiredAnswers(textView: TextView, count: Int) {
    textView.text = String.format(textView.context.getString(R.string.required_score), count)
}

@BindingAdapter("scoreAnswers")
fun scoreAnswers(textView: TextView, score: Int) {
    textView.text = String.format(textView.context.getString(R.string.score_answers), score)
}

@BindingAdapter("requiredPercentage")
fun requiredPercentage(textView: TextView, percent: Int) {
    textView.text = String.format(textView.context.getString(R.string.required_percentage), percent)
}

@BindingAdapter("scorePercentage")
fun scorePercentage(textView: TextView, gameResult: GameResult) {
    var percent: Int = 0
    with(gameResult){
        if (countOfQuestions != 0) {
            percent = countOfRightAnswers/ countOfQuestions * 100
        }
    }
    textView.text = String.format(textView.context.getString(R.string.score_percentage), percent)
}

@BindingAdapter("resultEmoji")
fun resultEmoji(imageView: ImageView, winner: Boolean){
    imageView.setImageResource(getSmileResId(winner))
}

private fun getSmileResId(winner: Boolean): Int {
    return if (winner) {
        R.drawable.smile
    } else {
        R.drawable.sad_smile
    }
}

