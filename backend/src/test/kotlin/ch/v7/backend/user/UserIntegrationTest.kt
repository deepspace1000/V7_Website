package ch.v7.backend.user

import ch.v7.backend.IntegrationTest
import ch.v7.backend.utils.createRessortFromTemplate
import ch.v7.backend.utils.createRoleFromTemplate
import ch.v7.backend.utils.createUserFromTemplate
import ch.v7.backend.utils.createUserRessortFromTemplate
import ch.v7.backend.utils.createUserRoleFromTemplate
import ch.v7.backend.utils.deleteAll
import ch.v7.backend.utils.runInTransaction
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.web.reactive.function.BodyInserters

class UserIntegrationTest: IntegrationTest() {
    @BeforeEach
    fun seedDatabase() {
        transactionManager.runInTransaction {
            userDao.insert(createUserFromTemplate())
            ressortDao.insert(createRessortFromTemplate())
            roleDao.insert(createRoleFromTemplate())
            userRessortDao.insert(createUserRessortFromTemplate())
            userRoleDao.insert(createUserRoleFromTemplate())
        }

    }

    @AfterEach
    fun deleteDatabaseSeed() {
        transactionManager.runInTransaction {
            userRoleDao.deleteAll()
            userRessortDao.deleteAll()
            roleDao.deleteAll()
            ressortDao.deleteAll()
            userDao.deleteAll()

        }
    }

    @Test
    fun `should return current user`() {
        webClient.get()
            .uri("/user/whoami")
            .exchange()
            .expectBody()
            .jsonPath("$.user.email")
            .isEqualTo("testuser@gmail.com")
            .jsonPath("$.user.firstname")
            .isEqualTo("test")
            .jsonPath("$.user.lastname")
            .isEqualTo("user")
            .jsonPath("$.role.[0].name")
            .isEqualTo("ADMIN")
            .jsonPath("$.ressort.[0].name")
            .isEqualTo("Test Ressort")
            .jsonPath("$.ressort.[0].description")
            .isEqualTo("Test Ressort Description")
    }

    @Test
    fun `should not return data with invalid jws token`() {
        webClient.get()
            .uri("/user/whoami")
            .headers { httpHeader -> httpHeader.setBearerAuth("WrongToken") }
            .exchange()
            .expectStatus()
            .isUnauthorized

    }

    @Test
    fun `should return jws token with right credentials`() {
        val loginDto = LoginDto(
            email = "testuser@gmail.com",
            password = "test",
        )
        webClient.post()
            .uri("/user/login")
            .body(BodyInserters.fromValue(loginDto))
            .exchange()
            .expectStatus()
            .isOk
            .expectBody()
            .jsonPath("$.token")
            .exists()
    }

    @Test
    fun `should not return jws token with wrong email`() {
        val loginDto = LoginDto(
            email = "wrong@gmail.com",
            password = "test",
        )
        webClient.post()
            .uri("/user/login")
            .body(BodyInserters.fromValue(loginDto))
            .exchange()
            .expectStatus()
            .isUnauthorized
    }

    @Test
    fun `should not return jws token with wrong password`() {
        val loginDto = LoginDto(
            email = "testuser@gmail.com",
            password = "wrong password",
        )
        webClient.post()
            .uri("/user/login")
            .body(BodyInserters.fromValue(loginDto))
            .exchange()
            .expectStatus()
            .isUnauthorized
    }
}