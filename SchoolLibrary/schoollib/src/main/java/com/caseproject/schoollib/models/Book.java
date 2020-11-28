package com.caseproject.schoollib.models;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "books")
public class Book {

    @Id
    @NotEmpty
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @NotEmpty
    @Column(name="name")
    private String name;

    @NotEmpty
    @Column(name="writer")
    private String writer;

    public Book(String name, String writer) {
        this.name = name;
        this.writer = writer;
    }

    public Book() {

    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}