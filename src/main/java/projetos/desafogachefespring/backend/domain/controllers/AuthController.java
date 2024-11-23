package projetos.desafogachefespring.backend.domain.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import projetos.desafogachefespring.backend.domain.services.AuthService;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestParam String username, @RequestParam String password) {
        String token = authService.login(username, password);
        return ResponseEntity.ok(token);
    }
}
