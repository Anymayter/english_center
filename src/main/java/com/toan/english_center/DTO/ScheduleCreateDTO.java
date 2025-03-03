package com.toan.english_center.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.Date;

public class ScheduleCreateDTO {
    @NotBlank(message = "Class ID là bắt buộc")
    private String classId;

    @NotBlank(message = "Teacher ID là bắt buộc")
    private String tcId;

    @NotNull(message = "Start time là bắt buộc")
    private Date startTime;

    @NotNull(message = "End time là bắt buộc")
    private Date endTime;

    private String creatorId;
    private String jsonData;

    // Getters and setters

    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }

    public String getTcId() {
        return tcId;
    }

    public void setTcId(String tcId) {
        this.tcId = tcId;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(String creatorId) {
        this.creatorId = creatorId;
    }

    public String getJsonData() {
        return jsonData;
    }

    public void setJsonData(String jsonData) {
        this.jsonData = jsonData;
    }
}
