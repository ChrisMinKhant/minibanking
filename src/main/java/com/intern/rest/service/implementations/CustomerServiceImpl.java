package com.intern.rest.service.implementations;

import com.intern.rest.entity.Customer;
import com.intern.rest.model.customer.NewCustomerRequest;
import com.intern.rest.repository.CustomerRepository;
import com.intern.rest.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private MongoTemplate mongoTemplate;


    @Override
    public List<Customer> findAll() {
        List<Customer> customerList = customerRepository.findAll();
        return customerList;
    }

    @Override
    public List<Customer> findByUsername(String username) {
        Query query = new Query();

        query.addCriteria(Criteria.where("username").is(username));

        List<Customer> customerList = mongoTemplate.find(query,Customer.class);

        return customerList;
    }

    @Override
    public void save(NewCustomerRequest customer) {

    }

    @Override
    public void update(Customer customer) {

    }

    @Override
    public void delete(String username) {

    }
}
