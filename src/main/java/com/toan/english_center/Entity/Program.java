package com.toan.english_center.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "tbl_program")
public class Program {
    @Id
    @Column(name = "p_id", length = 10)
    private String id;

    @Column(name = "p_name", length = 50, nullable = false)
    private String name;

    @Column(name = "p_description")
    private String description;

    @Column(name = "created_date")
    private LocalDateTime createdDate;

    @Column(name = "updated_date")
    private LocalDateTime updatedDate;

    @Column(name = "creator_id", length = 10)
    private String creatorId;

    @Column(name = "updator_id", length = 10)
    private String updatorId;

    @Column(name = "program_status", columnDefinition = "int default 1")
    private Integer programStatus;

    @Column(name = "jsondata")
    private String jsonData;
}