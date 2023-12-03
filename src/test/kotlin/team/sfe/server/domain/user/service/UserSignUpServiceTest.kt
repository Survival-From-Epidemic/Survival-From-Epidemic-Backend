// package team.sfe.server.domain.user.service
//
// import org.assertj.core.api.Assertions.assertThat
// import org.junit.jupiter.api.Test
// import org.junit.jupiter.api.assertThrows
// import org.springframework.beans.factory.annotation.Autowired
// import org.springframework.boot.test.context.SpringBootTest
// import org.springframework.transaction.annotation.Transactional
// import team.sfe.server.domain.user.domain.UserEntity
// import team.sfe.server.domain.user.domain.repository.UserRepository
// import team.sfe.server.domain.user.domain.type.Authority.USER
// import team.sfe.server.domain.user.exception.UserAlreadyExistsException
// import team.sfe.server.domain.user.presentation.request.UserSignUpRequest
//
// @Transactional
// @SpringBootTest
// class UserSignUpServiceTest @Autowired constructor(
//    private val userSignUpService: UserSignUpService,
//    private val userRepository: UserRepository
// ) {
//
//    @Test
//    fun `아이디와 비밀번호를 받아 사용자 정보를 db에 저장한다`() {
//        // given
//        val request = UserSignUpRequest(
//            accountId = "강민",
//            password = "password"
//        )
//
//        // when
//        val tokenResponse = userSignUpService.execute(request)
//
//        // then
//        assertThat(tokenResponse.accessToken).isNotBlank()
//        assertThat(tokenResponse.refreshToken).isNotBlank()
//    }
//
//    @Test
//    fun `받아온 아이디가 중복이다`() {
//        // given
//
//        val userEntity = UserEntity(
//            accountId = "강민",
//            password = "password2",
//            authority = USER
//        )
//        val savedUserEntity = userRepository.save(userEntity)
//
//        val request = UserSignUpRequest(
//            accountId = userEntity.accountId,
//            password = userEntity.password
//        )
//
//        // when & then
//        assertThrows<UserAlreadyExistsException> {
//            userSignUpService.execute(request)
//        }
//    }
// }
