package com.baeldung.crud.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.baeldung.crud.entities.User;
import com.baeldung.crud.repositories.UserRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import com.baeldung.crud.service.UserServiceImpl;

@Controller
public class UserController {

    private final UserRepository userRepository;
    private UserServiceImpl userServiceImpl;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Autowired
    public void setUserServiceImpl(UserServiceImpl userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
        ;
    }

    @RequestMapping("/")
    public String showAll(Model model) {
        model.addAttribute("users", userServiceImpl.showAll());
        return "index";
    }

    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") Long id, Model model) {
        User user = userServiceImpl.findById(id);
        model.addAttribute("user", user);
        return "update-user";
    }

    @PostMapping("/update/{id}")
    public String updateUser(@PathVariable("id") long id, @Valid User user, BindingResult result, Model model) {
        if (result.hasErrors()) {
            user.setId(id);
            return "update-user";
        }

        userServiceImpl.saveUserChanges(user);
        model.addAttribute("users", userServiceImpl.showAll());
        return "index";
    }
}
