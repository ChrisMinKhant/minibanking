package com.intern.rest.controller;

import com.intern.rest.entity.Customer;
import com.intern.rest.repository.CustomerRepository;
import com.intern.rest.service.CustomerService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Random;

@RequestMapping("/api")
@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/customers")
    public ResponseEntity<List<Customer>> getAllCustomers()
    {
        List<Customer> customerList = customerService.findAll();
        return new ResponseEntity<List<Customer>>(customerList, HttpStatus.OK);
    }

    private String tenDigitsPrimaryString()
    {
        String tenDigitsString = "";

        for(int i=0; i<10;i++)
        {
            Random randomNumber = new Random();
            int oneDigit = randomNumber.nextInt(9);
            tenDigitsString += Integer.toString(oneDigit);

        }

        return tenDigitsString;
    }
}
