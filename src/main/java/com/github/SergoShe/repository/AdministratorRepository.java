package com.github.SergoShe.repository;

import com.github.SergoShe.model.Administrator;
import com.github.SergoShe.repository.mappers.AdministratorRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public class AdministratorRepository {

    private final JdbcTemplate jdbc;


    public AdministratorRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public Administrator findAdministratorById(long administratorId){
        String sql = "SELECT * FROM administrator WHERE administrator_id = ?";
        return jdbc.queryForObject(sql, new AdministratorRowMapper(), administratorId);
    }

    public List<Administrator> findAllAdministrators(){
        String sql = "SELECT * FROM administrator";
        return jdbc.query(sql, new AdministratorRowMapper());
    }

    public long deleteAdministratorById(Long administratorId) {
        String sql = "DELETE FROM administrator WHERE administrator_id = ?";
        return jdbc.update(sql, administratorId);
    }

    public Administrator createAdministrator(Administrator administrator) {
        String sql = """
        INSERT INTO administrator (administrator_id,name,surname,create_date,update_date)
        VALUES (?,?,?,?,?);
        """;
        long adminId = jdbc.update(sql,
                administrator.getAdministratorId(),
                administrator.getName(),
                administrator.getSurname(),
                LocalDate.now(),
                LocalDate.now());
        return findAdministratorById(adminId);
    }

    public Administrator updateAdministrator(Administrator administrator){
        String sql = """
                UPDATE administrator
                SET name = ?, surname = ?, update_date = ?
                WHERE administrator_id = ?;
                """;
        long adminId = jdbc.update(sql,
                administrator.getName(),
                administrator.getSurname(),
                LocalDate.now(),
                administrator.getAdministratorId());
        return findAdministratorById(adminId);
    }
}
