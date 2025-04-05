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
@CrossOrigin
@RequestMapping("/api/teachers")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @GetMapping("/all")
    public List<TeacherDTO> getAllTeacher() {
        return teacherService.findAllTc();
    }

    @PutMapping("/update/{tcId}")
    public ResponseEntity<TeacherDTO> updateTeacher(@PathVariable String tcId, @RequestBody TeacherDTO updatedTeacherDTO) {
        TeacherDTO updatedTeacher = teacherService.save(tcId, updatedTeacherDTO);
        return ResponseEntity.ok(updatedTeacher);
    }

    @PostMapping("/create")
    public ResponseEntity<TeacherDTO> createTeacher(@RequestBody TeacherDTO teacherDTO) {
        TeacherDTO teacher = teacherService.createTeacher(teacherDTO);
        return ResponseEntity.ok(teacher);
    }

    @DeleteMapping("/delete/{tcId}")
    public void deleteById(@PathVariable String tcId) {
        teacherService.deleteByTcId(tcId);
    }

    @GetMapping("/get/{tcId}")
    public ResponseEntity<TeacherDTO> getTeacherById(@PathVariable String tcId) {
        TeacherDTO teacher = teacherService.findByTcId(tcId);
        if (teacher == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.ok(teacher);
    }

}
