package com.example.gadgetgalaxy.ui.splash

import android.os.Bundle
import android.os.Handler
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.gadgetgalaxy.R
import com.example.gadgetgalaxy.common.viewBinding
import com.example.gadgetgalaxy.databinding.FragmentSplashBinding
import com.example.gadgetgalaxy.ui.login.AuthViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SplashFragment : Fragment(R.layout.fragment_splash) {

    private val binding by viewBinding(FragmentSplashBinding::bind)
    private val viewModel by viewModels<AuthViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding) {
            Handler().postDelayed(Runnable {
                if (checkCurrentUser()) {
                    findNavController().navigate(SplashFragmentDirections.splashToHome())
                } else {
                    findNavController().navigate(SplashFragmentDirections.splashToSignin())
                }
            }, 3000)

        }
    }

    private fun checkCurrentUser(): Boolean {
        return viewModel.currentUser != null
    }
}
