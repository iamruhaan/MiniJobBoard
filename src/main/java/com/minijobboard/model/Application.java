package com.minijobboard.model;

import java.time.LocalDateTime;

public class Application {
    private Integer appId;
    private Integer jobId;
    private Integer studentId;
    private String status;
    private LocalDateTime appliedAt;

    public Application() {}

    public Application(Integer appId, Integer jobId, Integer studentId, String status, LocalDateTime appliedAt) {
        this.appId = appId;
        this.jobId = jobId;
        this.studentId = studentId;
        this.status = status;
        this.appliedAt = appliedAt;
    }

    public Application(Integer jobId, Integer studentId, String status) {
        this.jobId = jobId;
        this.studentId = studentId;
        this.status = status;
    }

    public Integer getAppId() {
        return appId;
    }

    public void setAppId(Integer appId) {
        this.appId = appId;
    }

    public Integer getJobId() {
        return jobId;
    }

    public void setJobId(Integer jobId) {
        this.jobId = jobId;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getAppliedAt() {
        return appliedAt;
    }

    public void setAppliedAt(LocalDateTime appliedAt) {
        this.appliedAt = appliedAt;
    }

    @Override
    public String toString() {
        return "Application{" +
                "appId=" + appId +
                ", jobId=" + jobId +
                ", studentId=" + studentId +
                ", status='" + status + '\'' +
                ", appliedAt=" + appliedAt +
                '}';
    }
}
