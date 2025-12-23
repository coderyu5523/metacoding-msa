package com.metacoding.user.users;

import com.metacoding.user.domain.user.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepositoryImpl extends JpaRepository<User, Integer>, UserRepository {
}
