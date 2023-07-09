package com.intern.rest.service;

import com.intern.rest.entity.Account;

import java.util.List;

public interface AccountService {
    List<Account> findAll();

    Account findByAccountNumber();

    void save(Account account);

    void update(Account account);

    void delete(Account account);
}
