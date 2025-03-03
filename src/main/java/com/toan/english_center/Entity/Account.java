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
    private String id;

    @Column(name = "a_uid", nullable = false)
    private String username;

    @Column(name = "a_pwd", nullable = false)
    private String password;

    @Column(name = "a_type", nullable = false)
    private int type; // 0: admin, 1: teacher, 2: student, 3: staff

    @Column(name = "created_date")
    private LocalDateTime createdDate;

    @Column(name = "updated_date")
    private LocalDateTime updatedDate;

    @Column(name = "a_status")
    private int status = 1;

    @Column(name = "jsondata")
    private String jsonData;

    // Constructors
    public Account() {
        this.id = java.util.UUID.randomUUID().toString();
    }

    // Getter and setter

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getJsonData() {
        return jsonData;
    }

    public void setJsonData(String jsonData) {
        this.jsonData = jsonData;
    }
}
