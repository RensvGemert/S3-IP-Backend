package com.example.BikersBackend.repositories;

import com.example.BikersBackend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User, Integer> {

}
