package com.example.BikersBackend.dal;

import com.example.BikersBackend.model.Account;
import com.example.BikersBackend.repositories.IAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountDAL {

    private IAccountRepository accountRepository;

    @Autowired
    public AccountDAL(IAccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public List<Account> getAccounts(){
        return accountRepository.findAll();
    }
}
