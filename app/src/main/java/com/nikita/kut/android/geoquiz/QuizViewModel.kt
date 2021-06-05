package com.nikita.kut.android.geoquiz

import android.util.Log
import androidx.lifecycle.ViewModel

class QuizViewModel : ViewModel() {

    private val questionBank = listOf(
        Question(R.string.question_australia, true),
        Question(R.string.question_oceans, false),
        Question(R.string.question_mideast, false),
        Question(R.string.question_africa, false),
        Question(R.string.question_americas, true),
        Question(R.string.question_asia, true)
    )

    var index = 0

    var correctAnswerCount = 0

    val trueValue = true

    val falseValue = false

    val currentQuestionAnswer: Boolean
        get() = questionBank[index].answer

    val currentQuestionText: Int
        get() = questionBank[index].textResId

    fun moveToNext() {
        index = (index + 1) % questionBank.size
    }

    fun getQuestionBankSize(): Int = questionBank.size

    companion object {
        private const val TAG = "QuizViewModel"
    }
}