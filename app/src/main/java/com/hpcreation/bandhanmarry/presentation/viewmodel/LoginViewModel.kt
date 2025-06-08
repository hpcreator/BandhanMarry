package com.hpcreation.bandhanmarry.presentation.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class LoginViewModel : ViewModel() {
    private val _username = MutableStateFlow("")
    val username: StateFlow<String> = _username.asStateFlow()

    private val _password = MutableStateFlow("")
    val password: StateFlow<String> = _password.asStateFlow()

    private val _usernameError = MutableStateFlow<String?>(null)
    val usernameError: StateFlow<String?> = _usernameError.asStateFlow()

    private val _passwordError = MutableStateFlow<String?>(null)
    val passwordError: StateFlow<String?> = _passwordError.asStateFlow()

    private val _loginError = MutableStateFlow<String?>(null)
    val loginError: StateFlow<String?> = _loginError.asStateFlow()

    fun onUsernameChanged(newUsername: String) {
        _username.value = newUsername
        _usernameError.value = null
        _loginError.value = null
    }

    fun onPasswordChanged(newPassword: String) {
        _password.value = newPassword
        _passwordError.value = null
        _loginError.value = null
    }


    fun validateFields(): Boolean {
        var valid = true

        if (_username.value.isBlank()) {
            _usernameError.value = "Username cannot be empty"
            valid = false
        } else if (_username.value.length < 4) {
            _usernameError.value = "Username must be at least 4 characters"
            valid = false
        }

        if (_password.value.isBlank()) {
            _passwordError.value = "Password cannot be empty"
            valid = false
        } else if (_password.value.length < 6) {
            _passwordError.value = "Password must be at least 6 characters"
            valid = false
        }

        return valid
    }

    fun login() {
        val valid = validateFields()
        if (!valid) {
            _loginError.value = "Please fix the errors above"
            return
        }
        _loginError.value = null
        // TODO: Trigger real authentication
    }
}