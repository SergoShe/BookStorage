package com.github.SergoShe.service;

import com.github.SergoShe.model.Person;

import java.util.List;

public interface PersonService {
    void create(Person book);

    List<Person> readAll();

    Person read(long id);

    boolean update(Person book, long id);

    boolean delete(long id);
}
