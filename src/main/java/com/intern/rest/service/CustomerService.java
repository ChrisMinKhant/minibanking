package com.intern.rest.service;

import com.intern.rest.entity.Customer;
import com.intern.rest.model.customer.CustomerResponse;
import com.intern.rest.model.customer.NewCustomerRequest;
import com.intern.rest.model.customer.UpdateCustomerRequest;

import java.util.List;

public interface CustomerService {

    List<CustomerResponse> findAll();

    CustomerResponse findByUsername(String username);

    Boolean save(NewCustomerRequest customer);

    void update(String username,UpdateCustomerRequest Updatecustomer);

    void delete(String username);
}
