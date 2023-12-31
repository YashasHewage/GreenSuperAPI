package com.greensuper.GreenSuper.dto;

import com.greensuper.GreenSuper.enums.UserRole;
import lombok.Data;

@Data
public class UserDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private UserRole userRole;


}
