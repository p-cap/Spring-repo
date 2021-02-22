package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {

    @Autowired
    private UserRepository repository;

    @Override
    public List<User> findAll() {
        var users = (List<User>) repository.findAll();

        return users;
    }

    @Override
    public User findUserByUsernameAndPassword(String username, String password) {

        var test = (User) repository.findUserByUsernameAndPassword(username, password);

        return test;
    }
}
