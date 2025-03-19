package com.toan.english_center.Entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "tbl_mark")
public class Mark {

    @Id
    @Column(name = "m_id", length = 36)
    private String markId;

    @Column(name = "class_id", length = 10)
    private String classId;

    @Column(name = "sv_id", length = 10)
    private String studentId;

    @Column(name = "m_date")
    @Temporal(TemporalType.DATE)
    private Date markDate;

    @Column(name = "m_content")
    private String content;

    @Column(name = "m_point")
    private Integer point;

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

    @Column(name = "mark_status")
    private Integer status = 1;

    @Column(name = "jsondata")
    private String jsonData;

    // Getter and setter

    public String getMarkId() {
        return markId;
    }

    public void setMarkId(String markId) {
        this.markId = markId;
    }

    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public Date getMarkDate() {
        return markDate;
    }

    public void setMarkDate(Date markDate) {
        this.markDate = markDate;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getPoint() {
        return point;
    }

    public void setPoint(Integer point) {
        this.point = point;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getJsonData() {
        return jsonData;
    }

    public void setJsonData(String jsonData) {
        this.jsonData = jsonData;
    }
}
