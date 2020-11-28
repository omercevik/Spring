package com.caseproject.schoollib.services;

import com.caseproject.schoollib.dtos.BookDto;
import com.caseproject.schoollib.models.Book;
import com.caseproject.schoollib.repositories.BookRepository;
import com.caseproject.schoollib.services.iservices.IBookManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookManagementService implements IBookManagementService {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public List<Book> findAll() {
        return (List<Book>) bookRepository.findAll();
    }

    @Override
    public Optional<Book> findById(Long id) {
        return bookRepository.findById(id);
    }

    @Override
    public List<Book> findByName(String name) {
        return bookRepository.findByName(name);
    }

    @Override
    public Book save(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public void delete(Book book) {
        bookRepository.delete(book);
    }
}