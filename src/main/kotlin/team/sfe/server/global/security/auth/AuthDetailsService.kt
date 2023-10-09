package team.sfe.server.global.security.auth

import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Component

@Component
class AuthDetailsService : UserDetailsService {
    override fun loadUserByUsername(username: String?): UserDetails {
        TODO("Not yet implemented")
    }
}
