package com.greensuper.GreenSuper.entity;


import com.greensuper.GreenSuper.enums.UserRole;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String password;
    private String email;

    private UserRole role;

    @Lob
    @Column(columnDefinition = "longblob")
    private byte[] img;


}
