package com.intern.rest.repository;

import com.intern.rest.entity.Account;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface AccountRepository extends MongoRepository<Account,Long> {

    @Query("{'accountNumber': ?0}")
    Account findByAccountNumber(String accountNumber);
}
