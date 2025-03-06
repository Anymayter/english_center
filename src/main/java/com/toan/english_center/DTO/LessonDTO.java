package com.toan.english_center.DTO;

import lombok.Data;
import java.time.LocalTime;

@Data
public class LessonDTO {
    private String id;
    private String name;
    private LocalTime time;
    private String description;
    private String programId;
    private Integer status;
    private String jsonData;
}