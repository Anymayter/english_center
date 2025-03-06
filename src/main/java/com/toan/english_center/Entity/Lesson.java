package com.toan.english_center.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import java.time.LocalTime;
import java.time.LocalDateTime;

@Entity
@Table(name = "tbl_lession")
@Data
public class Lesson {
    @Id
    @Column(name = "l_id")
    private String id;

    @Column(name = "l_name", nullable = false)
    private String name;

    @Column(name = "l_time")
    private LocalTime time;

    @Column(name = "l_desc")
    private String description;

    @Column(name = "l_p_id")
    private String programId;

    @Column(name = "created_date")
    private LocalDateTime createdDate;

    @Column(name = "updated_date")
    private LocalDateTime updatedDate;

    @Column(name = "creator_id")
    private String creatorId;

    @Column(name = "updator_id")
    private String updatorId;

    @Column(name = "lession_status")
    private Integer status = 1;

    @Column(name = "jsondata")
    private String jsonData;
}