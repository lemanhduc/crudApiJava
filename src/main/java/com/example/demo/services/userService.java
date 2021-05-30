package com.example.demo.services;
import com.example.demo.domain.User;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import com.example.demo.domain.authenticattion;

import java.util.List;

@Component
public interface userService {
    List<User> Get();

    User Post(User params);

    User Get(int id);

    User Update(User params, int id);

    User patchUpdate(@RequestBody User customerInput, int id);

    authenticattion getAuthStatus (User userInput);

    String Delete(int id);
}