package com.kyzen.authnauthz.controller;

import com.kyzen.authnauthz.service.TokenService;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1")
public class AuthController {

    private final TokenService tokenService;

    public AuthController(TokenService tokenService) {
        this.tokenService = tokenService;
    }
    @GetMapping("/auth/token")
    public String token(Authentication authentication) {
        return tokenService.generateToken(authentication);
    }

}
