package com.toan.english_center.Entity;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "tbl_student")
public class Student {

    @Id
    @Column(name = "sv_id", columnDefinition = "CHAR(36)", nullable = false)
    private String svId;

    @ManyToOne
    @JoinColumn(name = "a_id", nullable = false)
    private Account account;

    private String svName;
    private String svEmail;
    private String svDob;
    private String svPhoneNumber;
    private String svGender;
    private String svImage;
    private String svAddress;
    private String svFbUrl;
    private String svRole;
    private LocalDate createdDate;
    private Timestamp updatedDate;
    private String creatorId; // creator_id
    private String updatorId; // updator_id
    private int svStatus; // sv_status
    private String jsonData; // jsondata

    // Getter and setter


    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public String getSvId() {
        return svId;
    }

    public void setSvId(String svId) {
        this.svId = svId;
    }

    public String getSvName() {
        return svName;
    }

    public void setSvName(String svName) {
        this.svName = svName;
    }

    public String getSvEmail() {
        return svEmail;
    }

    public void setSvEmail(String svEmail) {
        this.svEmail = svEmail;
    }

    public String getSvPhoneNumber() {
        return svPhoneNumber;
    }

    public void setSvPhoneNumber(String svPhoneNumber) {
        this.svPhoneNumber = svPhoneNumber;
    }

    public String getSvGender() {
        return svGender;
    }

    public void setSvGender(String svGender) {
        this.svGender = svGender;
    }

    public String getSvImage() {
        return svImage;
    }

    public void setSvImage(String svImage) {
        this.svImage = svImage;
    }

    public String getSvAddress() {
        return svAddress;
    }

    public void setSvAddress(String svAddress) {
        this.svAddress = svAddress;
    }

    public String getSvFbUrl() {
        return svFbUrl;
    }

    public void setSvFbUrl(String svFbUrl) {
        this.svFbUrl = svFbUrl;
    }

    public String getSvRole() {
        return svRole;
    }

    public void setSvRole(String svRole) {
        this.svRole = svRole;
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

    public int getSvStatus() {
        return svStatus;
    }

    public void setSvStatus(int svStatus) {
        this.svStatus = svStatus;
    }

    public String getJsonData() {
        return jsonData;
    }

    public void setJsonData(String jsonData) {
        this.jsonData = jsonData;
    }

    public String getSvDob() {
        return svDob;
    }

    public void setSvDob(String svDob) {
        this.svDob = svDob;
    }
}
