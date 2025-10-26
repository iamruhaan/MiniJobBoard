package com.minijobboard.service;

import com.minijobboard.dao.UserDao;
import com.minijobboard.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    public User registerUser(User user) {
        if (user.getName() == null || user.getName().trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        if (user.getEmail() == null || user.getEmail().trim().isEmpty()) {
            throw new IllegalArgumentException("Email cannot be null or empty");
        }
        if (user.getRole() == null || (!user.getRole().equals("student") && !user.getRole().equals("company"))) {
            throw new IllegalArgumentException("Role must be either 'student' or 'company'");
        }
        if (userDao.existsByEmail(user.getEmail())) {
            throw new IllegalArgumentException("User with email " + user.getEmail() + " already exists");
        }
        if (!user.getEmail().contains("@") || !user.getEmail().contains(".")) {
            throw new IllegalArgumentException("Invalid email format");
        }
        return userDao.createUser(user);
    }

    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }
}
