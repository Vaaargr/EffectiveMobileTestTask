package com.iushin.effectivemobiletesttask.presentation.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.iushin.domain.impl.SignOutUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivityViewModel(private val signOut: SignOutUseCase): ViewModel() {
    fun signOut(){
        viewModelScope.launch(Dispatchers.IO) {
            signOut.execute()
        }
    }
}