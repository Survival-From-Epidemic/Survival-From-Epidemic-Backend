//package team.sfe.server
//
//import org.junit.jupiter.api.BeforeEach
//import org.junit.jupiter.api.Test
//import org.junit.jupiter.api.extension.ExtendWith
//import org.springframework.boot.test.context.SpringBootTest
//import org.springframework.http.MediaType
//import org.springframework.restdocs.RestDocumentationContextProvider
//import org.springframework.restdocs.RestDocumentationExtension
//import org.springframework.restdocs.mockmvc.MockMvcRestDocumentation
//import org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document
//import org.springframework.test.web.servlet.MockMvc
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
//import org.springframework.test.web.servlet.result.MockMvcResultHandlers
//import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
//import org.springframework.test.web.servlet.setup.DefaultMockMvcBuilder
//import org.springframework.test.web.servlet.setup.MockMvcBuilders
//import org.springframework.web.context.WebApplicationContext
//
//@ExtendWith(RestDocumentationExtension::class)
//@SpringBootTest
//class SfeApiControllerDocTest {
//
//    private var mockMvc: MockMvc? = null
//
//    @BeforeEach
//    fun setUp(webApplicationcontext: WebApplicationContext, restDocumentaion: RestDocumentationContextProvider) {
//        this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationcontext)
//            .apply<DefaultMockMvcBuilder>(MockMvcRestDocumentation.documentationConfiguration(restDocumentaion))
//            .build()
//    }
//
//    @Test
//    fun `테스트 코드 테스트`() {
//        this.mockMvc!!.perform(
//            MockMvcRequestBuilders.get("/")
//                .accept(MediaType.APPLICATION_JSON)
//        )
//            .andExpect(status().isOk)
//            .andDo(MockMvcResultHandlers.print())
//            .andDo(document("index"))
//    }
//}
