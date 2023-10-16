package com.kata.springboot1.dao;



import com.kata.springboot1.model.User;

import java.util.List;

public interface UserDao {
    void add(User user);

    void edit(User user);

    void delete(Long id);

    User userById(Long id);

    List<User> listUsers();
}
