package com.metacoding.user.users;

import com.metacoding.user.core.util.JwtUtil;
import com.metacoding.user.domain.user.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
@Transactional(readOnly = true)
public class UserService {
    private final UserRepository userRepository;
    private final JwtUtil jwtUtil;

    public User findById(int id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));
        return user;
    }

    public List<User> findAll() {
        List<User> users = userRepository.findAll();
        return users.stream()
                .collect(Collectors.toList());
    }

    @Transactional
    public String login(UserRequest request) {
        User user = userRepository.findByUsername(request.username())
                .orElseThrow(() -> new RuntimeException("Invalid username or password"));

        user.validatePassword(request.password());   
        return jwtUtil.create(user.getId(), user.getUsername());
    }
}
