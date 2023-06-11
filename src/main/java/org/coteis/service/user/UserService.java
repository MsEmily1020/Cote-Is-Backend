package org.coteis.service.user;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.coteis.domain.user.User;
import org.coteis.dto.user.AddUserRequest;
import org.coteis.dto.user.UpdateUserRequest;
import org.coteis.repository.user.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    public User save(AddUserRequest request){
        return userRepository.save(request.toEntity());
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public void delete(long id) {
        userRepository.deleteById(id);
    }

    @Transactional
    public User update(long id, UpdateUserRequest request){
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
