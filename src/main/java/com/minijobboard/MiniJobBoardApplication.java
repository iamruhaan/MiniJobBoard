package com.minijobboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main Spring Boot Application class for MiniJobBoard
 * 
 * This application provides REST APIs for:
 * - User registration (students and companies)
 * - Job posting (by companies)
 * - Job applications (by students)
 * - Job search and filtering
 * 
 * Database: MySQL with JDBC (no JPA)
 * Port: 8080
 */
@SpringBootApplication
public class MiniJobBoardApplication {

    public static void main(String[] args) {
        SpringApplication.run(MiniJobBoardApplication.class, args);
        System.out.println("==========================================");
        System.out.println("MiniJobBoard Application Started Successfully!");
        System.out.println("Server running on: http://localhost:8080");
        System.out.println("Web Interface: http://localhost:8080/index.html");
        System.out.println("==========================================");
    }
}
