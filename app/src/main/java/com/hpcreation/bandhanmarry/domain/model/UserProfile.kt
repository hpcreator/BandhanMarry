package com.hpcreation.bandhanmarry.domain.model

data class UserProfile(
    val id: String,
    val memberId: String,
    val name: String,
    val age: Int,
    val birthYear: Int,
    val cast: String,
    val maritalStatus: String,
    val height: String,
    val weight: String,
    val education: String,
    val occupation: String,
    val location: String,
    val visaStatus: String,
    val imageUrl: String
)