package team.sfe.server.global.filter

import jakarta.servlet.FilterChain
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.web.filter.OncePerRequestFilter
import team.sfe.server.global.security.jwt.JwtConstant.HEADER
import team.sfe.server.global.security.jwt.JwtConstant.PREFIX
import team.sfe.server.global.security.jwt.JwtParser

class JwtFilter(
    private val jwtParser: JwtParser
) : OncePerRequestFilter() {

    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        filterChain: FilterChain,
    ) {
        val token = getToken(request)
        token?.let {
            TODO()
        }
        filterChain.doFilter(request, response)
    }

    private fun getToken(request: HttpServletRequest): String? {
        val token = request.getHeader(HEADER)

        return if (token.isNotEmpty() && token.startsWith(PREFIX)) token.substring(PREFIX.length)
        else null;
    }
}
