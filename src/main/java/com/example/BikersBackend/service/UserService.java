package com.example.BikersBackend.service;

import com.example.BikersBackend.model.User;
import com.example.BikersBackend.repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final IUserRepository userRepository;

    @Autowired
    public UserService(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getUsers(){
        return userRepository.findAll();
    }

    public Optional<User> getUsersById(Integer id) {
        return userRepository.findById(id);
    }

    public void signup(User user){
        userRepository.save(user);
    }
}
