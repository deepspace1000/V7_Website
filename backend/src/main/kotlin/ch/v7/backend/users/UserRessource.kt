package ch.v7.backend.users

import ch.v7.backend.security.MyUserDetails
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/user")
class UserRessource {
    @PreAuthorize("@UserAccessAuthorizer.isUser(#root.authentication.principal)")
    @GetMapping
    fun test(@AuthenticationPrincipal principal: MyUserDetails): String = "hello"
}
