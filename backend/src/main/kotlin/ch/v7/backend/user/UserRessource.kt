package ch.v7.backend.user

import ch.v7.backend.common.V7AuthorizationException
import ch.v7.backend.jwt.TokenService
import ch.v7.backend.ressort.RessortService
import ch.v7.backend.role.RoleService
import ch.v7.backend.security.MyUserDetails
import ch.v7.backend.security.PasswordService
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/user")
class UserRessource(
    private val userService: UserService,
    private val ressortService: RessortService,
    private val roleService: RoleService,
    private val tokenService: TokenService,
    private val passwordService: PasswordService,
) {
    @GetMapping("/whoami")
    fun getSelf(@AuthenticationPrincipal principal: MyUserDetails): WhoamiDto {
        val user = userService.mapToDto(principal.user)
        return WhoamiDto(
            user = user,
            ressort = ressortService.getRessortsForUser(userId = user.id),
            role = roleService.getRolesForUserById(userId = user.id),
        )
    }

    @PostMapping("/login")
    fun login(@RequestBody loginDto: LoginDto): LoginResponseDto {
        val user = userService.findUserByEmail(loginDto.email)
            ?: throw V7AuthorizationException("Wrong login credentials")

        if (!passwordService.isPasswordMatchingHash(loginDto.password, user.password)) {
            throw V7AuthorizationException("Wrong login credentials")
        }

        return LoginResponseDto(
            token = tokenService.createJwtToken(user.id),
        )
    }
}
