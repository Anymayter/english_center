package com.toan.english_center.DTO;

import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;
import java.util.Date;

public class TeachingContentDTO {
    @Getter
    @Setter
    private String teachingId;
    private String pId;
    private String lId;
    private String classId;
    private String teacherId;
    private String title;
    private String content;
    private String filepath;
    private Date createdDate;
    private Date updatedDate;
    private String creatorId;
    private String updatorId;
    private Integer teachingContentStatus;
    private String jsonData;

    public void setPId(String pId) {
        this.pId = pId;
        this.jsonData = "{\"pId\":\"" + pId + "\"}";
        this.updatedDate = new Date();
        this.creatorId = "admin";
        this.updatorId = "admin";
        this.teachingContentStatus = 1;
        this.createdDate = new Date();
        this.filepath = Arrays.toString(filepath.getBytes());
        this.title = "";
        this.content = "";
        this.jsonData += ", \"title\":\"" + title + "\", \"content\":\"" + content + "\", \"filepath\":\"" + filepath + "\", \"createdDate\":\"" + createdDate + "\", \"updatedDate\":\"" + updatedDate + "\", \"creatorId\":\"" + creatorId + "\", \"updatorId\":\"" + updatorId + "\", \"teachingContentStatus\":\"" + teachingContentStatus + "\"}";
    }

    public String getPId() {
        return pId;

    }

    public String getLId() {
        return lId;
    }

    public void setLId(String lId) {
        this.lId = lId;
        this.jsonData = jsonData.replace(", \"pId\":\"" + pId + "\"", ", \"pId\":\"" + pId + "\", \"lId\":\"" + lId + "\"");
        this.updatedDate = new Date();
    }

    public void setClassId(String classId) {
        this.classId = classId;
        this.jsonData = jsonData.replace(", \"pId\":\"" + pId + "\", \"lId\":\"" + lId + "\"", ", \"pId\":\"" + pId + "\", \"lId\":\"" + lId + "\", \"classId\":\"" + classId + "\"");
        this.updatedDate = new Date();
    }

    public String getClassId() {
        return classId;
    }

    public String getTeacherId() {
        return teacherId;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public String getFilepath() {
        return filepath;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public String getUpdatorId() {
        return updatorId;
    }

    public Integer getTeachingContentStatus() {
        return teachingContentStatus;

    }

    public String getJsonData() {
        return jsonData;
    }

    public String getCreatorId() {
        return creatorId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
        this.jsonData = jsonData.replace(", \"pId\":\"" + pId + "\", \"lId\":\"" + lId + "\", \"classId\":\"" + classId + "\"", ", \"pId\":\"" + pId + "\", \"lId\":\"" + lId + "\", \"classId\":\"" + classId + "\", \"teacherId\":\"" + teacherId + "\"");
        this.updatedDate = new Date();
    }

    public void setTitle(String title) {
        this.title = title;
        this.jsonData = jsonData.replace(", \"pId\":\"" + pId + "\", \"lId\":\"" + lId + "\", \"classId\":\"" + classId + "\", \"teacherId\":\"" + teacherId + "\"", ", \"pId\":\"" + pId + "\", \"lId\":\"" + lId + "\", \"classId\":\"" + classId + "\", \"teacherId\":\"" + teacherId + "\", \"title\":\"" + title + "\"");
        this.updatedDate = new Date();
    }

    public void setContent(String content) {
        this.content = content;
        this.jsonData = jsonData.replace(", \"pId\":\"" + pId + "\", \"lId\":\"" + lId + "\", \"classId\":\"" + classId + "\", \"teacherId\":\"" + teacherId + "\", \"title\":\"" + title + "\"", ", \"pId\":\"" + pId + "\", \"lId\":\"" + lId + "\", \"classId\":\"" + classId + "\", \"teacherId\":\"" + teacherId + "\", \"title\":\"" + title + "\", \"content\":\"" + content + "\"");
        this.updatedDate = new Date();
    }

    public void setFilepath(String filepath) {
        this.filepath = filepath;
        this.jsonData = jsonData.replace(", \"pId\":\"" + pId + "\", \"lId\":\"" + lId + "\", \"classId\":\"" + classId + "\", \"teacherId\":\"" + teacherId + "\", \"title\":\"" + title + "\", \"content\":\"" + content + "\"", ", \"pId\":\"" + pId + "\", \"lId\":\"" + lId + "\", \"classId\":\"" + classId + "\", \"teacherId\":\"" + teacherId + "\", \"title\":\"" + title + "\", \"content\":\"" + content + "\", \"filepath\":\"" + filepath + "\"");
        this.updatedDate = new Date();
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
        this.jsonData = jsonData.replace(", \"pId\":\"" + pId + "\", \"lId\":\"" + lId + "\", \"classId\":\"" + classId + "\", \"teacherId\":\"" + teacherId + "\", \"title\":\"" + title + "\", \"content\":\"" + content + "\", \"filepath\":\"" + filepath + "\"", ", \"pId\":\"" + pId + "\", \"lId\":\"" + lId + "\", \"classId\":\"" + classId + "\", \"teacherId\":\"" + teacherId + "\", \"title\":\"" + title + "\", \"content\":\"" + content + "\", \"filepath\":\"" + filepath + "\", \"createdDate\":\"" + createdDate + "\"");
        this.updatedDate = new Date();
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
        this.jsonData = jsonData.replace(", \"pId\":\"" + pId + "\", \"lId\":\"" + lId + "\", \"classId\":\"" + classId + "\", \"teacherId\":\"" + teacherId + "\", \"title\":\"" + title + "\", \"content\":\"" + content + "\", \"filepath\":\"" + filepath + "\", \"createdDate\":\"" + createdDate + "\"", ", \"pId\":\"" + pId + "\", \"lId\":\"" + lId + "\", \"classId\":\"" + classId + "\", \"teacherId\":\"" + teacherId + "\", \"title\":\"" + title + "\", \"content\":\"" + content + "\", \"filepath\":\"" + filepath + "\", \"createdDate\":\"" + createdDate + "\", \"updatedDate\":\"" + updatedDate + "\"");
        this.updatedDate = new Date();
    }

    public void setCreatorId(String creatorId) {
        this.creatorId = creatorId;
        this.jsonData = jsonData.replace(", \"pId\":\"" + pId + "\", \"lId\":\"" + lId + "\", \"classId\":\"" + classId + "\", \"teacherId\":\"" + teacherId + "\", \"title\":\"" + title + "\", \"content\":\"" + content + "\", \"filepath\":\"" + filepath + "\", \"createdDate\":\"" + createdDate + "\", \"updatedDate\":\"" + updatedDate + "\"", ", \"pId\":\"" + pId + "\", \"lId\":\"" + lId + "\", \"classId\":\"" + classId + "\", \"teacherId\":\"" + teacherId + "\", \"title\":\"" + title + "\", \"content\":\"" + content + "\", \"filepath\":\"" + filepath + "\", \"createdDate\":\"" + createdDate + "\", \"updatedDate\":\"" + updatedDate + "\", \"creatorId\":\"" + creatorId + "\"");
        this.updatedDate = new Date();
    }

    public void setUpdatorId(String updatorId) {
        this.updatorId = updatorId;
        this.jsonData = jsonData.replace(", \"pId\":\"" + pId + "\", \"lId\":\"" + lId + "\", \"classId\":\"" + classId + "\", \"teacherId\":\"" + teacherId + "\", \"title\":\"" + title + "\", \"content\":\"" + content + "\", \"filepath\":\"" + filepath + "\", \"createdDate\":\"" + createdDate + "\", \"updatedDate\":\"" + updatedDate + "\", \"creatorId\":\"" + creatorId + "\"", ", \"pId\":\"" + pId + "\", \"lId\":\"" + lId + "\", \"classId\":\"" + classId + "\", \"teacherId\":\"" + teacherId + "\", \"title\":\"" + title + "\", \"content\":\"" + content + "\", \"filepath\":\"" + filepath + "\", \"createdDate\":\"" + createdDate + "\", \"updatedDate\":\"" + updatedDate + "\", \"creatorId\":\"" + creatorId + "\", \"updatorId\":\"" + updatorId + "\"");
        this.updatedDate = new Date();
    }

    public void setTeachingContentStatus(Integer teachingContentStatus) {
        this.teachingContentStatus = teachingContentStatus;
        this.jsonData = jsonData.replace(", \"pId\":\"" + pId + "\", \"lId\":\"" + lId + "\", \"classId\":\"" + classId + "\", \"teacherId\":\"" + teacherId + "\", \"title\":\"" + title + "\", \"content\":\"" + content + "\", \"filepath\":\"" + filepath + "\", \"createdDate\":\"" + createdDate + "\", \"updatedDate\":\"" + updatedDate + "\", \"creatorId\":\"" + creatorId + "\", \"updatorId\":\"" + updatorId + "\"", ", \"pId\":\"" + pId + "\", \"lId\":\"" + lId + "\", \"classId\":\"" + classId + "\", \"teacherId\":\"" + teacherId + "\", \"title\":\"" + title + "\", \"content\":\"" + content + "\", \"filepath\":\"" + filepath + "\", \"createdDate\":\"" + createdDate + "\", \"updatedDate\":\"" + updatedDate + "\", \"creatorId\":\"" + creatorId + "\", \"updatorId\":\"" + updatorId + "\", \"teachingContentStatus\":\"" + teachingContentStatus + "\"");
        this.updatedDate = new Date();
    }

    public void setJsonData(String jsonData) {
        this.jsonData = jsonData;
        this.updatedDate = new Date();
    }

    // Getters and Setters
}