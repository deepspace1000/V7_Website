package ch.v7.backend.user

import ch.v7.backend.ressort.RessortService
import ch.v7.backend.role.RoleService
import ch.v7.backend.security.MyUserDetails
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/user")
class UserRessource(
    private val userService: UserService,
    private val ressortService: RessortService,
    private val roleService: RoleService,
) {
    @GetMapping
    fun test(@AuthenticationPrincipal principal: MyUserDetails): String = "hello"

    @GetMapping("/whoami")
    fun getSelf(@AuthenticationPrincipal principal: MyUserDetails): WhoamiDto? {
        val user = userService.mapToDto(principal.user)
        return WhoamiDto(
            user = user,
            ressort = ressortService.getRessortsForUser(userId = user.id),
            role = roleService.getRolesForUserById(userId = user.id),
        )
    }
}
