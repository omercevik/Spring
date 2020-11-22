package com.example.lab7;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface CustomerRepository extends PagingAndSortingRepository<Customer, Long>
{
    List<Customer> findAllByFirstName(String firstName);
    List<Customer> findAllByLastNameLike(String lastName);
    Page<Customer> findAll(Pageable pageRequest);
}
