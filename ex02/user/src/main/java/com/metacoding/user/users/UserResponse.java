package com.metacoding.user.users;

import com.metacoding.user.domain.user.User;

public record UserResponse(
    int id,
    String username,
    String email
) {
    public static UserResponse from(User user) {
        return new UserResponse(
            user.getId(),
            user.getUsername(),
            user.getEmail()
        );
    }
}
