package com.baeldung.crud.service;

import com.baeldung.crud.entities.User;

import java.util.List;

public interface UserService {

    public List<User> showAll();
    public User findById(Long id);
    public User saveUserChanges(User user);
    public void addUser(Long id, String name, String email);
}
