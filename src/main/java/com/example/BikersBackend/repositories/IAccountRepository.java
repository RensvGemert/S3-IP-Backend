package com.example.BikersBackend.repositories;

import com.example.BikersBackend.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAccountRepository extends JpaRepository<Account, Integer> {

}
