package com.codegik.poc.validation.validator

import com.codegik.poc.validation.annotation.MaxSize
import java.util.regex.Pattern

class Validator {

    fun checkEmail(email: Any): Pair<Boolean, String> {
        if (email !is String) {
            return Pair(false, "email is not String")
        }

        val result = Pattern.compile(
            "^(([\\w-]+\\.)+[\\w-]+|([a-zA-Z]|[\\w-]{2,}))@"
                    + "((([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                    + "[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\."
                    + "([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                    + "[0-9]{1,2}|25[0-5]|2[0-4][0-9]))|"
                    + "([a-zA-Z]+[\\w-]+\\.)+[a-zA-Z]{2,4})$"
        ).matcher(email.toString()).matches()

        return if (result) Pair(result, "ok") else Pair(result, "email is invalid")
    }

    fun checkMaxSize(size: Any, max: MaxSize): Pair<Boolean, String> {
        if (size !is Int) {
            return Pair(false, "size is not Integer")
        }

        return  if (size <= max.size) Pair(true, "ok")
                else Pair(false, "size exceeded the limit of ${max.size}")
    }
}