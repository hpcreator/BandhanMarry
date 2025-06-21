package com.hpcreation.bandhanmarry.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.hpcreation.bandhanmarry.domain.model.UserProfile
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

open class HomeViewModel : ViewModel() {
    private val _profiles = MutableStateFlow<List<UserProfile>>(emptyList())
    open val profiles: StateFlow<List<UserProfile>> = _profiles.asStateFlow()

    init {
        // TODO: Replace with your repository/network/database call
        _profiles.value = listOf(
            UserProfile(
                id = "1",
                memberId = "BM00001",
                name = "Harsh Joginbhai Patel",
                age = 27,
                birthYear = 1998,
                cast = "Kadva Patel",
                maritalStatus = "Unmarried",
                height = "5ft 5in - 164.00 cm",
                weight = "70.00kg",
                education = "BE - IT",
                occupation = "Software Professional",
                location = "Ahmedabad, GUJARAT, India",
                visaStatus = "No Specified",
                imageUrl = "https://lh3.googleusercontent.com/a/ACg8ocJ9l-pYf5P7S7ZqlekgI6HOt1gnKsXQOyatATJx9oc1vmezEQN0=s720-c-no"
            ), UserProfile(
                id = "1",
                memberId = "BM99092",
                name = "Khushi Joshi",
                age = 24,
                birthYear = 2001,
                cast = "Brahmin - Audichya",
                maritalStatus = "Unmarried",
                height = "5ft 1in - 154.00 cm",
                weight = "40.00kg",
                education = "BE - IT",
                occupation = "Software Professional",
                location = "Ahmedabad, GUJARAT, India",
                visaStatus = "No Specified",
                imageUrl = "https://images.unsplash.com/photo-1494790108377-be9c29b29330?w=1200&auto=format&fit=crop&q=60&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxzZWFyY2h8Mnx8dXNlciUyMHByb2ZpbGV8ZW58MHx8MHx8fDA%3D"
            ), UserProfile(
                id = "1",
                memberId = "BM99092",
                name = "Raj Shah",
                age = 24,
                birthYear = 2001,
                cast = "Brahmin - Audichya",
                maritalStatus = "Unmarried",
                height = "5ft 1in - 154.00 cm",
                weight = "40.00kg",
                education = "BE - IT",
                occupation = "Software Professional",
                location = "Baroda, GUJARAT, India",
                visaStatus = "No Specified",
                imageUrl = "https://images.unsplash.com/photo-1678286742832-26543bb49959?q=80&w=1288&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"
            )
        )
    }
}