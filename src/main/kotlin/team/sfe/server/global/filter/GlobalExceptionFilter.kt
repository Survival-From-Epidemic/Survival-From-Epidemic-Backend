package team.sfe.server.global.filter

import com.fasterxml.jackson.databind.ObjectMapper
import jakarta.servlet.FilterChain
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.http.MediaType
import org.springframework.web.filter.OncePerRequestFilter
import team.sfe.server.global.error.CustomException
import team.sfe.server.global.error.ErrorResponse
import java.nio.charset.StandardCharsets

class GlobalExceptionFilter(
    private val objectMapper: ObjectMapper,
) : OncePerRequestFilter() {

    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        filterChain: FilterChain,
    ) {
        try {
            filterChain.doFilter(request, response)
        } catch (e: CustomException) {
            setErrorResponse(e.status, e.message, response)
        }
    }

    private fun setErrorResponse(status: Int, message: String, response: HttpServletResponse) {
        response.apply {
            this.status = status
            this.contentType = MediaType.APPLICATION_JSON_VALUE
            this.characterEncoding = StandardCharsets.UTF_8.name()
            this.writer.write(objectMapper.writeValueAsString(ErrorResponse.of(status, message)))
        }
    }
}
