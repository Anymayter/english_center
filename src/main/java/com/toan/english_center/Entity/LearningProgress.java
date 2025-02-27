package com.toan.english_center.Entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

import java.sql.Timestamp;
import java.time.LocalDate;

@Entity
@Table(name = "tbl_learning_progress")
public class LearningProgress {

    @Id
    private String learningProgressId;

    @ManyToOne
    @JoinColumn(name = "sv_id")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "class_id")
    private Classes classes;

    private Integer progress;
    private String note;
    private LocalDate createdDate;
    private Timestamp updatedDate;
    private String creatorId;
    private String updatorId;
    private Integer learningProgressStatus;
    private String jsonData;

    // Getter and setter


    public String getLearningProgressId() {
        return learningProgressId;
    }

    public void setLearningProgressId(String learningProgressId) {
        this.learningProgressId = learningProgressId;
    }

    public Classes getClasses() {
        return classes;
    }

    public void setClasses(Classes classes) {
        this.classes = classes;
    }


    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public @Min(0) @Max(100) Integer getProgress() {
        return progress;
    }

    public void setProgress(@Min(0) @Max(100) Integer progress) {
        this.progress = progress;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }

    public Timestamp getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Timestamp updatedDate) {
        this.updatedDate = updatedDate;
    }

    public String getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(String creatorId) {
        this.creatorId = creatorId;
    }

    public String getUpdatorId() {
        return updatorId;
    }

    public void setUpdatorId(String updatorId) {
        this.updatorId = updatorId;
    }

    public Integer getLearningProgressStatus() {
        return learningProgressStatus;
    }

    public void setLearningProgressStatus(Integer learningProgressStatus) {
        this.learningProgressStatus = learningProgressStatus;
    }

    public String getJsonData() {
        return jsonData;
    }

    public void setJsonData(String jsonData) {
        this.jsonData = jsonData;
    }
}
