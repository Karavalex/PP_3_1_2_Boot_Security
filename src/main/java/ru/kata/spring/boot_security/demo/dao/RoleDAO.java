package ru.kata.spring.boot_security.demo.dao;

import org.springframework.context.annotation.Role;

import java.util.List;
import java.util.NoSuchElementException;

public interface RoleDAO {
    List<RoleDAO> getAllRole();
    RoleDAO findRoleByAuthority(String authority) throws NoSuchElementException;

    String getAuthority();
}
