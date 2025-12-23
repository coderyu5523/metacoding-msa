package com.metacoding.user.users;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@Getter
@Entity
@Table(name = "user_tb")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String username;
    private String email;
    private String password;

    @Builder
    private User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public boolean authenticate(String password) {
        return this.password.equals(password);
    }

    public void validatePassword(String password) {
        if (!authenticate(password)) {
            throw new RuntimeException("Invalid username or password");
        }
    }
}
