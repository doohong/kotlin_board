package com.doohong.kotlin.error

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.client.HttpStatusCodeException

@ControllerAdvice
class GlobalExceptionHandler{
    /**
     * Validated로 binding error 발생시 발생한다.
     */
    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun handleMethodArgumentNotValidException(e: MethodArgumentNotValidException): ResponseEntity<ErrorResponse> {
        var response: ErrorResponse = ErrorResponse();
        return ResponseEntity(response,HttpStatus.BAD_REQUEST)
    }
}