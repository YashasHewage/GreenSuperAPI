package com.greensuper.GreenSuper.services.auth;


import com.greensuper.GreenSuper.dto.LoginDto;
import com.greensuper.GreenSuper.dto.RegisterDto;
import com.greensuper.GreenSuper.entity.Role;
import com.greensuper.GreenSuper.entity.User;
import com.greensuper.GreenSuper.exception.GreenSuperMarketApiException;
import com.greensuper.GreenSuper.repository.RoleRepository;
import com.greensuper.GreenSuper.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@AllArgsConstructor
public class AuthServiceImpl implements AuthService{


    private UserRepository userRepository;

    private RoleRepository roleRepository;

    private PasswordEncoder passwordEncoder;

    private AuthenticationManager authenticationManager;
    @Override
    public String register(RegisterDto registerDto) {

        //check email is already exists in database
        if (userRepository.existsByEmail(registerDto.getEmail())){
            throw new GreenSuperMarketApiException(HttpStatus.BAD_REQUEST,"Username already exists !");
        }

        User user = new User();
        user.setFirstName(registerDto.getFirstName());
        user.setLastName(registerDto.getLastName());
        user.setEmail(registerDto.getEmail());
        user.setPassword(passwordEncoder.encode(registerDto.getPassword()));

        Set<com.greensuper.GreenSuper.entity.Role> roles = new HashSet<>();

        Role userRole = roleRepository.findByName("ROLE_USER");
        roles.add(userRole);
        user.setRoles(roles);

        userRepository.save(user);

        return "User Registered Successfully !.";
    }

    @Override
    public String login(LoginDto loginDto) {
         Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                 loginDto.getEmail(),
                 loginDto.getPassword()
         ));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        return "User logged-in successfully!.";
    }
}

