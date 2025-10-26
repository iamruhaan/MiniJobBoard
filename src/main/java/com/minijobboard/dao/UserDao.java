package com.minijobboard.dao;

import com.minijobboard.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Repository
public class UserDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static final String INSERT_USER = "INSERT INTO users (name, email, role) VALUES (?, ?, ?)";
    private static final String SELECT_ALL_USERS = "SELECT user_id, name, email, role, created_at, updated_at FROM users";
    private static final String SELECT_USER_BY_EMAIL = "SELECT user_id, name, email, role, created_at, updated_at FROM users WHERE email = ?";
    private static final String CHECK_EMAIL_EXISTS = "SELECT COUNT(*) FROM users WHERE email = ?";

    private static class UserRowMapper implements RowMapper<User> {
        @Override
        public User mapRow(ResultSet rs, int rowNum) throws SQLException {
            User user = new User();
            user.setUserId(rs.getInt("user_id"));
            user.setName(rs.getString("name"));
            user.setEmail(rs.getString("email"));
            user.setRole(rs.getString("role"));
            if (rs.getTimestamp("created_at") != null) {
                user.setCreatedAt(rs.getTimestamp("created_at").toLocalDateTime());
            }
            if (rs.getTimestamp("updated_at") != null) {
                user.setUpdatedAt(rs.getTimestamp("updated_at").toLocalDateTime());
            }
            return user;
        }
    }

    public User createUser(User user) {
        jdbcTemplate.update(INSERT_USER, user.getName(), user.getEmail(), user.getRole());
        return getUserByEmail(user.getEmail()).orElse(null);
    }

    public List<User> getAllUsers() {
        return jdbcTemplate.query(SELECT_ALL_USERS, new UserRowMapper());
    }

    public Optional<User> getUserByEmail(String email) {
        List<User> users = jdbcTemplate.query(SELECT_USER_BY_EMAIL, new UserRowMapper(), email);
        return users.isEmpty() ? Optional.empty() : Optional.of(users.get(0));
    }

    public boolean existsByEmail(String email) {
        Integer count = jdbcTemplate.queryForObject(CHECK_EMAIL_EXISTS, Integer.class, email);
        return count != null && count > 0;
    }
}
