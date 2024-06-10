package com.videoplatform.videoplatform.services.impl;

import com.videoplatform.videoplatform.dtos.AuthInfo;
import com.videoplatform.videoplatform.enums.Role;
import com.videoplatform.videoplatform.exceptions.UserException;
import com.videoplatform.videoplatform.models.User;
import com.videoplatform.videoplatform.repositories.UserRepository;
import com.videoplatform.videoplatform.services.AuthService;
import com.videoplatform.videoplatform.services.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final JwtService jwtService;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public String authenticate(AuthInfo authInfo) {
        return jwtService.generateToken(authInfo.getEmail(),authInfo.getPassword());
    }

    @Override
    public String signup(AuthInfo authInfo) {
        Optional<User> userExist =  userRepository.findUserByEmail(authInfo.getEmail());
        if(userExist.isPresent()){
            throw new UserException("User already exists");
        }

        User user = User.builder()
                .email(authInfo.getEmail())
                .password(passwordEncoder.encode(authInfo.getPassword()))
                .role(Role.USER)
                .build();
        userRepository.save(user);

        return "";
    }
}
