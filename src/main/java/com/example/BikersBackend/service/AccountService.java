package com.example.BikersBackend.service;

import com.example.BikersBackend.model.Account;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AccountService {

    public List<Account> getAccounts(){
        List<Account> accounts = new ArrayList<>();
        accounts.add(new Account(1, "admin", "admin@gmail.com", "test"));
        return accounts;
    }
}
