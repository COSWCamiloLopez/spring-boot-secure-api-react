package com.eci.cosw.springbootsecureapi.service;

import com.eci.cosw.springbootsecureapi.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Santiago Carrillo
 * 8/21/17.
 */
@Service
public class UserServiceImpl implements UserService {

    private List<User> users = new ArrayList<>();


    @Autowired
    public UserServiceImpl() {
    }

    @PostConstruct
    private void populateSampleData() {
        users.add(new User("test@mail.com", "password", "Andres", "Perez"));
    }


    @Override
    public List<User> getUsers() {
        return users;
    }

    @Override
    public User getUser(Long id) {
        User userToReturn = null;
        for (User x : users) {
            if (id.equals(x.getId())) {
                userToReturn = x;
            }
        }
        return userToReturn;
    }

    @Override
    public User createUser(User user) {
        return users.get(0);
    }

    @Override
    public User findUserByEmail(String email) {
        return users.get(0);
    }

    @Override
    public User findUserByEmailAndPassword(String email, String password) {
        User userToReturn = null;

        for (User x : users) {
            if (x.getEmail().equals(email) && x.getPassword().equals(password)) {
                userToReturn = x;
            }
        }
        return userToReturn;
    }

    @Override
    public User findUserByUsername(String username) {
        User userToReturn = null;

        for (User x : users) {
            if (x.getUsername().equals(username)) {
                userToReturn = x;
            }
        }

        return userToReturn;
    }

}
