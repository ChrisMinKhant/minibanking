package com.intern.rest.service;

import com.intern.rest.entity.Customer;
import com.intern.rest.model.customer.NewCustomerRequest;

import java.util.List;

public interface CustomerService {

    List<Customer> findAll();

    List<Customer> findByUsername(String username);

    void save(NewCustomerRequest customer);

    void update(Customer customer);

    void delete(String customer);
}
