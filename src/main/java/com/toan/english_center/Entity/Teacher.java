package com.toan.english_center.Entity;


import jakarta.persistence.*;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "tbl_teacher")
public class Teacher {

    @Id
    @Column(name = "tc_id", length = 20)
    private String tcId;

    @ManyToOne
    @JoinColumn(name = "a_id", nullable = false)
    private Account account;

    private String tcName;
    private String tcEmail;
    private String tcDob;
    private String tcPhoneNumber;
    private String tcGender;
    private String tcImage;
    private String tcRole;
    private LocalDate createdDate;
    private Timestamp updatedDate;
    private String creatorId; // creator_id
    private String updatorId; // updator_id
    private int tcStatus; // sv_status
    private String jsonData; // jsondata


    // Getter and setter


    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public String getTcId() {
        return tcId;
    }

    public void setTcId(String tcId) {
        this.tcId = tcId;
    }

    public String getTcName() {
        return tcName;
    }

    public void setTcName(String tcName) {
        this.tcName = tcName;
    }

    public String getTcEmail() {
        return tcEmail;
    }

    public void setTcEmail(String tcEmail) {
        this.tcEmail = tcEmail;
    }

    public String getTcDob() {
        return tcDob;
    }

    public void setTcDob(String tcDob) {
        this.tcDob = tcDob;
    }

    public String getTcPhoneNumber() {
        return tcPhoneNumber;
    }

    public void setTcPhoneNumber(String tcPhoneNumber) {
        this.tcPhoneNumber = tcPhoneNumber;
    }

    public String getTcGender() {
        return tcGender;
    }

    public void setTcGender(String tcGender) {
        this.tcGender = tcGender;
    }

    public String getTcImage() {
        return tcImage;
    }

    public void setTcImage(String tcImage) {
        this.tcImage = tcImage;
    }

    public String getTcRole() {
        return tcRole;
    }

    public void setTcRole(String tcRole) {
        this.tcRole = tcRole;
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

    public int getTcStatus() {
        return tcStatus;
    }

    public void setTcStatus(int tcStatus) {
        this.tcStatus = tcStatus;
    }

    public String getJsonData() {
        return jsonData;
    }

    public void setJsonData(String jsonData) {
        this.jsonData = jsonData;
    }


}
