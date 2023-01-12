package com.example.androidnavigation

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController

class registerFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val registerFragmentView = inflater.inflate(R.layout.fragment_register, container, false)

        registerFragmentView.findViewById<Button>(R.id.btn_to_login).setOnClickListener{
            /// this is how we move to a fragment using NavController
            findNavController().navigate(R.id.action_registerFragment_to_loginFragment)
        }

        registerFragmentView.findViewById<Button>(R.id.btn_to_main).setOnClickListener{
            /// this is how we move to a fragment using NavController
            findNavController().navigate(R.id.action_registerFragment_to_mainFragment)
        }

        /// NOTE: What happens when we call something not mentioned in navigation graph
//        registerFragmentView.findViewById<Button>(R.id.btn_to_main).setOnClickListener{
//            /// as this path is not defined in the graph, so, we cannot call it,
//            /// calling it will throw
//            /// java.lang.IllegalArgumentException: Navigation action/destination com.example.androidnavigation:id/action_loginFragment_to_mainFragment cannot be found from the current destination
//            findNavController().navigate(R.id.action_loginFragment_to_mainFragment)
//        }

        return registerFragmentView
    }
}