package com.example.BikersBackend.controller;

import com.example.BikersBackend.model.User;
import com.example.BikersBackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getUsers(){
        return userService.getUsers();
    }

    @RequestMapping("/details/{id}")
    @GetMapping
    public Optional<User> getUsersById(@PathVariable Integer id){
        return userService.getUsersById(id);
    }

    @PostMapping("/signup")
    public void signup(@RequestBody User user){
        userService.signup(user);
    }
}
