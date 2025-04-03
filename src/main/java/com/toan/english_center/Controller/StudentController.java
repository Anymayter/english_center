package com.toan.english_center.Controller;

import com.toan.english_center.DTO.StudentDTO;
import com.toan.english_center.DTO.TeacherDTO;
import com.toan.english_center.Entity.Student;

import com.toan.english_center.Entity.Teacher;
import com.toan.english_center.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/all")
    public List<StudentDTO> getAllStudent() {
        return studentService.findAllSv();
    }

    @GetMapping("/get/{svId}")
    public StudentDTO getStudentById(@PathVariable String svId) {
        return studentService.findBySvId(svId);
    }

    @PutMapping("/update/{svId}")
    public StudentDTO updateStudent(@PathVariable String svId, @RequestBody StudentDTO updatedStudent) {
        return studentService.save(svId, updatedStudent);
    }

    @PostMapping("/create")
    public ResponseEntity<StudentDTO> createStudent(@RequestBody StudentDTO studentDTO) {
        StudentDTO student = studentService.createStudent(studentDTO);
        return ResponseEntity.ok(student);
    }

    @DeleteMapping("/delete/{svId}")
    public void deleteById(@PathVariable String svId) {
        studentService.deleteBySvId(svId);
    }
}
