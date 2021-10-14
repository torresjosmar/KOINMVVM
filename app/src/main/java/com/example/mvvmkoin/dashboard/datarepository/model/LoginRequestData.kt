package com.coderio.pocmvvmandroid.registration.model

import com.google.gson.annotations.SerializedName

data class LoginRequestData(
    @SerializedName("userName") val username: String,
    @SerializedName("password") val password: String
)