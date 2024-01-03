package com.greensuper.GreenSuper.controller;

import com.greensuper.GreenSuper.dto.LoginDto;
import com.greensuper.GreenSuper.dto.RegisterDto;
import com.greensuper.GreenSuper.services.auth.AuthService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final AuthService authService;


    @PostMapping("/register")
    //Build Register REST API
    public ResponseEntity<String> register(@RequestBody RegisterDto registerDto){
        String response = authService.register(registerDto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    //Build Login REST API
    public  ResponseEntity<String> login (@RequestBody LoginDto loginDto) {
        String response = authService.login(loginDto);
        return  new ResponseEntity<>(response, HttpStatus.OK);

    }

}
