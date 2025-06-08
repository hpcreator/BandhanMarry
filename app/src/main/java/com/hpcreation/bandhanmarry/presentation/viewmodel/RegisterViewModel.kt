package com.hpcreation.bandhanmarry.presentation.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class RegisterViewModel : ViewModel() {
    private val _dob = MutableStateFlow("")
    val dob: StateFlow<String> = _dob.asStateFlow()

    private val _username = MutableStateFlow("")
    val username: StateFlow<String> = _username.asStateFlow()

    private val _firstName = MutableStateFlow("")
    val firstName: StateFlow<String> = _firstName.asStateFlow()

    private val _registerError = MutableStateFlow<String?>(null)
    val registerError: StateFlow<String?> = _registerError.asStateFlow()

    fun onDobChanged(newDob: String) {
        _dob.value = newDob
    }

    fun onUsernameChanged(newUsername: String) {
        _username.value = newUsername
    }

    fun onFirstNameChanged(newFirstName: String) {
        _firstName.value = newFirstName
    }

    fun register() {
        // Example validation (expand as needed)
        if (_dob.value.isBlank() || _username.value.isBlank() || _firstName.value.isBlank()) {
            _registerError.value = "All fields are required"
        } else {
            _registerError.value = null
            // TODO: Trigger registration event
        }
    }
}