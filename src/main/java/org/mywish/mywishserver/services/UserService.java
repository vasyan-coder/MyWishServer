package org.mywish.mywishserver.services;

import lombok.AllArgsConstructor;
import org.mywish.mywishserver.entities.UserEntity;
import org.mywish.mywishserver.repositories.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public Optional<UserEntity> getUserById(Long id) {
        return userRepository.findById(id);
    }

    public Optional<UserEntity> getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public UserEntity createUser(UserEntity user) {
        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
            throw new IllegalArgumentException("Email already exists");
        }
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        return userRepository.save(user);
    }

    public UserEntity updateUser(Long id, UserEntity user) {
        UserEntity userEntity = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        userEntity.setEmail(user.getEmail());
        userEntity.setFullname(user.getFullname());
        userEntity.setDateOfBirth(user.getDateOfBirth());
        userEntity.setPassword(user.getPassword());
        userEntity.setFriends(user.getFriends());
        userEntity.setWishlists(user.getWishlists());
        return userRepository.save(userEntity);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
