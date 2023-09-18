package com.github.SergoShe.service;

import com.github.SergoShe.model.Book;

import java.util.List;

public interface BookService {

    Book createBook(Book book);

    List<Book> getAllBook();

    Book getBook(long bookId);

    Book updateBook(long bookId, Book book);

    void sendBookToService(long bookId);

    void deleteBook(long bookId);

}
