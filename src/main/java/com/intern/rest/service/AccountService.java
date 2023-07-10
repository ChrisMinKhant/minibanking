package com.intern.rest.service;

import com.intern.rest.entity.Account;
import com.intern.rest.model.account.NewAccountRequest;
import com.intern.rest.model.account.UpdateAccountRequest;

import java.util.List;

public interface AccountService {
    List<Account> findAll();

    Account findByAccountNumber(String accountNumber);

    String save(NewAccountRequest newAccount);

    Boolean update(String accountNumber,UpdateAccountRequest updateAccount);

    void delete(String accountNumber);
}
