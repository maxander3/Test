package com.example.test.data

import com.example.test.data.api.UserApi
import com.example.test.domain.UserRepository
import com.example.test.domain.model.toUserDataVO
import com.example.test.ui.model.UserDataVO
import javax.inject.Inject


class UserRepositoryImpl @Inject constructor(private val userApi: UserApi) : UserRepository {


    override suspend fun getUsers(): List<UserDataVO> {
        return userApi.listUsers().map { it.toUserDataVO() }
    }
}