package ch.v7.backend.users

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/user")
class UserRessource {
    @GetMapping
    fun test(): String = "hello"
}
