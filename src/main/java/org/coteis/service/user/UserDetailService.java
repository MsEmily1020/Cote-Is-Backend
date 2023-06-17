package org.coteis.service.user;

import lombok.RequiredArgsConstructor;
import org.coteis.domain.user.User;
import org.coteis.repository.user.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailService implements UserDetailsService {
    private final UserRepository userRepository;
    @Override
    public User loadUserByUsername(String userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException(userId));
    }
}
