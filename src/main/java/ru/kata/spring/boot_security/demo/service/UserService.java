package ru.kata.spring.boot_security.demo.service;


import ru.kata.spring.boot_security.demo.dao.RoleDAO;
import ru.kata.spring.boot_security.demo.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();

    Object getUserById(int id);

    void addUser(User user);
    List<RoleDAO> getAllRole();

    void removeUser(int id);

    void updateUser(int id , User user);

}