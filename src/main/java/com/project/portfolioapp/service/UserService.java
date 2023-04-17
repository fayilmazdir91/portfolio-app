package com.project.portfolioapp.service;

import com.project.portfolioapp.entity.User;
import com.project.portfolioapp.exception.ResourceAlreadyExistsException;
import com.project.portfolioapp.exception.ResourceNotFoundException;
import com.project.portfolioapp.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User createUser(User user) throws ResourceAlreadyExistsException {
        if(userRepository.findByEmail(user.getEmail()) != null) {
            throw new ResourceAlreadyExistsException("User with email " + user.getEmail() + " already exists!");
        }

//      String encodedPassword = passwordEncoderConfig.passwordEncoder().encode(user.getPassword());
//      user.setPassword(encodedPassword);

        return userRepository.save(user);
    }

    public User getUser(Long id) throws ResourceNotFoundException {
        return userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User with" + id + " not found!"));
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User updateUser(User user) throws ResourceNotFoundException {
        getUser(user.getId());
        return userRepository.save(user);
    }

    public void deleteUser(Long id) throws ResourceNotFoundException {
        getUser(id);
        userRepository.deleteById(id);
    }

    public User getUserByEmail(String email) throws ResourceNotFoundException {
        User user = userRepository.findByEmail(email);
        if(user == null) {
            throw new ResourceNotFoundException("User with email " + user.getEmail() + " already exists!");
        }
        return user;
    }
}
