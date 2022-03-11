package com.example.BikersBackend.service;

import com.example.BikersBackend.repositories.IAccountRepository;
import com.example.BikersBackend.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {

    private IAccountRepository accountRepository;

    @Autowired
    public AccountService(IAccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public List<Account> getAccounts(){
        List<Account> accounts = accountRepository.findAll();
        return accounts;
    }
}
