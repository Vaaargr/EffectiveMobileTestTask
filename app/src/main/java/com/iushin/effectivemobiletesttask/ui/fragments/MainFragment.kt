package com.iushin.effectivemobiletesttask.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.iushin.effectivemobiletesttask.databinding.FragmentMainBinding
import com.iushin.effectivemobiletesttask.presentation.viewModel.MainFragmentViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainFragment : Fragment() {
    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    private val viewModel by viewModel<MainFragmentViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.observeUserName().observe(viewLifecycleOwner){ name ->
            if (name.isNullOrEmpty()){
                binding.tv.text = "Hernya"
            } else{
                binding.tv.text = name
            }
        }

        binding.bt.setOnClickListener {
            viewModel.checkUserName()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}