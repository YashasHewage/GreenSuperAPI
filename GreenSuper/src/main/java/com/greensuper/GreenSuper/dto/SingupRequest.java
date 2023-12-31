package com.greensuper.GreenSuper.dto;

import lombok.Data;

@Data
public class SingupRequest {
    private String email;

    private String firstName;

    private String lastName;

    private String password;
}
