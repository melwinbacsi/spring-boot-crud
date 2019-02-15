package com.baeldung.crud.service;

import com.baeldung.crud.entities.User;
import com.baeldung.crud.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    private UserRepository userRepository;
    private User user;


    @Autowired
    public void setUserRepository(UserRepository userRepository){
        this.userRepository=userRepository;
    }

    @Override
    public List<User> showAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(Long id) {
        return userRepository.findByIdIs(id);
    }

    @Override
    public User saveUserChanges(User user) {
        return userRepository.save(user);
    }

    @Override
    public void addUser(Long id, String name, String email) {
        this.user.setId(id);
        this.user.setName(name);
        this.user.setEmail(email);
        userRepository.save(this.user);
    }
}
