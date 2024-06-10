package com.videoplatform.videoplatform.controllers;

import com.videoplatform.videoplatform.dtos.AuthInfo;
import com.videoplatform.videoplatform.dtos.ResponseHandler;
import com.videoplatform.videoplatform.services.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;


    @PostMapping("/authenticate")
    public ResponseEntity<Object> authenticate( @RequestBody AuthInfo authInfo) {
        return ResponseHandler.successResponse(HttpStatus.OK, authService.authenticate(authInfo));
    }
    @PostMapping("/signup")
    public ResponseEntity<Object> signup( @RequestBody AuthInfo authInfo) {
        return ResponseHandler.successResponse(HttpStatus.OK, authService.signup(authInfo));
    }
}
