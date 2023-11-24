package com.example.userlibrary
data class ValidateResult(val result: Boolean, val message: String)

object UserValidate {
    private fun validateEmail(email: String): Boolean {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    private fun isEmptySigninInfo(email: String, password: String): Boolean {
        return !(email.isBlank() || password.isBlank())
    }

    private fun isEmptySignupInfo(
        email: String,
        password1: String,
        password2: String,
        username: String
    ): Boolean {
        return !(email.isBlank() || password1.isBlank() || password2.isBlank() || username.isBlank())
    }

    private fun validatePassword(passwordOne: String, passwordTwo: String): Boolean {
        return (passwordOne == passwordTwo)
    }

    fun isPossibleSignin(email: String, password: String): ValidateResult {
        if (!isEmptySigninInfo(email, password)) {
            return ValidateResult(result = false, message = "이메일 또는 비밀번호를 다시 확인해주세요.")
        }
        if (!validateEmail(email)) {
            return ValidateResult(result = false, message = "이메일을 다시 확인해주세요.")
        }
        if (password.length < 6) {
            return ValidateResult(result = false, message = "비밀번호는 6글자 이상 작성해야합니다.")
        }
        return ValidateResult(result = true, message = "로그인")
    }

    fun isPossibleSignup(
        email: String,
        passwordOne: String,
        passwordTwo: String,
        username: String
    ):ValidateResult {
        if(!isEmptySignupInfo(email, passwordOne, passwordTwo, username)){
            return ValidateResult(result = false, message = "빈 항목이 없는지 확인해주세요.")
        }

        if(!validateEmail(email)){
            return ValidateResult(result = false, message = "이메일을 다시 확인해주세요.")
        }

        if(passwordOne.length < 6){
            return ValidateResult(result = false, message = "비밀번호는 6글자 이상 작성해야합니다.")
        }

        if(!validatePassword(passwordOne, passwordTwo)){
            return ValidateResult(result = false, message = "비밀번호가 서로 다릅니다.")
        }

        return ValidateResult(result = true, message = "회원가입")
    }
}