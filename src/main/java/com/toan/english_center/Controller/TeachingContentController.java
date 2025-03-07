package com.toan.english_center.Controller;

import com.toan.english_center.DTO.TeachingContentDTO;
import com.toan.english_center.Service.TeachingContentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/teaching-contents")
public class TeachingContentController {

    private final TeachingContentService teachingContentService;

    public TeachingContentController(TeachingContentService teachingContentService) {
        this.teachingContentService = teachingContentService;
    }

    @PostMapping
    public ResponseEntity<TeachingContentDTO> createTeachingContent(@RequestBody TeachingContentDTO teachingContentDTO) {
        return new ResponseEntity<>(teachingContentService.createTeachingContent(teachingContentDTO), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TeachingContentDTO> getTeachingContentById(@PathVariable String id) {
        return ResponseEntity.ok(teachingContentService.getTeachingContentById(id));
    }

    @GetMapping
    public ResponseEntity<List<TeachingContentDTO>> getAllTeachingContents() {
        return ResponseEntity.ok(teachingContentService.getAllTeachingContents());
    }

    @PutMapping("/{id}")
    public ResponseEntity<TeachingContentDTO> updateTeachingContent(@PathVariable String id, @RequestBody TeachingContentDTO teachingContentDTO) {
        return ResponseEntity.ok(teachingContentService.updateTeachingContent(id, teachingContentDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTeachingContent(@PathVariable String id) {
        teachingContentService.deleteTeachingContent(id);
        return ResponseEntity.noContent().build();
    }
}