package com.nikita.kut.android.geoquiz

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.nikita.kut.android.geoquiz.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val quizViewModel: QuizViewModel by lazy {
        ViewModelProvider(this).get(QuizViewModel::class.java)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        updateQuestion()
        setPrevButtonEnabled()
        setNexButtonEnabled()

        binding.btnTrue.setOnClickListener {
            checkAnswer(quizViewModel.trueValue)
            setButtonsEnabled(quizViewModel.falseValue)
            setNumberOfTrueAnswer()
        }

        binding.btnFalse.setOnClickListener {
            checkAnswer(quizViewModel.falseValue)
            setButtonsEnabled(quizViewModel.falseValue)
            setNumberOfTrueAnswer()
        }

        binding.btnNext.setOnClickListener {
            quizViewModel.moveToNext()
            updateQuestion()
            setButtonsEnabled(quizViewModel.trueValue)
            setPrevButtonEnabled()
            setNexButtonEnabled()
        }

        binding.btnPrev.setOnClickListener {
            quizViewModel.moveToNext()
            updateQuestion()
            setButtonsEnabled(quizViewModel.trueValue)
            setPrevButtonEnabled()
            setNexButtonEnabled()
        }

        binding.btnCheat.setOnClickListener {
            openCheatActivity()
        }
    }

    private fun openCheatActivity() {
        val intent = Intent(this, CheatActivity::class.java)
        startActivity(intent)
    }


    private fun updateQuestion() {
        binding.tvQuestion.setText(quizViewModel.currentQuestionText)
    }

    private fun checkAnswer(answer: Boolean) {
        val correctAnswer = quizViewModel.currentQuestionAnswer
        if (answer == correctAnswer) {
            toast(resources.getString(R.string.correct_toast))
            quizViewModel.correctAnswerCount++
        } else {
            toast(resources.getString(R.string.incorrect_toast))
        }
    }

    private fun setButtonsEnabled(enable: Boolean) {
        binding.btnTrue.isEnabled = enable
        binding.btnFalse.isEnabled = enable
    }

    private fun setPrevButtonEnabled() {
        binding.btnPrev.isEnabled = quizViewModel.index != 0
    }

    private fun setNexButtonEnabled() {
        binding.btnNext.isEnabled = quizViewModel.index != (quizViewModel.getQuestionBankSize() - 1)
    }

    private fun setNumberOfTrueAnswer() {
        if (quizViewModel.index == (quizViewModel.getQuestionBankSize() - 1)) {
            binding.tvAnswer.text =
                "Correct answer ${quizViewModel.correctAnswerCount}/${quizViewModel.getQuestionBankSize()}"
        }
    }

    private fun toast(text: String) {
        Toast.makeText(applicationContext, text, Toast.LENGTH_SHORT).show()
    }

    companion object {
        private const val TAG = "MainActivity"
    }

}