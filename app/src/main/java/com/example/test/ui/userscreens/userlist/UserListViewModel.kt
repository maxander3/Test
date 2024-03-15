package com.example.test.ui.userscreens.userlist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.test.domain.UserRepository
import com.example.test.ui.model.UserDataVO
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserListViewModel @Inject constructor(repository: UserRepository) : ViewModel() {

    private val _usersList = MutableLiveData<List<UserDataVO>>()
    val usersList: LiveData<List<UserDataVO>> get() = _usersList

    private val _error = MutableLiveData<Unit>()
    val error: LiveData<Unit> get() = _error

    init {
        viewModelScope.launch {
            try {
                _usersList.postValue(repository.getUsers())
            } catch (e: Throwable) {
                _error.postValue(Unit)
            }
        }
    }
}