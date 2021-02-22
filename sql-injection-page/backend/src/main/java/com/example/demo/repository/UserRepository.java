package com.example.demo.repository;

import com.example.demo.model.User;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long>{
    @Query("SELECT u FROM User u WHERE u.username = :username and u.password = :password")
    User findUserByUsernameAndPassword(
            @Param("username") String username,
            @Param("password") String password
    );
}
