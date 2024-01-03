package com.greensuper.GreenSuper.services.auth;


import com.greensuper.GreenSuper.dto.LoginDto;
import com.greensuper.GreenSuper.dto.RegisterDto;

public interface AuthService {
    String register (RegisterDto registerDto);

    String login(LoginDto loginDto);
}
