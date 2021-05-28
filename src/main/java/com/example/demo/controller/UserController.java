package com.example.demo.controller;

import com.example.demo.domain.User;
import com.example.demo.repository.UserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class UserController {
    private UserRepository userRepository;

    @GetMapping("/users")
    public List<User> getUsers() {
        List<User> list = new ArrayList<>();
        for (User user: userRepository.findAll()) list.add(user);
        return list;
    }

    @PostMapping("/users")
    public void createUser(@RequestBody User user) {
        userRepository.save(user);
    }

    @GetMapping("/users/{id}")
    public Optional<User> getUserById(@PathVariable Integer id) {
        return userRepository.findById(id);
    }

    @PatchMapping("/users/{id}")
    public void patchUpdate(@RequestBody User customerInput,@PathVariable Integer id) {
        User myUser = this.userRepository.findById(id).get();
        myUser.setEmail(customerInput.getEmail());
        myUser.setPassword(customerInput.getPassword());

        this.userRepository.save(myUser);
    }

    @DeleteMapping("delete")
    public void delete(@RequestBody User myUser) {
        this.userRepository.delete(myUser);
    }

    @PostMapping(" /users/authenticate")
    public void putUpdate(@RequestBody User customerInput,@PathVariable Integer id) {
        String myEmail = this.userRepository.getUserEmail(customerInput);

    }


}
