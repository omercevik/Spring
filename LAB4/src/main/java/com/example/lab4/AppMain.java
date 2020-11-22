package com.example.lab4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.util.Assert;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@SpringBootApplication
public class AppMain implements CommandLineRunner
{
    public static void main(String[] args)
    {
        SpringApplication.run(AppMain.class);
    }

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public void run(String... args) {
        Assert.notNull(jdbcTemplate, "AppContext has problem, jdbc not available!");

        Long rowCount = jdbcTemplate.queryForObject("select count(*) from customers", Long.class);
        System.out.println("Row count : " + rowCount);
        Assert.isTrue(rowCount == 4,"Problem with rowCount!");

        List<Customer> customerList = jdbcTemplate.queryForList("select * from customers", Customer.class, new RowMapper<Customer>() {
            @Override
            public Customer mapRow(ResultSet resultSet, int i) throws SQLException {
                return new Customer(resultSet.getLong("id"),resultSet.getString("first_name"),resultSet.getString("last_name"));
            }
        });

        for (Customer customer : customerList) {
            System.out.println(customer.toString());
        }
    }
}
