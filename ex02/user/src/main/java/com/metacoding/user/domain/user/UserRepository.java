package com.metacoding.user.domain.user;

import java.util.*;

public interface UserRepository {
    Optional<User> findById(int id);
    Optional<User> findByUsername(String username);
    User save(User user);
    List<User> findAll();
}






