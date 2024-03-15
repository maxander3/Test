package com.example.test.data.api

import com.example.test.domain.model.UserData
import retrofit2.http.GET


interface UserApi {
    @GET("users")
    suspend fun listUsers(): List<UserData>
}