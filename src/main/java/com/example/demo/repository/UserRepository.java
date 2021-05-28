package com.example.demo.repository;

import com.example.demo.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.RequestBody;

public interface UserRepository extends CrudRepository<User,Integer > {

    public String getUserEmail(@RequestBody User person);
}
