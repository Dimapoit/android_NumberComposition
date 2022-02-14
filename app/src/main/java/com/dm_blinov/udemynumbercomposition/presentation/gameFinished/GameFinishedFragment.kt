package com.dm_blinov.udemynumbercomposition.presentation.gameFinished

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.FragmentManager
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.dm_blinov.udemynumbercomposition.R
import com.dm_blinov.udemynumbercomposition.databinding.FragmentGameFinishedBinding
import com.dm_blinov.udemynumbercomposition.domain.entity.GameResult
import com.dm_blinov.udemynumbercomposition.presentation.game.GameFragment
import java.lang.RuntimeException

class GameFinishedFragment : Fragment() {

    private var _binding: FragmentGameFinishedBinding? = null
    private val binding: FragmentGameFinishedBinding
        get() = _binding ?: throw RuntimeException("FragmentWelcomeBinding == null")

    private lateinit var gameResult: GameResult

    private val args by navArgs<GameFinishedFragmentArgs>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        gameResult = args.gameResult
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentGameFinishedBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //bindViews()
        binding.gameResult = args.gameResult
        binding.btnRetry.setOnClickListener {
            retryGame()
        }
        //FragmentNavigation
        //Переход на экран выбора сложности при нажатии кнопки назад
        /* val callBack = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                retryGame()
            }
        }
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner, callBack) */
}

//    private fun bindViews() {
//        with(binding) {
//            binding.gameResult = args.gameResult
//            emojiResult.setImageResource(getSmileResId())
//            tvRequiredAnswers.text = String.format(
//                getString(R.string.required_score),
//                gameResult.gameSettings.minCountOfRightAnswers
//            )
//            tvScoreAnswers.text = String.format(
//                getString(R.string.score_answers),
//                gameResult.countOfRightAnswers
//            )
//            tvRequiredPercentage.text = String.format(
//                getString(R.string.required_percentage),
//                gameResult.gameSettings.minPercentOfRightAnswers
//            )
//            tvScorePercentage.text = String.format(
//                getString(R.string.score_percentage),
//                getPercentOfRightAnswers()
//            )
//        }
//    }

//    private fun getPercentOfRightAnswers(): Int {
//        return if (gameResult.countOfQuestions == 0) {
//            0
//        } else {
//            gameResult.countOfRightAnswers/ gameResult.countOfQuestions * 100
//        }
//    }
//
//    private fun getSmileResId(): Int {
//        return if (gameResult.winner) {
//            R.drawable.smile
//        } else {
//            R.drawable.sad_smile
//        }
//    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    //Метод перехода на экран выбора сложности
    private fun retryGame() {
        //FragmentNavigation
//        requireActivity().supportFragmentManager
//            .popBackStack(GameFragment.NAME, FragmentManager.POP_BACK_STACK_INCLUSIVE)
        //JetpackNavigation
        findNavController().popBackStack()
    }

//    companion object {
//        const val
//                GAME_RESULT = "GAME_RESULT"
//
//        fun newInstance(gameResult: GameResult): GameFinishedFragment {
//            return GameFinishedFragment().apply {
//                arguments = Bundle().apply {
//                    putParcelable(GAME_RESULT, gameResult)
//                }
//            }
//        }
//    }
}