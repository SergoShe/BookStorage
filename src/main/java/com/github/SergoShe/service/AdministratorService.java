package com.github.SergoShe.service;

import com.github.SergoShe.model.Administrator;

import java.util.List;

public interface AdministratorService {

    void createAdministrator(Administrator administrator);

    List<Administrator> getAllAdministrators();

    Administrator getAdministrator(long id);

    Administrator updateAdministrator(Administrator administrator);

    boolean deleteAdministrator(long id);
}
