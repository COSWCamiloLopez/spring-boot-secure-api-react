package com.eci.cosw.springbootsecureapi.controller;

import com.eci.cosw.springbootsecureapi.model.User;
import com.eci.cosw.springbootsecureapi.service.UserService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import java.util.Date;
import java.util.List;

/**
 * @author Santiago Carrillo
 * 8/21/17.
 */
@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("id/{idUser}")
    @ResponseBody
    public User getUserById(@PathVariable("idUser") Long idUser) throws ServletException {
        if (userService.getUser(idUser) != null) {
            return userService.getUser(idUser);
        } else {
            throw new ServletException("Doesn't exist an user whit this id");
        }
    }

    @GetMapping("username/{userName}")
    @ResponseBody
    public User getUserByUserName(@PathVariable("userName") String userName) throws ServletException {
        if (userService.findUserByUsername(userName) != null) {
            return userService.findUserByUsername(userName);
        } else {
            throw new ServletException("Doesn't exist an user whit this username");
        }
    }

    @GetMapping("all")
    @ResponseBody
    public List<User> getAll() throws Exception {
        return userService.getUsers();
    }

    @PostMapping("new")
    public void createUser(@RequestBody User newUser) {
        userService.createUser(newUser);
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Token login(@RequestBody User login)
            throws ServletException {

        String jwtToken = "";

        if (login.getUsername() == null || login.getPassword() == null) {
            throw new ServletException("Please fill in username and password");
        }

        String username = login.getUsername();
        String password = login.getPassword();

        User user = userService.findUserByUsername(username);

        if (user == null) {
            throw new ServletException("User username not found.");
        }

        String pwd = user.getPassword();

        if (!password.equals(pwd)) {
            throw new ServletException("Invalid login. Please check your name and password.");
        }
        //
        jwtToken = Jwts.builder().setSubject(username).claim("roles", "user").setIssuedAt(new Date()).signWith(
                SignatureAlgorithm.HS256, "secretkey").compact();

        return new Token(jwtToken);
    }

    public class Token {

        String accessToken;


        public Token(String accessToken) {
            this.accessToken = accessToken;
        }


        public String getAccessToken() {
            return accessToken;
        }

        public void setAccessToken(String access_token) {
            this.accessToken = access_token;
        }
    }

}
