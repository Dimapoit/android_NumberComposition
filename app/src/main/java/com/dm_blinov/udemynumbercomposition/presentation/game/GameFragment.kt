package com.dm_blinov.udemynumbercomposition.presentation.game

import android.content.res.ColorStateList
import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.dm_blinov.udemynumbercomposition.R
import com.dm_blinov.udemynumbercomposition.databinding.FragmentGameBinding
import com.dm_blinov.udemynumbercomposition.domain.entity.GameResult
import com.dm_blinov.udemynumbercomposition.domain.entity.GameSettings
import com.dm_blinov.udemynumbercomposition.domain.entity.Level
import com.dm_blinov.udemynumbercomposition.presentation.gameFinished.GameFinishedFragment
import java.lang.RuntimeException

class GameFragment : Fragment() {

    private var _binding: FragmentGameBinding? = null
    private val binding: FragmentGameBinding
        get() = _binding ?: throw RuntimeException("FragmentWelcomeBinding == null")

    //private lateinit var level: Level

    private val args by navArgs<GameFragmentArgs>()


    private val viewModelFactory by lazy {
        GameViewModelFactory(args.level, requireActivity().application)
    }

    //private lateinit var viewModel: GameViewModel
    private val viewModel by lazy {
        ViewModelProvider(this, viewModelFactory)[GameViewModel::class.java]
    }

//    private val tvOptions by lazy {
//        mutableListOf<TextView>().apply {
//            add(binding.tvOption1)
//            add(binding.tvOption2)
//            add(binding.tvOption3)
//            add(binding.tvOption4)
//            add(binding.tvOption5)
//            add(binding.tvOption6)
//        }
//    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentGameBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner
        observeViewModel()
        //setClickListenersToOptions()
        //viewModel.startGame(level)
//        viewModel = ViewModelProvider(
//            this,
//            AndroidViewModelFactory.getInstance(requireActivity().application)
//        )[GameViewModel::class.java]
    }

//    private fun setClickListenersToOptions() {
//        for(tvOption in tvOptions){
//            tvOption.setOnClickListener { viewModel.chooseAnswer(tvOption.text.toString().toInt()) }
//        }
//    }

    @RequiresApi(Build.VERSION_CODES.N)
    private fun observeViewModel() {
//        viewModel.question.observe(viewLifecycleOwner) {
//            binding.tvSum.text = it.sum.toString()
//            binding.tvLeftNumber.text = it.visibleNumber.toString()
//            for (i in 0 until tvOptions.size){
//                tvOptions[i].text = it.options[i].toString()
//            }
//        }
//        viewModel.enoughCount.observe(viewLifecycleOwner){
//            binding.tvAnswersProgress.setTextColor(getColorByState(it))
//        }
//        viewModel.percentOfRightAnswers.observe(viewLifecycleOwner){
//            binding.progressBar.setProgress(it, true)
//        }
//        viewModel.enoughPercent.observe(viewLifecycleOwner) {
//            val color = getColorByState(it)
//            binding.progressBar.progressTintList = ColorStateList.valueOf(color)
//        }
//        viewModel.minPercent.observe(viewLifecycleOwner){
//            binding.progressBar.secondaryProgress = it
//        }
//        viewModel.formatedTime.observe(viewLifecycleOwner){
//            binding.tvTimer.text = it
//        }
        viewModel.gameResult.observe(viewLifecycleOwner){
            launchGameFinishedFragment(it)
        }
//        viewModel.progressAnswers.observe(viewLifecycleOwner){
//            binding.tvAnswersProgress.text = it
//        }
    }

//    private fun getColorByState(state: Boolean) : Int {
//        val colorResId = if (state){
//            android.R.color.holo_green_light
//        } else{
//            android.R.color.holo_red_light
//        }
//        return ContextCompat.getColor(requireContext(), colorResId)
//    }

    private fun launchGameFinishedFragment(gameResult: GameResult) {
        //FragmentNavigation
//        requireActivity().supportFragmentManager
//            .beginTransaction()
//            .replace(R.id.main_container, GameFinishedFragment.newInstance(gameResult))
//            .addToBackStack(null)
//            .commit()
        //JetpackNavigation
//        val args = Bundle().apply {
//            putParcelable(GameFinishedFragment.GAME_RESULT, gameResult)
//        }
//        findNavController().navigate(R.id.action_gameFragment_to_gameFinishedFragment, args)
        findNavController().navigate(GameFragmentDirections.actionGameFragmentToGameFinishedFragment(gameResult))
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        const val KEY_LEVEL = "KEY_LEVEL"

//        const val NAME = "GameFragment"
//
//        fun newInstance(level: Level): GameFragment {
//            return GameFragment().apply {
//                arguments = Bundle().apply {
//                    putSerializable(KEY_LEVEL, level)
//                }
//            }
//        }
    }
}