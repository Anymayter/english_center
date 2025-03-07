package com.toan.english_center.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
@Table(name = "tbl_teaching_content")
public class TeachingContent {

    @Id
    @Column(name = "teaching_id", length = 10, nullable = false)
    private String teachingId;

    @Column(name = "p_id", length = 10)
    private String pId;

    @Column(name = "l_id", length = 10)
    private String lId;

    @Column(name = "class_id", length = 10)
    private String classId;

    @Column(name = "teacher_id", length = 10)
    private String teacherId;

    @Column(name = "title", length = 50)
    private String title;

    @Column(name = "content", columnDefinition = "text")
    private String content;

    @Column(name = "filepath", columnDefinition = "text")
    private String filepath;

    @Column(name = "created_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @Column(name = "updated_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedDate;

    @Column(name = "creator_id", length = 10)
    private String creatorId;

    @Column(name = "updator_id", length = 10)
    private String updatorId;

    @Column(name = "teaching_content_status", columnDefinition = "int default 1")
    private Integer teachingContentStatus;

    @Column(name = "jsondata", columnDefinition = "text")
    private String jsonData;

    public void setTeachingId(String teachingId) {
        this.teachingId = teachingId;
        this.updatedDate = new Date();
        this.creatorId = "admin";
        this.updatorId = "admin";
        this.teachingContentStatus = 1;
        this.jsonData = "{\"type\": \"TEACHING_CONTENT\", \"contentId\": \"" + this.teachingId + "\"}";

    }

    public String getTeachingId() {
        return teachingId;
    }

    // Getters and Setters
}