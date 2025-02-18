package com.toan.english_center.Repository;

import com.toan.english_center.Entity.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FeedbackRepository extends JpaRepository<Feedback, Long> {
    List<Feedback> findByClassId(String classId);
    List<Feedback> findByTeacherId(String teacherId);
    List<Feedback> findByStudentId(String studentId);
}
