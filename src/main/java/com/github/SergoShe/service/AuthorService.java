package com.github.SergoShe.service;

import com.github.SergoShe.model.Author;

import java.util.List;

public interface AuthorService {

    void create(Author author);

    List<Author> readAll();

    Author read(long id);

    boolean update(Author author, long id);

    boolean delete(long id);
}
