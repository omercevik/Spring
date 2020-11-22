package com.example.lab5;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.util.Assert;

import java.util.List;


@SpringBootApplication
public class AppMain implements CommandLineRunner
{
    public static void main(String[] args)
    {
        SpringApplication.run(AppMain.class);
    }

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public void run(String... args) {
        Assert.notNull(customerRepository, "AppContext has problem, jdbc not available!");
        Assert.isTrue(customerRepository.count() == 0, "Table must be empty!");

        Customer newC = customerRepository.save(new Customer("foo","bee"));

        System.out.println(newC);
        Assert.isTrue(newC.getId().longValue() == 1,"ID is not 1!");
        Customer cFound = customerRepository.findOne(1l);
        System.out.println(cFound);

        customerRepository.save(new Customer("a","aa"));
        customerRepository.save(new Customer("b","bb"));
        customerRepository.save(new Customer("c","cbc"));
        customerRepository.save(new Customer("foo","dd"));

        List<Customer> customerList = customerRepository.findAllByFirstName("foo");

        for (Customer customer : customerList) {
            System.out.println(customer);
        }

        customerList = customerRepository.findAllByLastNameLike("%b%");

        for (Customer customer : customerList) {
            System.out.println(customer);
        }

        System.out.println("PAGE!");
        Page<Customer> pages = customerRepository.findAll(new PageRequest(0, 2));

        for (Customer page : pages) {
            System.out.println(page);
        }
    }
}
