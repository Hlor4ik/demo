package com.example.demo.Repository;

import com.example.demo.Models.Manager;
import com.example.demo.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.DataClassRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ManagerRepositoryH2 implements ManagerRepository {

    private static final String CREATE = """
                        insert into managers (managerId, firstname, lastname, email, birthday,gender)
                        values (:managerId, :firstname, :lastname, :email, :birthday, :gender)
            """;
    private static final String UPDATE = """
            UPDATE managers
            SET firstname = :firstname,
            lastname = :lastname,
            email = :email,
            birthday = :birthday,
            gender=:gender
            WHERE managerId = :managerId
            """;

    private final RowMapper<Manager> rowMapper = new DataClassRowMapper<>(Manager.class);

    private final JdbcTemplate jdbcTemplate;
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    public ManagerRepositoryH2(JdbcTemplate jdbcTemplate, NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public Manager read(Integer managerId) {
        try {
            return jdbcTemplate.queryForObject("select * from managers where managerId = ?", rowMapper, managerId);
        } catch (EmptyResultDataAccessException e) {
            throw new NotFoundException("Managers with id = [" + managerId + "] not found", e);
        }
    }

    @Override
    public List<Manager> readAll() {
        return jdbcTemplate.query("select * from managers", rowMapper);
    }

    @Override
    public void create(Manager manager) {
        BeanPropertySqlParameterSource paramsSource = new BeanPropertySqlParameterSource(manager);
        namedParameterJdbcTemplate.update(CREATE, paramsSource);
    }

    @Override
    public void update(Manager manager, Integer managerId) {
        BeanPropertySqlParameterSource paramsSource = new BeanPropertySqlParameterSource(manager);
        namedParameterJdbcTemplate.update(UPDATE, paramsSource);
    }

    @Override
    public void delete(Integer managerId) {
        jdbcTemplate.update("DELETE FROM managers where managerId = ?",managerId);
    }

}