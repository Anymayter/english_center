package com.toan.english_center.Service;

import com.toan.english_center.Entity.Feedback;
import com.toan.english_center.Repository.FeedbackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FeedbackService {
    @Autowired
    private FeedbackRepository feedbackRepository;

    // Tạo phản hồi
    public Feedback createFeedback(Feedback feedback) {
        feedback.setCreatedDate(java.time.LocalDateTime.now().toString());
        return feedbackRepository.save(feedback);
    }

    // Lấy tất cả phản hồi
    public List<Feedback> getAllFeedbacks() {
        return feedbackRepository.findAll();
    }

    // Lấy phản hồi theo ID
    public Optional<Feedback> getFeedbackById(Long feedbackId) {
        return feedbackRepository.findById(feedbackId);
    }

    // Lấy phản hồi theo lớp học
    public List<Feedback> getFeedbacksByClassId(String classId) {
        return feedbackRepository.findByClassId(classId);
    }

    // Lấy phản hồi theo giáo viên
    public List<Feedback> getFeedbacksByTeacherId(String teacherId) {
        return feedbackRepository.findByTeacherId(teacherId);
    }

    // Lấy phản hồi theo học viên
    public List<Feedback> getFeedbacksByStudentId(String studentId) {
        return feedbackRepository.findByStudentId(studentId);
    }

    // Cập nhật phản hồi
    public Feedback updateFeedback(Long feedbackId, Feedback feedbackDetails) {
        Feedback feedback = feedbackRepository.findById(feedbackId).orElseThrow(() -> new RuntimeException("Feedback not found"));
        feedback.setContent(feedbackDetails.getContent());
        feedback.setUpdatedDate(java.time.LocalDateTime.now().toString());
        return feedbackRepository.save(feedback);
    }

    // Xóa phản hồi
    public void deleteFeedback(Long feedbackId) {
        feedbackRepository.deleteById(feedbackId);
    }
}
