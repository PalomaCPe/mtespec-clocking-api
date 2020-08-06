package com.mtespecclocing.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mtespecclocing.model.User;
import com.mtespecclocing.service.UserService;

@RestController
@RequestMapping("/api")
public class UserController {

	@Autowired
    UserService userService;

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping("/users")
    public User createUser(@Valid @RequestBody User user) {
        return userService.createUser(user);
    }

    @GetMapping("/users/{id}")
    public User getUserById(@PathVariable(value = "id") Long userId) {
        return userService.getUserById(userId);
    }
    
    @GetMapping("/users/totalhours/{id}")
    public User getUserTotalHours(@PathVariable(value = "id") Long userId) {
        return userService.getUserTotalHours(userId);
    }

    @PutMapping("/users/{id}")
    public User updateUser(@PathVariable(value = "id") Long userId, @Valid @RequestBody User userDetails) {
        User updatedUser = userService.updateUser(userId, userDetails);
        return updatedUser;
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable(value = "id") Long userId) {
        userService.deleteUser(userId);

        return ResponseEntity.ok().build();
    }
}

