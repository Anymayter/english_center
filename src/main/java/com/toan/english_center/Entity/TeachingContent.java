package com.toan.english_center.Entity;


import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "tbl_teaching_content")
public class TeachingContent {

//    @Id
//    private String teachingId;
//
//    // Liên kết với bảng chương trình học (tbl_program)
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "p_id", referencedColumnName = "p_id")
//    private Program program;
//
//    // Liên kết với bảng bài học (tbl_lession)
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "l_id", referencedColumnName = "l_id")
//    private Lesson lesson;
//
//    // Liên kết với bảng lớp học (tbl_class)
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "class_id", referencedColumnName = "class_id")
//    private Classes classEntity;
//
//    // Liên kết với bảng giáo viên (tbl_teacher)
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "teacher_id", referencedColumnName = "tc_id")
//    private Teacher teacher;
//
//    private String title;
//
//    private String content;
//
//    private String filepath;
//
//    private Date createdDate;
//
//    private Date updatedDate;
//
//    private String creatorId;
//
//    private String updatorId;
//
//    private Integer teachingContentStatus;
//
//    private String jsondata;
//
//    // Getter and setter
//
//
//    public String getTeachingId() {
//        return teachingId;
//    }
//
//    public void setTeachingId(String teachingId) {
//        this.teachingId = teachingId;
//    }
//
//    public Program getProgram() {
//        return program;
//    }
//
//    public void setProgram(Program program) {
//        this.program = program;
//    }
//
//    public Lesson getLesson() {
//        return lesson;
//    }
//
//    public void setLesson(Lesson lesson) {
//        this.lesson = lesson;
//    }
//
//    public Classes getClassEntity() {
//        return classEntity;
//    }
//
//    public void setClassEntity(Classes classEntity) {
//        this.classEntity = classEntity;
//    }
//
//    public Teacher getTeacher() {
//        return teacher;
//    }
//
//    public void setTeacher(Teacher teacher) {
//        this.teacher = teacher;
//    }
//
//    public String getTitle() {
//        return title;
//    }
//
//    public void setTitle(String title) {
//        this.title = title;
//    }
//
//    public String getContent() {
//        return content;
//    }
//
//    public void setContent(String content) {
//        this.content = content;
//    }
//
//    public String getFilepath() {
//        return filepath;
//    }
//
//    public void setFilepath(String filepath) {
//        this.filepath = filepath;
//    }
//
//    public Date getCreatedDate() {
//        return createdDate;
//    }
//
//    public void setCreatedDate(Date createdDate) {
//        this.createdDate = createdDate;
//    }
//
//    public Date getUpdatedDate() {
//        return updatedDate;
//    }
//
//    public void setUpdatedDate(Date updatedDate) {
//        this.updatedDate = updatedDate;
//    }
//
//    public String getCreatorId() {
//        return creatorId;
//    }
//
//    public void setCreatorId(String creatorId) {
//        this.creatorId = creatorId;
//    }
//
//    public String getUpdatorId() {
//        return updatorId;
//    }
//
//    public void setUpdatorId(String updatorId) {
//        this.updatorId = updatorId;
//    }
//
//    public Integer getTeachingContentStatus() {
//        return teachingContentStatus;
//    }
//
//    public void setTeachingContentStatus(Integer teachingContentStatus) {
//        this.teachingContentStatus = teachingContentStatus;
//    }
//
//    public String getJsondata() {
//        return jsondata;
//    }
//
//    public void setJsondata(String jsondata) {
//        this.jsondata = jsondata;
//    }

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

    public String getpId() {
        return pId;
    }

    public void setpId(String pId) {
        this.pId = pId;
    }

    public String getlId() {
        return lId;
    }

    public void setlId(String lId) {
        this.lId = lId;
    }

    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getFilepath() {
        return filepath;
    }

    public void setFilepath(String filepath) {
        this.filepath = filepath;
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

    public Integer getTeachingContentStatus() {
        return teachingContentStatus;
    }

    public void setTeachingContentStatus(Integer teachingContentStatus) {
        this.teachingContentStatus = teachingContentStatus;
    }

    public String getJsonData() {
        return jsonData;
    }

    public void setJsonData(String jsonData) {
        this.jsonData = jsonData;
    }
}
