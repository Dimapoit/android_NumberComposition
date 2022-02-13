package com.dm_blinov.udemynumbercomposition.presentation.welcome

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.dm_blinov.udemynumbercomposition.R
import com.dm_blinov.udemynumbercomposition.databinding.FragmentWelcomeBinding
import com.dm_blinov.udemynumbercomposition.presentation.ChooseLevel.ChooseLevelFragment
import java.lang.RuntimeException


class WelcomeFragment : Fragment() {

private var _binding: FragmentWelcomeBinding? = null
    private val binding: FragmentWelcomeBinding
    get() = _binding ?: throw RuntimeException("FragmentWelcomeBinding == null")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentWelcomeBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.buttonOk.setOnClickListener {
            launchChooseLevelFragment()
        }
    }

    private fun launchChooseLevelFragment(){
        //FragmentNavigation
//        requireActivity().supportFragmentManager
////            .beginTransaction()
////            .replace(R.id.main_container, ChooseLevelFragment.newInstance())
////            .addToBackStack(ChooseLevelFragment.NAME)
////            .commit()
        //JetpackNavigation
        findNavController().navigate(R.id.action_welcomeFragment_to_chooseLevelFragment)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}