package com.example.BikersBackend.dal;

import com.example.BikersBackend.model.User;
import com.example.BikersBackend.repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserDAL {

    private final IUserRepository userRepository;

    @Autowired
    public UserDAL(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getUsers(){
        return userRepository.findAll();
    }

    public Optional<User> getUsersById(Integer id) {
        return userRepository.findById(id);
    }
}
