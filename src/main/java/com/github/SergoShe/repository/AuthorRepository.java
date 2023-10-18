package com.github.SergoShe.repository;

import com.github.SergoShe.model.Author;
import com.github.SergoShe.repository.mappers.AuthorRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public class AuthorRepository {

    private final JdbcTemplate jdbc;

    public AuthorRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public Author findAuthorById(long authorId) {
        String sql = "SELECT * FROM author WHERE author_id = ?";
        return jdbc.queryForObject(sql, new AuthorRowMapper(), authorId);
    }

    public List<Author> findAllAuthors() {
        String sql = "SELECT * FROM author";
        return jdbc.query(sql, new AuthorRowMapper());
    }

    public long deleteAuthorById(Long authorId) {
        String sql = "DELETE FROM author WHERE author_id = ?";
        return jdbc.update(sql, authorId);
    }

    public Author createAuthor(Author author) {
        String sql = """
                INSERT INTO author (author_id,first_name,surname,middle_name,create_date,update_date)
                VALUES (?,?,?,?,?,?);
                """;
        long authorId = jdbc.update(sql,
                author.getAuthorId(),
                author.getFirstName(),
                author.getSurName(),
                author.getMiddleName(),
                LocalDate.now(),
                LocalDate.now());
        return findAuthorById(authorId);
    }

    public Author updateAuthor(Author author) {
        String sql = """
                UPDATE author
                SET first_name = ?, surname = ?, middle_name = ?, update_date = ?
                WHERE author_id = ?;
                """;
        long authorId = jdbc.update(sql,
                author.getFirstName(),
                author.getSurName(),
                author.getMiddleName(),
                LocalDate.now(),
                author.getAuthorId());
        return findAuthorById(authorId);
    }
}