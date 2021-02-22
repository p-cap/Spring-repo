package com.example.demo.controller;

import java.sql.*;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.IUserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.MediaType;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class UserController {

    @Autowired
    private IUserService userService;

    @Autowired
    private UserRepository repository;

    @GetMapping(value = "/",  produces = MediaType.TEXT_PLAIN_VALUE)
    public String sup() {
        return "wassup!!!";
    }

    @GetMapping("/showUsers")
    public List<User> allUsers() {

        var users = (List<User>) userService.findAll();

        return users;
    }

    @PostMapping("/user")
    @ResponseBody
    public User authenticateUser(@RequestBody User user) {

        var users = (List<User>) userService.findAll();

        var validatedUser = new User();

        users.forEach((item) -> {
            if (item.getUsername().equals(user.getUsername()) && item.getPassword().equals(user.getPassword())) {
                validatedUser.setUsername(user.getUsername());
                validatedUser.setPassword(user.getPassword());
            }
        });

     return validatedUser;
    }

    @CrossOrigin(origins = "http://localhost:3000", allowedHeaders = "*")
    @PostMapping("/inject")
    @ResponseBody
    public User sqlInject(@RequestBody User user) {
        var validatedUser = new User();
        try {
            // 1. Get a connection to database
            String url = "jdbc:postgresql://localhost:5432/sample?user=dbguy&password=itomunagamitko";

            Connection myConn = DriverManager.getConnection(url);
            // 2. create a statement
            Statement myStmt = myConn.createStatement();

            String username = user.getUsername();
            String pwd = user.getPassword();

            // 3. Execute SQL query
            ResultSet myRs = myStmt.executeQuery("SELECT * FROM sample WHERE username = '"
                    + username + "' AND password = '" + pwd + "'");

            // 4. Process the result set
            while (myRs.next()) {
                validatedUser.setUsername(myRs.getString("username"));
                validatedUser.setPassword(myRs.getString("password"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return validatedUser;
    }
}
