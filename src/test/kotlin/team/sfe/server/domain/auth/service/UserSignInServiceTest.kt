// package team.sfe.server.domain.auth.service
//
// import org.assertj.core.api.Assertions
// import org.junit.jupiter.api.Test
// import org.junit.jupiter.api.assertThrows
// import org.springframework.beans.factory.annotation.Autowired
// import org.springframework.boot.test.context.SpringBootTest
// import org.springframework.security.crypto.password.PasswordEncoder
// import org.springframework.transaction.annotation.Transactional
// import team.sfe.server.domain.auth.exception.PasswordMisMatchException
// import team.sfe.server.domain.user.domain.UserEntity
// import team.sfe.server.domain.user.domain.repository.UserRepository
// import team.sfe.server.domain.user.domain.type.Authority.USER
// import team.sfe.server.domain.user.exception.UserNotFoundException
// import team.sfe.server.domain.user.presentation.request.UserSignInRequest
//
// @Transactional
// @SpringBootTest
// class UserSignInServiceTest @Autowired constructor(
//    private val userSignInService: UserSignInService,
//    private val userRepository: UserRepository,
//    private val passwordEncoder: PasswordEncoder
// ) {
//
//    @Test
//    fun `아디이와 비밀번호를 받아 사용자가 존재하는지 비밀번호가 일치하는지 확인 후 토큰을 발급해준다`() {
//        // given
//        val request = UserSignInRequest(
//            accountId = "강민",
//            password = "password"
//        )
//
//        val userEntity = UserEntity(
//            accountId = request.accountId,
//            password = passwordEncoder.encode(request.password),
//            authority = USER
//        )
//        userRepository.save(userEntity)
//
//        // when
//        val tokenResponse = userSignInService.execute(request)
//
//        // then
//        Assertions.assertThat(tokenResponse.accessToken).isNotBlank()
//        Assertions.assertThat(tokenResponse.refreshToken).isNotBlank()
//    }
//
//    @Test
//    fun `사용자로부터 받은 아이디와 db에 있는 아이디가 다르다`() {
//        // given
//        val request = UserSignInRequest(
//            accountId = "강민",
//            password = "password"
//        )
//
//        val userEntity = UserEntity(
//            accountId = "김민수",
//            password = passwordEncoder.encode(request.password),
//            authority = USER
//        )
//        userRepository.save(userEntity)
//
//        // when & then
//        assertThrows<UserNotFoundException> {
//            userSignInService.execute(request)
//        }
//    }
//
//    @Test
//    fun `사용자로부터 받은 비밀번호와 db에 있는 비밀번호가 다르다`() {
//        // given
//        val request = UserSignInRequest(
//            accountId = "강민",
//            password = "password"
//        )
//
//        val userEntity = UserEntity(
//            accountId = request.accountId,
//            password = passwordEncoder.encode("different-password"),
//            authority = USER
//        )
//        userRepository.save(userEntity)
//
//        // when & then
//        assertThrows<PasswordMisMatchException> {
//            userSignInService.execute(request)
//        }
//    }
// }
