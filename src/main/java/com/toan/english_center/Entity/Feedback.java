package com.toan.english_center.Entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;

@Entity
@Data

public class Feedback {
    // Getters and setters
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Tự động tăng ID
    private Long feedbackId; // ID phản hồi

    @Column(nullable = false)
    private String studentId; // ID học viên (liên kết với bảng Student)

    @Column(nullable = false)
    private String teacherId; // ID giáo viên (liên kết với bảng Teacher)

    @Column(nullable = false)
    private String classId; // ID lớp học (liên kết với bảng Class)

    @Column(nullable = false, columnDefinition = "TEXT")
    private String content; // Nội dung phản hồi

    private String createdDate; // Ngày tạo phản hồi
    private String updatedDate; // Ngày cập nhật phản hồi

    @Column(nullable = false)
    private int status = 1; // Trạng thái: 1 = hoạt động, 0 = không hoạt động

    private String jsondata; // Dữ liệu dạng JSON (nếu cần dùng)

    public void setFeedbackId(Long feedbackId) {
        this.feedbackId = feedbackId;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public String getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(String updatedDate) {
        this.updatedDate = updatedDate;
    }
}