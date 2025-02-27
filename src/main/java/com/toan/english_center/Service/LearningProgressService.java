package com.toan.english_center.Service;

import com.sun.jdi.request.DuplicateRequestException;
import com.toan.english_center.DTO.LearningProgressRequest;
import com.toan.english_center.Entity.Classes;
import com.toan.english_center.Entity.LearningProgress;
import com.toan.english_center.Entity.Student;
import com.toan.english_center.Repository.ClassRepository;
import com.toan.english_center.Repository.LearningProgressRepository;
import com.toan.english_center.Repository.StudentRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ExpressionException;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.UUID;


@Service
public class LearningProgressService {

    @Autowired
    private LearningProgressRepository learningProgressRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private ClassRepository classRepository;


    @Transactional
    public LearningProgress addStudentToClass(LearningProgressRequest request) {
        // Validate student exists
        Student student = studentRepository.findById(request.getSvId())
                .orElseThrow(() -> new ExpressionException("Student not found"));

        // Validate class exists
        Classes classes = classRepository.findById(request.getClassId())
                .orElseThrow(() -> new ExpressionException("Class not found"));

        // Check duplicate
        if (learningProgressRepository.existsByStudent_SvIdAndClasses_ClassId(
                request.getSvId(),
                request.getClassId()
        )) {
            throw new DuplicateRequestException("Student already in this class");
        }

        // Create new progress
        LearningProgress progress = new LearningProgress();
        progress.setLearningProgressId(UUID.randomUUID().toString());
        progress.setStudent(student);
        progress.setClasses(classes);
        progress.setProgress(request.getProgress());
        progress.setNote(request.getNote());

        // Set audit fields (tùy hệ thống authentication)
        progress.setCreatedDate(LocalDate.now());
        progress.setCreatorId("system"); // Thay bằng ID user thực tế

        return learningProgressRepository.save(progress);
    }
}
