package com.iushin.effectivemobiletesttask.presentation.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.iushin.domain.impl.GetCurrentUserNameUseCase
import kotlinx.coroutines.launch

class MainFragmentViewModel(private val userNameGetter: GetCurrentUserNameUseCase) : ViewModel() {
    private val userNameLD = MutableLiveData<String?>()

    fun observeUserName(): LiveData<String?> = userNameLD

    private fun setUserName(userName: String?){
        userNameLD.postValue(userName)
    }

    fun checkUserName(){
        viewModelScope.launch {
            setUserName(userNameGetter.execute())
        }
    }
}