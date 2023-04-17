package com.project.portfolioapp;

import com.project.portfolioapp.controller.UserController;
import com.project.portfolioapp.entity.User;
import com.project.portfolioapp.exception.ResourceAlreadyExistsException;
import com.project.portfolioapp.exception.ResourceNotFoundException;
import com.project.portfolioapp.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserControllerTest {

    @Mock
    private UserService userService;

    @InjectMocks
    private UserController userController;

    @Test
    public void createUser_ValidUser_ReturnsCreatedUser() {
        User user = new User("john.doe@example.com", "password", "John", "Doe", "Software Engineer", "Hi");
        User savedUser = new User(1L, "john.doe@example.com", "password", "John", "Doe", "Software Engineer", "Hi");
        when(userService.createUser(user)).thenReturn(savedUser);

        ResponseEntity<User> response = userController.createUser(user);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(savedUser, response.getBody());
        verify(userService, times(1)).createUser(user);
    }


    @Test
    public void createUser_UserAlreadyExists_ReturnsConflict() {
        User user = new User("john.doe@example.com", "password", "John", "Doe", "Software Engineer", "Hi");
        when(userService.createUser(user)).thenThrow(ResourceAlreadyExistsException.class);

        ResponseEntity<User> response = userController.createUser(user);

        assertEquals(HttpStatus.CONFLICT, response.getStatusCode());
        verify(userService, times(1)).createUser(user);
    }

    @Test
    public void getUser_ValidId_ReturnsUser() {
        Long id = 1L;
        User user = new User("john.doe@example.com", "password", "John", "Doe", "Software Engineer", "Hi");
        when(userService.getUser(id)).thenReturn(user);

        ResponseEntity<User> response = userController.getUser(id);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(user, response.getBody());
        verify(userService, times(1)).getUser(id);
    }

    @Test
    public void getUser_InvalidId_ReturnsNotFound() {
        Long id = 1L;
        when(userService.getUser(id)).thenThrow(ResourceNotFoundException.class);

        ResponseEntity<User> response = userController.getUser(id);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        verify(userService, times(1)).getUser(id);
    }

    @Test
    public void getAllUsers_ReturnsAllUsers() {
        List<User> users = Arrays.asList(
                new User(1L, "john.doe@example.com", "password", "John", "Doe", "Software Engineer", "Hi"),
                new User(2L, "john.doe@example.com", "password", "John", "Doe", "Software Engineer", "Hi")
        );
        when(userService.getAllUsers()).thenReturn(users);

        List<User> response = userController.getAllUsers();

        assertEquals(users, response);
        verify(userService, times(1)).getAllUsers();
    }

    @Test
    public void updateUser_ValidIdAndUser_ReturnsUpdatedUser() {
        Long id = 1L;
        User user = new User("john.doe@example.com", "password", "John", "Doe", "Software Engineer", "Hi");
        User updatedUser = new User(id, "john.doe@example.com", "updated-password", "John", "Doe", "Software Engineer", "Hi");
        when(userService.updateUser(user)).thenReturn(updatedUser);

        ResponseEntity<User> response = userController.updateUser(id, user);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(updatedUser, response.getBody());
        verify(userService, times(1)).updateUser(user);
    }

    @Test
    public void updateUser_InvalidId_ReturnsNotFound() {
        Long id = 1L;
        User user = new User("john.doe@example.com", "password", "John", "Doe", "Software Engineer", "Hi");
        user.setId(id);
        when(userService.updateUser(user)).thenThrow(ResourceNotFoundException.class);

        ResponseEntity<User> response = userController.updateUser(id, user);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        verify(userService, times(1)).updateUser(user);
    }

    @Test
    public void deleteUser_ValidId_ReturnsNoContent() {
        Long id = 1L;
        doNothing().when(userService).deleteUser(id);

        ResponseEntity<Void> response = userController.deleteUser(id);

        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
        verify(userService, times(1)).deleteUser(id);
    }

    @Test
    public void deleteUser_InvalidId_ReturnsNotFound() {
        Long id = 1L;
        doThrow(ResourceNotFoundException.class).when(userService).deleteUser(id);

        ResponseEntity<Void> response = userController.deleteUser(id);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        verify(userService, times(1)).deleteUser(id);
    }

    @Test
    public void getUserByEmail_ValidEmail_ReturnsUser() {
        String email = "john.doe@example.com";
        User user =  new User(1L, email, "password", "John", "Doe", "Software Engineer", "Hi");
        when(userService.getUserByEmail(email)).thenReturn(user);

        ResponseEntity<User> response = userController.getUserByEmail(email);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(user, response.getBody());
        verify(userService, times(1)).getUserByEmail(email);
    }

    @Test
    public void getUserByEmail_InvalidEmail_ReturnsNotFound() {
        String email = "john.doe@example.com";
        when(userService.getUserByEmail(email)).thenThrow(ResourceNotFoundException.class);

        ResponseEntity<User> response = userController.getUserByEmail(email);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        verify(userService, times(1)).getUserByEmail(email);
    }
}