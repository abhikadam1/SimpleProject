package com.example.SimpleProject.Dao;
import com.example.SimpleProject.Model.Log;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class LogDAO {

    private final JdbcTemplate jdbcTemplate;

    public LogDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

//    public List<Log> getAllLogs() {
//        String sql = "SELECT * FROM logs";
//        return jdbcTemplate.query(sql, (rs, rowNum) ->
//                new Log(
//                        rs.getInt("id"),
//                        rs.getString("message"),
//                        rs.getTimestamp("created_at")
//                )
//        );
//    }

    public List<Log> getAllLogs() {
        return jdbcTemplate.query("SELECT * FROM logs", (rs, rowNum) -> {
            Log log = new Log();
            log.setId(rs.getInt("id"));
            log.setMessage(rs.getString("message"));
            log.setCreatedAt(rs.getTimestamp("created_at"));
            return log;
        });
    }

    public int insertLog(String message) {
        String sql = "INSERT INTO logs(message) VALUES(?)";
        return jdbcTemplate.update(sql, message);
    }
}