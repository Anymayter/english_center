package com.toan.english_center.Controller;


import com.toan.english_center.Entity.Feedback;
import com.toan.english_center.Service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/feedbacks")
public class FeedbackController {

    @Autowired
    private FeedbackService feedbackService;

    // API: Tạo phản hồi
    @PostMapping("/create")
    public Feedback createFeedback(@RequestBody Feedback feedback) {
        return feedbackService.createFeedback(feedback);
    }

    // API: Lấy tất cả phản hồi
    @GetMapping
    public List<Feedback> getAllFeedbacks() {
        return feedbackService.getAllFeedbacks();
    }

    // API: Lấy phản hồi theo ID
    @GetMapping("/{id}")
    public Optional<Feedback> getFeedbackById(@PathVariable Long id) {
        return feedbackService.getFeedbackById(id);
    }

    // API: Lấy phản hồi theo lớp học
    @GetMapping("/class/{classId}")
    public List<Feedback> getFeedbacksByClassId(@PathVariable String classId) {
        return feedbackService.getFeedbacksByClassId(classId);
    }

    // API: Lấy phản hồi theo giáo viên
    @GetMapping("/teacher/{teacherId}")
    public List<Feedback> getFeedbacksByTeacherId(@PathVariable String teacherId) {
        return feedbackService.getFeedbacksByTeacherId(teacherId);
    }

    // API: Lấy phản hồi theo học viên
    @GetMapping("/student/{studentId}")
    public List<Feedback> getFeedbacksByStudentId(@PathVariable String studentId) {
        return feedbackService.getFeedbacksByStudentId(studentId);
    }

    // API: Cập nhật phản hồi
    @PutMapping("/{id}")
    public Feedback updateFeedback(@PathVariable Long id, @RequestBody Feedback feedbackDetails) {
        return feedbackService.updateFeedback(id, feedbackDetails);
    }

    // API: Xóa phản hồi
    @DeleteMapping("/{id}")
    public void deleteFeedback(@PathVariable Long id) {
        feedbackService.deleteFeedback(id);
    }
}
