package org.coteis.service.user;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.coteis.domain.user.User;
import org.coteis.dto.user.AddUserRequest;
import org.coteis.dto.user.UpdateUserRequest;
import org.coteis.repository.user.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    // create
    public User save(AddUserRequest request){ return userRepository.save(request.toEntity()); }

    // read
    public List<User> findAll() {
        return userRepository.findAll();
    }

    // delete
    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    // update
    @Transactional
    public User update(Long id, UpdateUserRequest request){
        User user = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found: " + id));
        user.update(
                request.getUserName(),
                request.getUserId(),
                request.getUserPw(),
                request.getUserEmail()
        );

        return user;
    }
}
