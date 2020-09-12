package com.talissonmelo.microserviceuser.model;

import com.sun.javafx.geom.transform.Identity;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String username;
    private String password;

    @Enumerated(value = EnumType.STRING)
    private Role role;
}
