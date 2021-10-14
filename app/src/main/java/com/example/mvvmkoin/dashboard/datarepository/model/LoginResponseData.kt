package com.coderio.pocmvvmandroid.registration.model

import com.google.gson.annotations.SerializedName

data class LoginResponseData(
    @SerializedName("name") val name: String,
    @SerializedName("lastName") val lastName: String,
    @SerializedName("phoneNumber") val phoneNumber: String,
    @SerializedName("company") val company: String,
    @SerializedName("userName") val userName: String,
    @SerializedName("token") val token: String
)