package com.github.SergoShe.repository.mappers;

import com.github.SergoShe.model.Administrator;
import com.github.SergoShe.repository.constant.AdministratorConstant;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class AdministratorRowMapper implements RowMapper<Administrator> {
    @Override
    public Administrator mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Administrator admin = new Administrator();
        admin.setAdministratorId(resultSet.getLong(AdministratorConstant.ADMINISTRATOR_ID_COLUMN));
        admin.setName(resultSet.getString(AdministratorConstant.NAME_COLUMN));
        admin.setSurname(resultSet.getString(AdministratorConstant.SURNAME_COLUMN));
        admin.setCreateDate(LocalDate.parse(resultSet.getString(AdministratorConstant.CREATE_DATE_COLUMN)));
        admin.setUpdateDate(LocalDate.parse(resultSet.getString(AdministratorConstant.UPDATE_DATE_COLUMN)));
        return admin;
    }
}