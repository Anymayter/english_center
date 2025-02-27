package com.toan.english_center.Controller;

import com.toan.english_center.Entity.Student;

import com.toan.english_center.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    // 1. Lấy thông tin tất cả sinh viên
    @GetMapping("/all")
    public List<Student> getAllStudent() {
        return studentService.findAllSv();
    }

    // 2. Lấy thông tin sinh viên theo ID
    @GetMapping("/get/{svId}")
    public Student getStudentById(String svId) {
        return studentService.findBySvId(svId);
    }

    // 5. Cập nhật thông tin sinh viên theo ID
    @PutMapping("/update/{svId}")
    public Student updateStudent(@PathVariable String svId, @RequestBody Student updatedStudent) {
        return studentService.save(svId, updatedStudent);
    }

    // 3. Thêm mới sinh viên
    @PostMapping("/create")
    public Student createStudent(@RequestBody Student student) {
        if (student.getSvId() == null || student.getSvId().isEmpty()) {
            student.setSvId(generateSimpleSvId());
        }
        return studentService.createSv(student);
    }
    private String generateSimpleSvId() {
        // Custom logic to generate a simple svId
        return "SV" + String.valueOf(System.currentTimeMillis()).substring(0, 5);
    }

    // 4. Xóa sinh viên theo ID
    @DeleteMapping("/delete/{svId}")
    public void deleteById(@PathVariable String svId) {
        studentService.deleteBySvId(svId);
    }
}
