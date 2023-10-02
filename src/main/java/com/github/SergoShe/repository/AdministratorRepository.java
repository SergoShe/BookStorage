package com.github.SergoShe.repository;

import com.github.SergoShe.model.Administrator;
import com.github.SergoShe.repository.mappers.AdministratorRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AdministratorRepository {

    private final JdbcTemplate jdbc;

    public AdministratorRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public List<Administrator> findAllAdministrators(){
        String sql = "SELECT * FROM administrator";
        return jdbc.query(sql, new AdministratorRowMapper());
    }
}
