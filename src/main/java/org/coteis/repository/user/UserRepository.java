package org.coteis.repository.user;

import org.coteis.domain.user.User;
import org.coteis.dto.user.UserResponse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUserIdAndUserPw(String id, String pw);
}

