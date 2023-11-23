package com.example.userlibrary


object UserValidate {
    fun validateSiginInfo(email: String, password: String): Boolean {
        return !(email.isBlank() || password.isBlank())
    }

    fun validateSignupInfo(
        email: String,
        password1: String,
        password2: String,
        username: String
    ): Boolean {
        return !(email.isBlank() || password1.isBlank() || password2.isBlank() || username.isBlank())
    }

    fun validatePassword(password1: String, password2: String):Boolean {
        return (password1 == password2)
    }
}