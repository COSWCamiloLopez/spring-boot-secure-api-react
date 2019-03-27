package com.eci.cosw.springbootsecureapi.service;

import com.eci.cosw.springbootsecureapi.model.User;
import com.eci.cosw.springbootsecureapi.model.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author Santiago Carrillo
 * 8/21/17.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    public UserServiceImpl() {
    }

    @Autowired
    UserRepository userRepository;

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUser(String id) {
        User userToReturn = null;
        for (User x : userRepository.findAll()) {
            if (id.equals(x.getId())) {
                userToReturn = x;
            }
        }
        return userToReturn;
    }

    @Override
    public void createUser(User user) {
        userRepository.save(user);
    }

    @Override
    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public User findUserByEmailAndPassword(String email, String password) {
        User userToReturn = null;

        for (User x : userRepository.findAll()) {
            if (x.getEmail().equals(email) && x.getPassword().equals(password)) {
                userToReturn = x;
            }
        }
        return userToReturn;
    }

    @Override
    public User findUserByUsername(String username) {
        User userToReturn = null;

        for (User x : userRepository.findAll()) {
            if (x.getUsername().equals(username)) {
                userToReturn = x;
            }
        }

        return userToReturn;
    }

}
