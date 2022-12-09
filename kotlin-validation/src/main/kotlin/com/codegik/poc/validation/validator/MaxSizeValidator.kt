package com.codegik.poc.validation.validator

import com.codegik.poc.validation.annotation.MaxSize

class MaxSizeValidator: Validator {

    override fun validate(fieldValue: Any, annotation: Any): Pair<Boolean, String> {
        if (fieldValue !is Int) {
            return Pair(false, "fieldValue is not Integer")
        }

        val a = annotation as MaxSize

        return  if (fieldValue <= a.size) Pair(true, "ok")
                else Pair(false, "size exceeded the limit of ${a.size}")
    }
}