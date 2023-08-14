package com.github.SergoShe.service;

import com.github.SergoShe.model.Book;

import java.util.List;

public interface BookService {

    void create(Book book);

    List<Book> readAll();

    Book read(long id);

    boolean update(Book book, long id);

    boolean delete(long id);

}
