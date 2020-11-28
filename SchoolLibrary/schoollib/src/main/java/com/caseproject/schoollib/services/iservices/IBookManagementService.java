package com.caseproject.schoollib.services.iservices;

import com.caseproject.schoollib.models.Book;

import java.util.List;
import java.util.Optional;

public interface IBookManagementService {
    List<Book> findAll();
    Optional<Book> findById(Long id);
    List<Book> findByName(String name);
    Book save(Book book);
    void delete(Book book);
}
