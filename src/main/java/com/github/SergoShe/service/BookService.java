package com.github.SergoShe.service;

import com.github.SergoShe.model.Book;

import java.util.List;

public interface BookService {

    Book create(Book book);

    List<Book> getAll();

    Book get(long bookId);

    Book update(Book updatedBook);
    void sendBookToService(long bookId);

    void delete(long bookId);

}
