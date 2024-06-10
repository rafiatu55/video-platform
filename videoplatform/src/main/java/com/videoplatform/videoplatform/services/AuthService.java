package com.videoplatform.videoplatform.services;

import com.videoplatform.videoplatform.dtos.AuthInfo;

public interface AuthService {
    String authenticate(AuthInfo authInfo);
    String signup(AuthInfo authInfo);
}
