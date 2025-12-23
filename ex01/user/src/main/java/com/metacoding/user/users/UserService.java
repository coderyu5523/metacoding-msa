package com.metacoding.user.users;

import com.metacoding.user.core.util.JwtUtil;
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

    public UserResponse.DTO findById(int id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));
        return new UserResponse.DTO(user);
    }

    public List<UserResponse.DTO> findAll() {
        List<User> users = userRepository.findAll();
        return users.stream()
                .map(UserResponse.DTO::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public String login(UserRequest.LoginDTO requestDTO) {
        User user = userRepository.findByUsername(requestDTO.username())
                .orElseThrow(() -> new RuntimeException("Invalid username or password"));
        user.validatePassword(requestDTO.password());   
        return jwtUtil.create(user.getId(), user.getUsername());
    }
}
