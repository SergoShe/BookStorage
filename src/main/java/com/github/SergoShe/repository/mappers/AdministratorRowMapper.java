package com.github.SergoShe.repository.mappers;

import com.github.SergoShe.model.Administrator;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class AdministratorRowMapper implements RowMapper<Administrator> {
    @Override
    public Administrator mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Administrator admin = new Administrator();
        admin.setAdministratorId(resultSet.getLong("administrator_id"));
        admin.setName(resultSet.getString("name"));
        admin.setSurname(resultSet.getString("surname"));
        admin.setCreateDate(LocalDate.parse(resultSet.getString("create_date")));
        admin.setUpdateDate(LocalDate.parse(resultSet.getString("update_date")));

        return admin;
    }
}