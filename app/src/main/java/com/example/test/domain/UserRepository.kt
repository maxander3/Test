package com.example.test.domain

import com.example.test.ui.model.UserDataVO

interface UserRepository {

    suspend fun getUsers(): List<UserDataVO>
}