package com.example.lab6;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CustomerRestController
{
    @Autowired
    CustomerRepository customerRepository;

    @RequestMapping("/customer/all")
    public Iterable<Customer> findAll()
    {
        return customerRepository.findAll();
    }

    @GetMapping("/customer/{id}")
    public Customer findById(@PathVariable("id") Long id)
    {
        Customer customer = customerRepository.findOne(id);
        if (customer == null)
            throw new RuntimeException("I can not find the customer with id : " + id);
        return customer;
    }

    @PostMapping("/customer")
    public Customer saveNewCustomer(@RequestBody Customer customer)
    {
        customerRepository.save(customer);
        
        return customer;
    }
}
