package com.toan.english_center.DTO;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class ProgramDTO {
    private String id;
    private String name;
    private String description;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;
    private String creatorId;
    private String updatorId;
    private Integer programStatus;
    private String jsonData;
}