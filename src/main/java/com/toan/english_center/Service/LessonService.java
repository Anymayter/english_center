package com.toan.english_center.Service;

import com.toan.english_center.DTO.LessonDTO;
import java.util.List;

public interface LessonService {
    LessonDTO createLesson(LessonDTO lessonDTO);
    LessonDTO getLessonById(String id);
    List<LessonDTO> getAllLessons();
    LessonDTO updateLesson(String id, LessonDTO lessonDTO);
    void deleteLesson(String id);
}