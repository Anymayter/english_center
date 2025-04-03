package com.toan.english_center.Controller;


import com.toan.english_center.Entity.Classes;
import com.toan.english_center.Repository.ClassRepository;
import com.toan.english_center.Service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/classes")
public class ClassController {

    @Autowired
    private ClassService classService;

    @GetMapping("/delete/{classId}")
    public void deleteByCId(@PathVariable String classId) {
        classService.deleteByCId(classId);
    }

    @GetMapping("/find/{classId}")
    public Classes findByCId(@PathVariable String classId) {
        return classService.findByCId(classId);
    }

    @PostMapping("/create")
    public Classes createClass(@RequestBody Classes classes, @RequestParam String tcId) {
        return classService.createClass(classes, tcId);
    }

    @GetMapping("/getAll")
    public List<Classes> getAllClass() {
        return classService.findAll();
    }

    @PutMapping("/updateTeacher/{classId}")
    public Classes updateTeacherForClass(@PathVariable String classId, @RequestParam String tcId) {
        return classService.updateTeacherForClass(classId, tcId);
    }


}
