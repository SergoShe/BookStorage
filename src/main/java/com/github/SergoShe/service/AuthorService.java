package com.github.SergoShe.service;

import com.github.SergoShe.model.Author;

import java.util.List;

public interface AuthorService {

    void create(Author author);

    List<Author> getAll();

    Author get(long authorId);

    long update(Author author);

    void delete(long authorId);
}
