package com.in28min.rest.webservices.todo.auth;

import com.in28min.rest.webservices.todo.service.JwtTokenService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class JwtAuthController {

    private final JwtTokenService tokenService;

    private final AuthenticationManager authenticationManager;

    public JwtAuthController(JwtTokenService jwtTokenService, AuthenticationManager authenticationManager){
        this.tokenService = jwtTokenService;
        this.authenticationManager = authenticationManager;
    }

    @PostMapping("/auth")
    public ResponseEntity<JwtTokenResponse> generateToken(@RequestBody JwtTokenRequest jwtTokenRequest){
        UsernamePasswordAuthenticationToken userToken = new UsernamePasswordAuthenticationToken(jwtTokenRequest.username(), jwtTokenRequest.password());
        Authentication authentication = authenticationManager.authenticate(userToken);

        String jwtToken = tokenService.generateToken(authentication);
        return ResponseEntity.ok(new JwtTokenResponse(jwtToken));
    }
}
