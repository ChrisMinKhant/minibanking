package com.intern.rest.repository;

import com.intern.rest.entity.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface CustomerRepository extends MongoRepository<Customer,Integer> {

    @Query("{'userName' : ?0}")
    Customer findByUsername(String username);
}
