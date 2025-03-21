package com.toan.english_center.Entity;


import jakarta.persistence.*;

@Entity
@Table(name = "tbl_feedback")
public class Feedback {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Tự động tăng ID
    private Long feedbackId; // ID phản hồi

    @Column(nullable = false)
    private String svId; // ID học viên (liên kết với bảng Student)

    @Column(nullable = false)
    private String tcId; // ID giáo viên (liên kết với bảng Teacher)

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

    public Long getFeedbackId() {
        return feedbackId;
    }

    public String getSvId() {
        return svId;
    }

    public void setSvId(String svId) {
        this.svId = svId;
    }

    public String getTcId() {
        return tcId;
    }

    public void setTcId(String tcId) {
        this.tcId = tcId;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getJsondata() {
        return jsondata;
    }

    public void setJsondata(String jsondata) {
        this.jsondata = jsondata;
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
