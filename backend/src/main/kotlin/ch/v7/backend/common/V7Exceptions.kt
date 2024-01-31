package ch.v7.backend.common

class V7AuthorizationException(message: String) : Exception(message)

class V7ForbiddenException(message: String) : Exception(message)
