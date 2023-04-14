package com.project.portfolioapp.service;

import com.project.portfolioapp.entity.User;
import com.project.portfolioapp.exception.UserAlreadyExistsException;
import com.project.portfolioapp.exception.UserNotFoundException;
import com.project.portfolioapp.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User createUser(User user) throws UserAlreadyExistsException {
        if(userRepository.findByEmail(user.getEmail()) != null) {
            throw new UserAlreadyExistsException("User with email " + user.getEmail() + " already exists!");
        } else {
//            String encodedPassword = passwordEncoderConfig.passwordEncoder().encode(user.getPassword());
//            user.setPassword(encodedPassword);
            return userRepository.save(user);
        }
    }

    public User getUser(Long id) throws UserNotFoundException {
        return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User with" + id + " not found"));
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User updateUser(User user) throws UserNotFoundException {
        getUser(user.getId());
        return userRepository.save(user);
    }

    public void deleteUser(Long id) throws UserNotFoundException {
        getUser(id);
        userRepository.deleteById(id);
    }

    public User getUserByEmail(String email) throws UserNotFoundException {
        User user = userRepository.findByEmail(email);
        if(user == null) {
            throw new UserNotFoundException("User with email " + user.getEmail() + " already exists!");
        }
        return user;
    }
}
