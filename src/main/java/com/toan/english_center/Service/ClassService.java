package com.toan.english_center.Service;


import com.toan.english_center.Entity.Classes;
import com.toan.english_center.Entity.Teacher;
import com.toan.english_center.Repository.ClassRepository;
import com.toan.english_center.Repository.TeacherRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassService {

    @Autowired
    private ClassRepository classRepository;

    @Autowired
    private TeacherRepository teacherRepository;

    @Transactional
    public List<Classes> findAll() {
        return classRepository.findAll();
    }

    @Transactional
    public void deleteByCId(String classId) {
        classRepository.deleteByClassId(classId);
    }

    @Transactional
    public Classes findByCId(String classId) {
        return classRepository.findByClassId(classId);
    }

    @Transactional
    public Classes createClass(Classes classes, String tcId) {
        if (classes.getClassId() == null || classes.getClassId().isEmpty()) {
            classes.setClassId(generateSimpleClassId());
        }
        Teacher teacher = teacherRepository.findById(tcId).orElseThrow(() -> new IllegalArgumentException("Invalid teacher ID"));
        classes.setTeacher(teacher);
        return classRepository.save(classes);
    }

    private String generateSimpleClassId() {
        return "CL" + String.valueOf(System.currentTimeMillis()).substring(5);
    }

    @Transactional
    public Classes updateTeacherForClass(String classId, String tcId) {
        Classes classes = classRepository.findByClassId(classId);
        if (classes == null) {
            throw new IllegalArgumentException("Class not found with ID: " + classId);
        }

        Teacher teacher = teacherRepository.findById(tcId).orElseThrow(() -> new IllegalArgumentException("Invalid teacher ID"));
        classes.setTeacher(teacher);
        return classRepository.save(classes);
    }

}
