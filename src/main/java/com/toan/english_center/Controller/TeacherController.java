package com.toan.english_center.Controller;


import com.toan.english_center.DTO.TeacherDTO;
import com.toan.english_center.Entity.Teacher;
import com.toan.english_center.Service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/teachers")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    // 1. Lấy thông tin tất cả giáo viên
    @GetMapping("/all")
    public List<Teacher> getAllTeacher() {
        return teacherService.findAllTc();
    }

//    // 2. Lấy thông tin giáo viên theo ID
//    @GetMapping("/get/{tcId}")
//    public Teacher getTeacherById(@PathVariable String tcId) {
//        return teacherService.findByTcId(tcId);
//    }

    // 5. Cập nhật thông tin giáo viên theo ID
    @PutMapping("/update/{tcId}")
    public Teacher updateTeacher(@PathVariable String tcId, @RequestBody Teacher updatedTeacher) {
        return teacherService.save(tcId, updatedTeacher);
    }

//    // 3. Thêm mới giáo viên
//    @PostMapping("/create")
//    public Teacher createTeacher(@RequestBody Teacher teacher) {
//        if (teacher.getTcId() == null || teacher.getTcId().isEmpty()) {
//            teacher.setTcId(generateSimpleTcId());
//        }
//        return teacherService.createTc(teacher);
//    }

    @PostMapping("/create")
    public ResponseEntity<Teacher> createTeacher(@RequestBody TeacherDTO teacherDTO) {
        Teacher teacher = teacherService.createTeacher(teacherDTO);
        return ResponseEntity.ok(teacher);
    }

    private String generateSimpleTcId() {
        // Custom logic to generate a simple tcId
        return "TC" + String.valueOf(System.currentTimeMillis()).substring(5);
    }

    // 4. Xóa giáo viên theo ID
    @DeleteMapping("/delete/{tcId}")
    public void deleteById(@PathVariable String tcId) {
        teacherService.deleteByTcId(tcId);
    }

    @GetMapping("/get/{tcId}")
    public ResponseEntity<Teacher> getTeacherById(@PathVariable String tcId) {
        Teacher teacher = teacherService.findByTcId(tcId);
        if (teacher == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null); // Trả về 404 nếu không tìm thấy
        }
        return ResponseEntity.ok(teacher); // Trả về 200 nếu tìm thấy
    }

}
