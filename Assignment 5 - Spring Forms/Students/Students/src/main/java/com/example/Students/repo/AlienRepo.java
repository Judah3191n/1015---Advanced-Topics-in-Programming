package com.example.Students.repo;



import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.example.Students.Model.Alien;


@Repository
public class AlienRepo {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    // save method
    public int save(Alien alien) {
        String sql = "INSERT INTO alien (id, name, tech) VALUES (?, ?, ?)";
        return jdbcTemplate.update(sql, alien.getId(), alien.getName(), alien.getTech());
    }

    // find all method
    public List<Alien> findAll() {
        String sql = "SELECT * FROM alien";
        RowMapper<Alien> rowMapper = (rs, rowNum) -> {
            Alien a = new Alien();
            a.setId(rs.getInt("id"));
            a.setName(rs.getString("name"));
            a.setTech(rs.getString("tech"));
            return a;
        };
        return jdbcTemplate.query(sql, rowMapper);
    }
}

