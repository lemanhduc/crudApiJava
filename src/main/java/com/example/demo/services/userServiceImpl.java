package com.example.demo.services;

import com.example.demo.domain.User;
import com.example.demo.domain.authenticattion;
import com.example.demo.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

    @Service
    public class userServiceImpl implements userService {

        private final UserRepository userRepository;
        public userServiceImpl(UserRepository userRepository) {
            this.userRepository = userRepository;
        }

        @Override
        public User Post(User params) {
            userRepository.save(params);
            return params;
        }

        @Override
        public List<User> Get() {
            List<User> list = new ArrayList<>();
            for (User user: userRepository.findAll()) list.add(user);
            return list;
        }

        @Override
        public User Get(int id) {
            return userRepository.findById(id).get();
        }


        @Override
        public User patchUpdate(User params, int id)
        {
            User user =  userRepository.findById(id).get();
            user.setPassword(params.getPassword());
            user.setEmail(params.getEmail());

            return userRepository.save(user);
        }


        @Override
        public User Update(User params, int id) {

            User user =  userRepository.findById(id).get();
            user.setPassword(params.getPassword());
            user.setEmail(params.getEmail());

            return userRepository.save(user);
        }

        @Override
        public authenticattion getAuthStatus (User userInput) {
            authenticattion mythStatus = new authenticattion();
            User user =  userRepository.findByEmail(userInput.getEmail());
            String mypass = userInput.getPassword();

            if (mypass.equals(user.getPassword())) {
                mythStatus.setMyUser(user);
                mythStatus.setAuthenticated(true);
            } else {
               mythStatus.setAuthenticated(mythStatus.isAuthenticated());
            }

            return  mythStatus;
        }

        @Override
        public String Delete(int id) {
            userRepository.deleteById(id);
            return "User(" + id + ")" + " has been deleted!";
        }
    }

