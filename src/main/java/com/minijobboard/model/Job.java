package com.minijobboard.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Job {
    private Integer jobId;
    private Integer companyId;
    private String title;
    private String description;
    private String location;
    private BigDecimal salary;
    private LocalDateTime createdAt;

    public Job() {}

    public Job(Integer jobId, Integer companyId, String title, String description, 
               String location, BigDecimal salary, LocalDateTime createdAt) {
        this.jobId = jobId;
        this.companyId = companyId;
        this.title = title;
        this.description = description;
        this.location = location;
        this.salary = salary;
        this.createdAt = createdAt;
    }

    public Job(Integer companyId, String title, String description, String location, BigDecimal salary) {
        this.companyId = companyId;
        this.title = title;
        this.description = description;
        this.location = location;
        this.salary = salary;
    }

    public Integer getJobId() {
        return jobId;
    }

    public void setJobId(Integer jobId) {
        this.jobId = jobId;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "Job{" +
                "jobId=" + jobId +
                ", companyId=" + companyId +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", location='" + location + '\'' +
                ", salary=" + salary +
                ", createdAt=" + createdAt +
                '}';
    }
}
