package com.hpcreation.bandhanmarry.domain.model

import androidx.annotation.DrawableRes

data class ProfileItem(
    @DrawableRes val icon: Int, val label: String, val value: String
)