package com.example.BikersBackend.repositories;

import com.example.BikersBackend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface IUserRepository extends JpaRepository<User, Integer> {
    @Query("" +
            "SELECT CASE WHEN COUNT(u) > 0 THEN " +
            "TRUE ELSE FALSE END " +
            "FROM User u " +
            "WHERE u.email = ?1"
    )
    Boolean selectExistsEmail(String email);


    @Query(value = "SELECT `id` FROM `user_table` WHERE `email` = ?1 AND `password` = ?2", nativeQuery = true)
    int signin(String email, String password);
}
