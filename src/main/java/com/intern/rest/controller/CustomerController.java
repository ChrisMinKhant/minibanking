package com.intern.rest.controller;

import com.intern.rest.entity.Customer;
import com.intern.rest.model.customer.CustomerResponse;
import com.intern.rest.model.customer.NewCustomerRequest;
import com.intern.rest.model.customer.UpdateCustomerRequest;
import com.intern.rest.repository.CustomerRepository;
import com.intern.rest.service.CustomerService;
import com.intern.rest.service.implementations.CustomerServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Random;

@RequestMapping("/api")
@RestController
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping("/customers")
    public ResponseEntity<List<CustomerResponse>> getAllCustomers()
    {
        List<CustomerResponse> customerList = customerService.findAll();

        return new ResponseEntity<List<CustomerResponse>>(customerList, HttpStatus.OK);
    }

    @GetMapping("/customers/{username}")
    public ResponseEntity<CustomerResponse> getCustomerByUsername(@PathVariable(value = "username") String username)
    {
        CustomerResponse customerResponse = customerService.findByUsername(username);

        return new ResponseEntity<CustomerResponse>(customerResponse,HttpStatus.OK);
    }

    @PostMapping("/customers")
    public ResponseEntity<String> createNewCustomers(@RequestBody NewCustomerRequest newCustomerRequest)
    {
        customerService.save(newCustomerRequest);

        return new ResponseEntity<String>("You Created New Customer!", HttpStatus.OK);
    }

    @PutMapping("/customers/{username}")
    public ResponseEntity<String> updateCustomers(@PathVariable(value = "username") String username
            , @RequestBody UpdateCustomerRequest updateCustomerRequest)
    {
        customerService.update(username,updateCustomerRequest);

        return new ResponseEntity<String>("You Updated Customer!",HttpStatus.OK);
    }

    @DeleteMapping("/customers/{username}")
    public ResponseEntity<String> deleteCustomer(@PathVariable(value = "username") String username)
    {
        customerService.delete(username);

        return new ResponseEntity<String>("You Deleted Customer!",HttpStatus.OK);
    }
}
