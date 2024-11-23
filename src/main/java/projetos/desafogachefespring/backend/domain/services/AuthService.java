package projetos.desafogachefespring.backend.domain.services;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import projetos.desafogachefespring.backend.domain.services.UserService;
import projetos.desafogachefespring.backend.utils.JwtUtils;


@Service
public class AuthService {

    private final AuthenticationManager authenticationManager;
    private final JwtUtils jwtUtils;
    private final UserService userService;

    public AuthService(AuthenticationManager authenticationManager, JwtUtils jwtUtils, UserService userDetailsService) {
        this.authenticationManager = authenticationManager;
        this.jwtUtils = jwtUtils;
        this.userService = userDetailsService;
    }

    public String login(String username, String password) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(username, password)
        );

        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        String role = userDetails.getAuthorities().iterator().next().getAuthority();
        return jwtUtils.generateToken(userDetails.getUsername(), role);
    }

    public boolean validateToken(String token) {
        return jwtUtils.isTokenValid(token);
    }
}
