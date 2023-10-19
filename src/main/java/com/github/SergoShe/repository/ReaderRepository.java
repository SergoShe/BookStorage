package com.github.SergoShe.repository;

import com.github.SergoShe.model.Reader;
import com.github.SergoShe.repository.mappers.ReaderRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public class ReaderRepository {

    private final JdbcTemplate jdbc;

    public ReaderRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public Reader findReaderById(long readerId){
        String sql = "SELECT * FROM reader WHERE reader_id = ?";
        return jdbc.queryForObject(sql, new ReaderRowMapper(), readerId);
    }

    public List<Reader> findAllReaders(){
        String sql = "SELECT * FROM reader";
        return jdbc.query(sql, new ReaderRowMapper());
    }

    public long deleteReaderById(Long readerId) {
        String sql = "DELETE FROM reader WHERE reader_id = ?";
        return jdbc.update(sql, readerId);
    }

    public Reader createReader(Reader reader) {
        String sql = """
        INSERT INTO reader (reader_id,name,surname,phone_number,address,create_date,update_date)
        VALUES (?,?,?,?,?,?,?);
        """;
        long readerId = jdbc.update(sql,
                reader.getReaderId(),
                reader.getName(),
                reader.getSurname(),
                reader.getPhoneNumber(),
                reader.getAddress(),
                LocalDate.now(),
                LocalDate.now());
        return findReaderById(readerId);
    }

    public Reader updateReader(Reader reader){
        String sql = """
                UPDATE reader
                SET name = ?, surname = ?, phone_number = ?, address = ?, update_date = ?
                WHERE reader_id = ?;
                """;
        long readerId = jdbc.update(sql,
                reader.getName(),
                reader.getSurname(),
                reader.getPhoneNumber(),
                reader.getAddress(),
                LocalDate.now(),
                reader.getReaderId());
        return findReaderById(readerId);
    }
}