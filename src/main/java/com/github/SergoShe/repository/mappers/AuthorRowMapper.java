package com.github.SergoShe.repository.mappers;

import com.github.SergoShe.model.Author;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class AuthorRowMapper implements RowMapper<Author> {

    @Override
    public Author mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Author author = new Author();
        author.setAuthorId(resultSet.getLong("author_id"));
        author.setFirstName(resultSet.getString("first_name"));
        author.setSurName(resultSet.getString("surname"));
        author.setMiddleName(resultSet.getString("middle_name"));
        author.setCreateDate(LocalDate.parse(resultSet.getString("create_date")));
        author.setUpdateDate(LocalDate.parse(resultSet.getString("update_date")));
        return author;
    }
}
