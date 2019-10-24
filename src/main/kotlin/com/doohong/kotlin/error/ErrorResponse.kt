package com.doohong.kotlin.error

import org.springframework.validation.AbstractBindingResult
import org.springframework.validation.BindingResult
import java.util.stream.Collectors

class ErrorResponse(
        val message: String?,
        val status: Int?,
        val errors: List<FieldError>?,
        val code: String?
) {
    inner class FieldError(){
        private var field: String? = null
        private var value: String? = null
        private var reason: String? = null

        private constructor(field: String, value: String, reason: String): this(){
            this.field = field
            this.value = value
            this.reason = reason
        }
        fun of(field: String, value: String, reason: String): List<FieldError>{
            var fieldErrors = ArrayList<FieldError>()
            var fieldError = FieldError(field, value, reason);
            fieldErrors.add(fieldError)
            return fieldErrors
        }
        fun of(bindingResult: BindingResult): List<FieldError>{
            var fieldErrors = bindingResult.getFieldErrors();

            return fieldErrors.stream().map{error -> FieldError(
                    error.field, error.rejectedValue!!.toString(),error.defaultMessage!!)
            }.collect(Collectors.toList())
        }
    }
}