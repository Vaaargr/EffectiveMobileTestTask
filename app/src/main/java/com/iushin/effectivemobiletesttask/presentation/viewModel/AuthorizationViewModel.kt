package com.iushin.effectivemobiletesttask.presentation.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.iushin.domain.api.interactors.AuthorizationInteractor
import com.iushin.domain.entity.SignInState
import com.iushin.domain.entity.SignUpState
import com.iushin.effectivemobiletesttask.presentation.state.AuthorizationUIState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AuthorizationViewModel(private val authInteracor: AuthorizationInteractor) : ViewModel() {

    private val authUIStateLD =
        MutableLiveData<AuthorizationUIState>(AuthorizationUIState.ENTRANCE)

    private val signUpStateLD = MutableLiveData<SignUpState>()

    private val signInStateLD = MutableLiveData<SignInState>()

    fun observeAuthorizationUIState(): LiveData<AuthorizationUIState> = authUIStateLD

    fun observeSignUpState(): LiveData<SignUpState> = signUpStateLD

    fun observeSignInState(): LiveData<SignInState> = signInStateLD

    private fun setAuthorizationUIState(state: AuthorizationUIState) {
        authUIStateLD.value = state
    }

    private fun setSignUpState(state: SignUpState) {
        signUpStateLD.value = state
    }

    private fun setSignInState(state: SignInState) {
        signInStateLD.value = state
    }

    fun changeUIState() {
        when (authUIStateLD.value) {
            AuthorizationUIState.ENTRANCE -> setAuthorizationUIState(AuthorizationUIState.REGISTRATION)
            AuthorizationUIState.REGISTRATION -> setAuthorizationUIState(AuthorizationUIState.ENTRANCE)
            null -> setAuthorizationUIState(AuthorizationUIState.ENTRANCE)
        }
    }

    fun signUpButtonPressed(email: String, password: String) {
        viewModelScope.launch(Dispatchers.IO) {
            authInteracor.createUser(email = email, password = password) { state ->
                setSignUpState(state)
            }
        }
    }

    fun signInButtonPressed(email: String, password: String) {
        viewModelScope.launch(Dispatchers.IO) {
            authInteracor.logIn(email = email, password = password) { state ->
                setSignInState(state)
            }
        }
    }
}