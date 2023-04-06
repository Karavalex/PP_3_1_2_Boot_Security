package ru.kata.spring.boot_security.demo.service;


import ru.kata.spring.boot_security.demo.dao.RoleDAO;
import ru.kata.spring.boot_security.demo.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();

    Object getUserById(Integer id);

    public User findByName(String name);

    void addUser(User user);
    List<RoleDAO> getAllRole();

    void removeUser(Integer id);

    void updateUser(Integer id , User user);

}