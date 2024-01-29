package ch.v7.backend.user

import ch.v7.backend.jwt.TokenService
import ch.v7.backend.ressort.RessortService
import ch.v7.backend.role.RoleService
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.security.core.userdetails.UsernameNotFoundException
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
) {
    @GetMapping
    fun test(): String = "hello"

    @GetMapping("/whoami")
    fun getSelf(): String? {
        return "whoami"
        /*
        val user = userService.mapToDto(principal.user)
        return WhoamiDto(
            user = user,
            ressort = ressortService.getRessortsForUser(userId = user.id),
            role = roleService.getRolesForUserById(userId = user.id),
        )
        */
    }

    @PostMapping("/login")
    fun login(@RequestBody loginDto: LoginDto): LoginResponseDto {
        println(loginDto.email)

        val user = userService.findUserByEmail(loginDto.email) ?: throw UsernameNotFoundException("No user found for email")

        if (user.eMail != loginDto.email){
            throw UsernameNotFoundException("Wrong password")
        }
        return LoginResponseDto(
            user = userService.mapToDto(user),
            token = tokenService.createToken(user)
        )


    }
}
