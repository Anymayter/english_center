//package com.toan.english_center.Controller;
//
//
//import com.toan.english_center.Entity.TeachingContent;
//import com.toan.english_center.Service.TeachingContentService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/api/teaching_content")
//public class TeachingContentController {
//
//    @Autowired
//    private TeachingContentService teachingContentService;
//
//    // Lấy tất cả bản ghi
//    @GetMapping("/all")
//    public List<TeachingContent> findAll() {
//        return teachingContentService.findAll();
//    }
//
//    // Lấy bản ghi theo id
//    @GetMapping("/getById/{teachingContentId}")
//    public TeachingContent findById(@PathVariable String teachingContentId) {
//        return teachingContentService.findByTcId(teachingContentId);
//    }
//
//    // Tạo bản ghi mới
//    @PostMapping("/create")
//    public TeachingContent createTeachingContent(@RequestBody TeachingContent teachingContent) {
//        return teachingContentService.createTeachingContent(teachingContent);
//    }
//
//    // Cập nhật bản ghi
//    @PutMapping("/update/{teachingContentId}")
//    public TeachingContent updateTeachingContent(@PathVariable String teachingContentId, @RequestBody TeachingContent teachingContent) {
//        teachingContent.setTeachingId(teachingContentId);
//        return teachingContentService.updateTeachingContent(teachingContent);
//    }
//}
