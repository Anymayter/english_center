package com.toan.english_center.Controller;

import com.toan.english_center.DTO.LearningProgressRequest;
import com.toan.english_center.Entity.LearningProgress;
import com.toan.english_center.Service.LearningProgressService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/learning-progress")
public class LearningProgressController {

    @Autowired
    private LearningProgressService progressService;

//    @PostMapping("/addStudent")
//    public ResponseEntity<LearningProgress> addStudentToClass(@RequestParam String studentId, @RequestParam String classId) {
//        try {
//            LearningProgress learningProgress = learningProgressService.addStudentToClass(studentId, classId);
//            return ResponseEntity.ok(learningProgress);
//        } catch (IllegalArgumentException e) {
//            return ResponseEntity.badRequest().body(null);
//        }
//    }
@PostMapping("/addStudent")
public ResponseEntity<?> addStudentToClass(@Valid @RequestBody LearningProgressRequest request) {
        try {
            LearningProgress createdProgress = progressService.addStudentToClass(request);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdProgress);
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    //    } catch ( ex) {
    //        return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
    //    }
        }
    }
}
