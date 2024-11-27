package com.iushin.effectivemobiletesttask.ui.activity

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.iushin.domain.entity.SignInState
import com.iushin.domain.entity.SignUpState
import com.iushin.effectivemobiletesttask.R
import com.iushin.effectivemobiletesttask.databinding.ActivityAuthorizationBinding
import com.iushin.effectivemobiletesttask.presentation.viewModel.AuthorizationViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class AuthorizationActivity : AppCompatActivity() {
    private var _binding: ActivityAuthorizationBinding? = null
    private val binding get() = _binding!!

    private val viewModel by viewModel<AuthorizationViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityAuthorizationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.observeAuthorizationUIState().observe(this) { state ->
            showAuthorizationUI(state.state)
        }

        viewModel.observeSignUpState().observe(this) { state ->
            when (state) {
                SignUpState.SignUpSuccessful -> goToMainActivity()
                is SignUpState.SignUpUnSuccessful -> {
                    if (!state.message.isNullOrEmpty()) {
                        showToast(state.message!!)
                    } else {
                        showToast(getString(R.string.uncnown_exception))
                    }
                }
            }
        }

        viewModel.observeSignInState().observe(this) { state ->
            when (state) {
                SignInState.SUCCESSFUL -> goToMainActivity()
                SignInState.UNSUCCESSFUL -> {
                    showToast(getString(R.string.login_error))
                }
            }
        }

        binding.signUpLink.setOnClickListener {
            viewModel.changeUIState()
        }

        binding.signInLink.setOnClickListener {
            viewModel.changeUIState()
        }

        binding.signUpButton.setOnClickListener {
            if (signUpCheckDate()) viewModel.signUpButtonPressed(
                binding.emailEt.text.toString(),
                binding.passwordEt.text.toString()
            )
        }

        binding.signInButton.setOnClickListener {
            if (signInCheckDate()) viewModel.signInButtonPressed(
                binding.emailEt.text.toString(),
                binding.passwordEt.text.toString()
            )
        }
    }

    private fun showAuthorizationUI(state: Boolean) {
        with(binding) {
            if (state) {
                headerTv.text = getString(R.string.sign_in)
            } else {
                headerTv.text = getString(R.string.sign_up)
            }
            signUpLl.isVisible = !state
            signInLl.isVisible = state
        }
    }

    private fun goToMainActivity() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

    private fun signUpCheckDate(): Boolean {
        val email = binding.emailEt.text.toString()
        val password = binding.passwordEt.text.toString()
        val passwordRepeat = binding.passwordRepeatEt.text.toString()

        if (email.isEmpty()) {
            showToast(getString(R.string.email_empty))
            return false
        }
        if (password.isEmpty()) {
            showToast(getString(R.string.password_empty))
            return false
        }
        if (passwordRepeat.isEmpty()) {
            showToast(getString(R.string.password_repetition_empty))
            return false
        }
        if (password.length < 8) {
            showToast(getString(R.string.password_shot))
            return false
        }
        if (password == passwordRepeat) {
            return true
        } else {
            showToast(getString(R.string.password_must_match))
            return false
        }
    }

    private fun signInCheckDate(): Boolean {
        val email = binding.emailEt.text.toString()
        val password = binding.passwordEt.text.toString()

        if (email.isEmpty()) {
            showToast(getString(R.string.email_empty))
            return false
        }
        if (password.isEmpty()) {
            showToast(getString(R.string.password_empty))
            return false
        }
        if (password.length < 8) {
            showToast(getString(R.string.password_shot))
            return false
        } else {
            return true
        }
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}