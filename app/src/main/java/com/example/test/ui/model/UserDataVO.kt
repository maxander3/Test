package com.example.test.ui.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class UserDataVO(
    val id: Int,
    val name: String,
    val userName: String,
    val email: String,
    val address: String,
    val phone: String,
    val website: String,
    val company: String,
): Parcelable