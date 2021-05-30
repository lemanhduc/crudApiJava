package com.example.demo.services;

import com.example.demo.domain.User;
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
        public String Delete(int id) {
            userRepository.deleteById(id);
            return "User(" + id + ")" + " has been deleted!";
        }
    }

