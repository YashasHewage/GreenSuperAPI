package com.greensuper.GreenSuper.services.auth;

import com.greensuper.GreenSuper.dto.SingupRequest;
import com.greensuper.GreenSuper.dto.UserDto;

public interface AuthService {
    UserDto createUser(SingupRequest signupRequest);

    Boolean hasUserWithEmail(String email);
}
