package com.github.SergoShe.service;

import com.github.SergoShe.model.Author;

import java.util.List;

public interface AuthorService {

    void createAuthor(Author author);

    List<Author> getAllAuthors();

    Author getAuthor(long authorId);

    Author updateAuthor(Author author);

    boolean deleteAuthor(long authorId);
}
