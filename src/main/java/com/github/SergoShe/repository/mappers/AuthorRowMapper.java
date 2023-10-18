package com.github.SergoShe.repository.mappers;

import com.github.SergoShe.model.Author;
import com.github.SergoShe.repository.constant.AuthorConstant;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class AuthorRowMapper implements RowMapper<Author> {

    @Override
    public Author mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Author author = new Author();
        author.setAuthorId(resultSet.getLong(AuthorConstant.AUTHOR_ID_COLUMN));
        author.setFirstName(resultSet.getString(AuthorConstant.FIRST_NAME_COLUMN));
        author.setSurName(resultSet.getString(AuthorConstant.SURNAME_COLUMN));
        author.setMiddleName(resultSet.getString(AuthorConstant.MIDDLE_NAME_COLUMN));
        author.setCreateDate(LocalDate.parse(resultSet.getString(AuthorConstant.CREATE_DATE_COLUMN)));
        author.setUpdateDate(LocalDate.parse(resultSet.getString(AuthorConstant.UPDATE_DATE_COLUMN)));
        return author;
    }
}
