package com.example.demo.controller;

import com.example.demo.domain.User;
import com.example.demo.domain.authenticattion;
import com.example.demo.repository.UserRepository;
import com.example.demo.services.userService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    private final userService userService;
    private final UserRepository _userRepository;

    public UserController(userService userService, UserRepository userRepository) {
        this.userService = userService;
        _userRepository = userRepository;
    }

    // Add
    @PostMapping(value = "/users")
    public User Post(@RequestBody User params) {
        return userService.Post(params);
    }

    // Get
    @GetMapping(value = "/users")
    public List<User> Get() {
        return userService.Get();
    }

    // Get By ID
    @GetMapping(value = "/users/{id}")
    public User Get(@PathVariable int id) {
        return userService.Get(id);
    }

    // patch
    @PatchMapping(value = "/users/{id}")
    public User PatchUpdate(@RequestBody User userInput, @PathVariable int id) {
       return this.userService.patchUpdate(userInput, id);
    }
    // Update
    @PutMapping(value = "/users/{id}")
    public User Update(@PathVariable int id, @RequestBody User params) {
        return userService.Update(params, id);
    }

    // Delete
    @DeleteMapping(value = "/users/{id}")
    public String Delete(@PathVariable int id) {
        return userService.Delete(id);
    }

    @PostMapping("/users/authenticate")
    public authenticattion putUpdate(@RequestBody User userInput) {
        return this.userService.getAuthStatus(userInput);
    }

}

