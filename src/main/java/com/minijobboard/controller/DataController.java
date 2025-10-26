package com.minijobboard.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;

@RestController
@RequestMapping("/api")
public class DataController {
    
    @GetMapping("/sample-jobs")
    public Map<String, Object> getSampleJobs() {
        List<Map<String, Object>> jobs = Arrays.asList(
            createJob(1, "Senior Software Developer", "Tech Corp", "Full-stack development with Java and React", "New York", 95000, "Software Development"),
            createJob(2, "Frontend Developer", "Tech Corp", "React and TypeScript development", "Remote", 75000, "Frontend"),
            createJob(3, "Data Scientist", "StartupXYZ", "Machine learning and data analysis", "San Francisco", 110000, "Data & Analytics"),
            createJob(4, "Backend Developer", "Tech Corp", "Java Spring Boot development", "Austin", 85000, "Software Development"),
            createJob(5, "UI/UX Designer", "DesignStudio", "User interface and experience design", "Remote", 70000, "Frontend"),
            createJob(6, "DevOps Engineer", "CloudTech", "AWS and Docker deployment", "Seattle", 100000, "Software Development"),
            createJob(7, "Data Analyst", "AnalyticsCorp", "Business intelligence and reporting", "Chicago", 65000, "Data & Analytics"),
            createJob(8, "Mobile Developer", "AppWorks", "React Native mobile development", "Remote", 80000, "Frontend"),
            createJob(9, "Full Stack Developer", "WebSolutions", "End-to-end web development", "Boston", 90000, "Software Development"),
            createJob(10, "Business Analyst", "FinanceCorp", "Financial data analysis", "New York", 75000, "Data & Analytics")
        );
        
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("data", jobs);
        response.put("count", jobs.size());
        return response;
    }
    
    private Map<String, Object> createJob(int id, String title, String company, String description, String location, int salary, String category) {
        Map<String, Object> job = new HashMap<>();
        job.put("job_id", id);
        job.put("title", title);
        job.put("company", company);
        job.put("description", description);
        job.put("location", location);
        job.put("salary", salary);
        job.put("category", category);
        job.put("company_id", (id % 3) + 1);
        return job;
    }
}
