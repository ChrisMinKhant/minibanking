package com.intern.rest.service.implementations;

import com.intern.rest.entity.Customer;
import com.intern.rest.model.customer.CustomerResponse;
import com.intern.rest.model.customer.NewCustomerRequest;
import com.intern.rest.model.customer.UpdateCustomerRequest;
import com.intern.rest.repository.CustomerRepository;
import com.intern.rest.service.CustomerService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public List<CustomerResponse> findAll() {
        List<Customer> customerList = customerRepository.findAll();

        List<CustomerResponse> customerResponseList = customerList.stream()
                .map(customer -> new CustomerResponse(customer.getId(),customer.getName()
                        ,customer.getNrc(),customer.getDateOfBirth(),customer.getFatherName()
                        ,customer.getMobileNumber(),customer.getUserName())).collect(Collectors.toList());

        return customerResponseList;
    }

    @Override
    public CustomerResponse findByUsername(String username) {
        CustomerResponse customerResponse = new CustomerResponse();

        Customer customer = customerRepository.findByUsername(username);

            customerResponse.setId(customer.getId());
            customerResponse.setName(customer.getName());
            customerResponse.setNrc(customer.getNrc());
            customerResponse.setDateOfBirth(customer.getDateOfBirth());
            customerResponse.setFatherName(customer.getFatherName());
            customerResponse.setMobileNumber(customer.getMobileNumber());
            customerResponse.setUsername(customer.getUserName());

        return customerResponse;
    }

    @Override
    public void save(NewCustomerRequest customer) {

        ObjectId objectId = new ObjectId();

        Customer temporaryCustomer = new Customer(objectId.toString(),customer.getName(),
                customer.getNrc(),customer.getDateOfBirth(),customer.getFatherName(),
                customer.getMobileNumber(),customer.getUsername(),customer.getPassword());

        customerRepository.save(temporaryCustomer);
    }

    @Override
    public void update(String username,UpdateCustomerRequest updateCustomer) {

        Customer customer = customerRepository.findByUsername(username);

        customer.setName(updateCustomer.getName());
        customer.setNrc(updateCustomer.getNrc());
        customer.setDateOfBirth(updateCustomer.getDateOfBirth());
        customer.setFatherName(updateCustomer.getFatherName());
        customer.setMobileNumber(updateCustomer.getMobileNumber());

        customerRepository.save(customer);
    }

    @Override
    public void delete(String username) {
        Customer customer = customerRepository.findByUsername(username);

        customerRepository.delete(customer);
    }
}
