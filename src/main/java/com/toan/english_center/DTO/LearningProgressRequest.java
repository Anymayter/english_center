package com.toan.english_center.DTO;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class LearningProgressRequest {

    @NotBlank
    private String svId;

    @NotBlank
    private String classId;

    @Min(0) @Max(100)
    private Integer progress = 0;

    private String note;

    // Getter and setter


    public @NotBlank String getSvId() {
        return svId;
    }

    public void setSvId(@NotBlank String svId) {
        this.svId = svId;
    }

    public @NotBlank String getClassId() {
        return classId;
    }

    public void setClassId(@NotBlank String classId) {
        this.classId = classId;
    }

    public @Min(0) @Max(100) Integer getProgress() {
        return progress;
    }

    public void setProgress(@Min(0) @Max(100) Integer progress) {
        this.progress = progress;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
