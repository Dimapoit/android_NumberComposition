package com.dm_blinov.udemynumbercomposition.presentation.ChooseLevel

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.dm_blinov.udemynumbercomposition.R
import com.dm_blinov.udemynumbercomposition.databinding.FragmentChooseLevelBinding
import com.dm_blinov.udemynumbercomposition.domain.entity.Level
import com.dm_blinov.udemynumbercomposition.presentation.game.GameFragment
import java.lang.RuntimeException


class ChooseLevelFragment : Fragment() {

    private var _binding: FragmentChooseLevelBinding? = null
    private val binding: FragmentChooseLevelBinding
        get() = _binding ?: throw RuntimeException("FragmentWelcomeBinding == null")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentChooseLevelBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding){
            btnLevelTest.setOnClickListener {
                launchGameFragment(Level.TEST)
            }

            btnLevelEasy.setOnClickListener {
                launchGameFragment(Level.EASY)
            }

            btnLevelNormal.setOnClickListener {
                launchGameFragment(Level.NORMAL)
            }
            btnLevelHard.setOnClickListener {
                launchGameFragment(Level.HARD)
            }
        }

    }

    private fun launchGameFragment(level: Level) {
        //FragmentNavigation
//        requireActivity().supportFragmentManager
//            .beginTransaction()
//            .addToBackStack(GameFragment.NAME)
//            .replace(R.id.main_container, GameFragment.newInstance(level))
//            .commit()
        //JetpackNavigation
        val args = Bundle().apply {
            putParcelable(GameFragment.KEY_LEVEL, level)
        }
        //findNavController().navigate(R.id.action_chooseLevelFragment_to_gameFragment, args)
        findNavController()
            .navigate(ChooseLevelFragmentDirections.actionChooseLevelFragmentToGameFragment(level))
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {

        const val NAME = "ChooseFragment"

        fun newInstance(): ChooseLevelFragment {
            return ChooseLevelFragment()
        }
    }
}