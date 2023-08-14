package com.github.SergoShe.service;

import com.github.SergoShe.model.Administrator;

import java.util.List;

public interface AdministratorService {

    void create(Administrator administrator);

    List<Administrator> readAll();

    Administrator read(long id);

    boolean update(Administrator administrator, long id);

    boolean delete(long id);
}
