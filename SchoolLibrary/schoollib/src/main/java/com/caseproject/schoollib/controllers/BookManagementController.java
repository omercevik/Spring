package com.caseproject.schoollib.controllers;

import com.caseproject.schoollib.dtos.BookDto;
import com.caseproject.schoollib.models.Book;
import com.caseproject.schoollib.services.iservices.IBookManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/books")
public class BookManagementController {

    @Qualifier("bookManagementService")
    @Autowired
    private IBookManagementService bookService;

    @GetMapping("")
    public ResponseEntity<?> booksById(@RequestParam(name = "id", required = false, defaultValue = "0") Long id) {
        Optional<Book> book = bookService.findById(id);
        if (book.isPresent())
            return new ResponseEntity<>(book.get(), HttpStatus.FOUND);
        return new ResponseEntity<>(bookService.findAll(), HttpStatus.NOT_FOUND);
    }

    @GetMapping("/all")
    public ResponseEntity<?> books() {
        List<Book> books = bookService.findAll();
        return books != null ?
                new ResponseEntity<>(books, HttpStatus.OK) :
                new ResponseEntity<>("Error : 404 Not Found!", HttpStatus.NOT_FOUND);
    }

    @PostMapping("")
    public ResponseEntity<?> createBook(@RequestBody BookDto book) {
        List<Book> books = bookService.findByName(book.getName());
        if (books != null)
        {
            if (book.getName() != null &&
                    book.getWriter() != null)
            {
                boolean flag = true;
                for (Book dbBook : books) {
                    if (dbBook.getWriter().equals(book.getWriter())) {
                        flag = false;
                        break;
                    }
                }
                if (flag)
                {
                    Book newBook = new Book(book.getName(), book.getWriter());
                    bookService.save(newBook);
                    return new ResponseEntity<>(book, HttpStatus.CREATED);
                }
            }
        }
        return new ResponseEntity<>("Error: 204 No Content.", HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("")
    public ResponseEntity<?> deleteBook(@RequestBody BookDto book) {
        List<Book> books = bookService.findByName(book.getName());
        if (books != null)
        {
            if (book.getName() != null &&
                    book.getWriter() != null)
            {
                Book removeBook = null;
                boolean flag = false;
                for (Book dbBook : books) {
                    if (dbBook.getWriter().equals(book.getWriter())) {
                        removeBook = dbBook;
                        flag = true;
                        break;
                    }
                }
                if (flag)
                {
                    bookService.delete(removeBook);
                    return new ResponseEntity<>("Successfully deleted!", HttpStatus.OK);
                }
            }
        }
        return new ResponseEntity<>(book, HttpStatus.NOT_FOUND);
    }
}
