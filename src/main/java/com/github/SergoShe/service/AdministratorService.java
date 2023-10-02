package com.github.SergoShe.service;

import com.github.SergoShe.model.Administrator;

import java.util.List;

public interface AdministratorService {

    void create(Administrator administrator);

    List<Administrator> getAll();

    Administrator get(long id);

    boolean update(Administrator administrator);

    boolean delete(long id);
}
