package com.codegik.poc.validation.validator

import java.util.regex.Pattern

class EmailValidator: Validator {

    override fun validate(fileValue: Any, annotation: Any): Pair<Boolean, String> {
        if (fileValue !is String) {
            return Pair(false, "email is not String")
        }

        val result = Pattern.compile(
            "^(([\\w-]+\\.)+[\\w-]+|([a-zA-Z]|[\\w-]{2,}))@"
                    + "((([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                    + "[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\."
                    + "([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                    + "[0-9]{1,2}|25[0-5]|2[0-4][0-9]))|"
                    + "([a-zA-Z]+[\\w-]+\\.)+[a-zA-Z]{2,4})$"
        ).matcher(fileValue.toString()).matches()

        return if (result) Pair(result, "ok") else Pair(result, "email is invalid")
    }
}