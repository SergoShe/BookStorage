package com.github.SergoShe.repository.mappers;

import com.github.SergoShe.model.Reader;
import com.github.SergoShe.repository.constant.ReaderConstant;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class ReaderRowMapper implements RowMapper<Reader> {
    @Override
    public Reader mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Reader reader = new Reader();
        reader.setReaderId(resultSet.getLong(ReaderConstant.READER_ID_COLUMN));
        reader.setName(resultSet.getString(ReaderConstant.NAME_COLUMN));
        reader.setSurname(resultSet.getString(ReaderConstant.SURNAME_COLUMN));
        reader.setPhoneNumber(resultSet.getString(ReaderConstant.PHONE_NUMBER_COLUMN));
        reader.setAddress(resultSet.getString(ReaderConstant.ADDRESS_COLUMN));
        reader.setCreateDate(LocalDate.parse(resultSet.getString(ReaderConstant.CREATE_DATE_COLUMN)));
        reader.setUpdateDate(LocalDate.parse(resultSet.getString(ReaderConstant.UPDATE_DATE_COLUMN)));
        return reader;
    }
}