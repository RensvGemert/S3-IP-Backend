package com.example.BikersBackend.service;

import com.example.BikersBackend.dal.AccountDAL;
import com.example.BikersBackend.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {

    private AccountDAL accountDAL;

    @Autowired
    public AccountService(AccountDAL accountDAL) {
        this.accountDAL = accountDAL;
    }

    public List<Account> getAccounts(){
        List<Account> accounts = accountDAL.getAccounts();
        return accounts;
    }
}
