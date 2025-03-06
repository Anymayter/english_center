package com.toan.english_center.Controller;


import com.toan.english_center.DTO.MarkDTO;
import com.toan.english_center.Service.MarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/marks")
public class MarkController {

    @Autowired
    private MarkService markService;

    @PostMapping("/create")
    public ResponseEntity<MarkDTO> createMark(@RequestBody MarkDTO markDTO) {
        return ResponseEntity.ok(markService.createMark(markDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<MarkDTO> updateMark(@PathVariable String id,
                                              @RequestBody MarkDTO markDTO) {
        return ResponseEntity.ok(markService.updateMark(id, markDTO));
    }

    @GetMapping("/all")
    public ResponseEntity<List<MarkDTO>> getAllMarks() {
        return ResponseEntity.ok(markService.getAllMarks());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMark(@PathVariable String id) {
        markService.deleteMark(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/class/{classId}")
    public ResponseEntity<List<MarkDTO>> getMarksByClassId(@PathVariable String classId) {
        return ResponseEntity.ok(markService.getMarksByClassId(classId));
    }

    @GetMapping("/student/{studentId}")
    public ResponseEntity<List<MarkDTO>> getMarksByStudentId(@PathVariable String studentId) {
        return ResponseEntity.ok(markService.getMarksByStudentId(studentId));
    }
}
