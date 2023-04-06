package ru.kata.spring.boot_security.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.service.RoleService;
import ru.kata.spring.boot_security.demo.service.UserService;

import java.security.Principal;


@Controller
@RequestMapping()
@EnableTransactionManagement
public class UserController {

    private UserService userService;

    private RoleService roleService;

    @Autowired
    public UserController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping("/admin")
    public String showUsersForAdmin(Model model) {
        model.addAttribute("getAllUsers" , userService.getAllUsers());
        return "/admin/users";
    }

    @GetMapping("/admin/new")
    public String addUser(Model model) {
        model.addAttribute("user" , new User());
        model.addAttribute("roles", roleService.findAll());
        return "/admin/new";
    }

    @DeleteMapping("/admin//{id}")
    public String removeUser(@PathVariable("id") Integer id) {
        userService.removeUser(id);
        return "redirect:/admin/";
    }

    @PatchMapping("/admin/{id}")
    public String updateUser(@ModelAttribute("user") User user , @PathVariable("id") Integer id) {
        userService.updateUser(id , user);
        return "redirect:/admin/";

    }

    @GetMapping("/admin/{id}/edit")
    public String edit(Model model , @PathVariable("id") Integer id) {
        model.addAttribute("user" , userService.getUserById(id));
        return "/admin/edit";
    }

  @PostMapping("/admin/saveUser")
    public String saveUser(@ModelAttribute("user") User user) {
        userService.addUser(user);
        return "redirect:/admin/";
    }

    @RequestMapping("/user")
    public String printUser(ModelMap model, Principal principal) {
        model.addAttribute("user", userService.findByName(principal.getName()));

        return "user";
  }
}
