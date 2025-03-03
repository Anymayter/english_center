package com.toan.english_center.Controller;

import com.toan.english_center.DTO.LearningProgressRequest;
import com.toan.english_center.Entity.LearningProgress;
import com.toan.english_center.Entity.Student;
import com.toan.english_center.Service.LearningProgressService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/learning-progress")
public class LearningProgressController {

    @Autowired
    private LearningProgressService progressService;

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

    @GetMapping("/allStudentsInClass/{classId}")
    public ResponseEntity<List<Student>> getAllStudentsInClass(@PathVariable String classId) {
        List<Student> students = progressService.findAllStudentsInClass(classId);
        return ResponseEntity.ok(students);
    }

}
