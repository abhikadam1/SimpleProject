package com.example.SimpleProject.Model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Table(name = "users") // Good practice to use plural table names
@Data // Lombok annotation for getters, setters, toString, equals, hashCode
@NoArgsConstructor // Lombok for no-args constructor
@AllArgsConstructor // Lombok for all-args constructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    // Default role for security access control
    private String role;
}