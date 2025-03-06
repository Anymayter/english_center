package com.toan.english_center.Service.Impl;

import com.toan.english_center.DTO.LessonDTO;
import com.toan.english_center.Entity.Lesson;
import com.toan.english_center.Exception.ResourceNotFoundException;
import com.toan.english_center.Repository.LessonRepository;
import com.toan.english_center.Service.LessonService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LessonServiceImpl implements LessonService {

    private final LessonRepository lessonRepository;

    public LessonServiceImpl(LessonRepository lessonRepository) {
        this.lessonRepository = lessonRepository;
    }

    @Override
    public LessonDTO createLesson(LessonDTO lessonDTO) {
        Lesson lesson = new Lesson();
        BeanUtils.copyProperties(lessonDTO, lesson);
        lesson.setCreatedDate(LocalDateTime.now());
        lesson = lessonRepository.save(lesson);
        BeanUtils.copyProperties(lesson, lessonDTO);
        return lessonDTO;
    }

    @Override
    public LessonDTO getLessonById(String id) {
        Lesson lesson = lessonRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Lesson not found with id: " + id));
        LessonDTO lessonDTO = new LessonDTO();
        BeanUtils.copyProperties(lesson, lessonDTO);
        return lessonDTO;
    }

    @Override
    public List<LessonDTO> getAllLessons() {
        List<Lesson> lessons = lessonRepository.findAll();
        return lessons.stream()
                .map(lesson -> {
                    LessonDTO lessonDTO = new LessonDTO();
                    BeanUtils.copyProperties(lesson, lessonDTO);
                    return lessonDTO;
                })
                .collect(Collectors.toList());
    }

    @Override
    public LessonDTO updateLesson(String id, LessonDTO lessonDTO) {
        Lesson lesson = lessonRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Lesson not found with id: " + id));
        BeanUtils.copyProperties(lessonDTO, lesson);
        lesson.setUpdatedDate(LocalDateTime.now());
        lesson = lessonRepository.save(lesson);
        BeanUtils.copyProperties(lesson, lessonDTO);
        return lessonDTO;
    }

    @Override
    public void deleteLesson(String id) {
        Lesson lesson = lessonRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Lesson not found with id: " + id));
        lessonRepository.delete(lesson);
    }
}