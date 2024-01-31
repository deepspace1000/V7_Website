package ch.v7.backend.common

import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.context.request.WebRequest
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler

@ControllerAdvice
class V7ExceptionHandler : ResponseEntityExceptionHandler() {
    @ExceptionHandler(V7AuthorizationException::class)
    fun handleUnauthorized(
        ex: V7AuthorizationException,
        request: WebRequest,
    ): ResponseEntity<Any>? = handleExceptionInternal(ex, ex.message, HttpHeaders(), HttpStatus.UNAUTHORIZED, request)
}
