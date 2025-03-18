package com.toan.english_center.Entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

@Entity
@Table(name = "tbl_account")
public class Account {
    @Id
    @Column(name = "a_id", columnDefinition = "CHAR(36)", nullable = false)
    @NotNull
    private String aId;

    @Column(name = "a_uid", nullable = false)
    private String aUid;

    @Column(name = "a_pwd", nullable = false)
    private String aPwd;

    @Column(name = "a_type", nullable = false)
    private int aType; // 0: admin, 1: teacher, 2: student, 3: staff

    @Column(name = "created_date")
    private LocalDateTime createdDate;

    @Column(name = "updated_date")
    private LocalDateTime updatedDate;

    @Column(name = "a_status")
    private int aStatus = 1;

    @Column(name = "jsondata")
    private String jsonData;

    // Constructors
    public Account() {
        this.aId = java.util.UUID.randomUUID().toString();
    }

    // Getter and setter


    public @NotNull String getaId() {
        return aId;
    }

    public void setaId(@NotNull String aId) {
        this.aId = aId;
    }

    public String getaUid() {
        return aUid;
    }

    public void setaUid(String aUid) {
        this.aUid = aUid;
    }

    public String getaPwd() {
        return aPwd;
    }

    public void setaPwd(String aPwd) {
        this.aPwd = aPwd;
    }

    public int getaType() {
        return aType;
    }

    public void setaType(int aType) {
        this.aType = aType;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public LocalDateTime getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(LocalDateTime updatedDate) {
        this.updatedDate = updatedDate;
    }

    public int getaStatus() {
        return aStatus;
    }

    public void setaStatus(int aStatus) {
        this.aStatus = aStatus;
    }

    public String getJsonData() {
        return jsonData;
    }

    public void setJsonData(String jsonData) {
        this.jsonData = jsonData;
    }
}
