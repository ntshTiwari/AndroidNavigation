package com.example.androidnavigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.androidnavigation.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {

    private var _loginBinding: FragmentLoginBinding? = null
    private val loginBinding get() = _loginBinding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _loginBinding = FragmentLoginBinding.inflate(layoutInflater, container, false)

        loginBinding.btnLogin.setOnClickListener{
            findNavController().navigate(R.id.action_loginFragment_to_mainFragment)
        }

        return loginBinding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _loginBinding = null
    }
}