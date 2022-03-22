package com.example.BikersBackend.service;

import com.example.BikersBackend.dal.UserDAL;
import com.example.BikersBackend.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserDAL userDAL;

    @Autowired
    public UserService(UserDAL userDAL) {
        this.userDAL = userDAL;
    }

    public List<User> getUsers(){
        return userDAL.getUsers();
    }
}
