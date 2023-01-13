package com.example.androidnavigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.example.androidnavigation.databinding.FragmentMainBinding

class mainFragment : Fragment() {

    private val args: mainFragmentArgs by navArgs()

    private var _binding: FragmentMainBinding? = null
    private val binding get()  = _binding!!

    /// view initialization logic
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMainBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    /// Post view initialization logic
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.mainUsername.text = args.username
        binding.mainPassword.text = args.password

        super.onViewCreated(view, savedInstanceState)
    }
}