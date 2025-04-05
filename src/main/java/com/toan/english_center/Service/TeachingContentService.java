//package com.toan.english_center.Service;
//
//
//import com.toan.english_center.Entity.TeachingContent;
//import com.toan.english_center.Repository.ClassRepository;
//import com.toan.english_center.Repository.TeacherRepository;
//import com.toan.english_center.Repository.TeachingContentRepository;
//import jakarta.transaction.Transactional;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class TeachingContentService {
//
//    @Autowired
//    private TeachingContentRepository teachingContentRepository;
//
//    @Autowired
//    private ProgramRepository programRepository;
//
//    @Autowired
//    private LessonRepository lessonRepository;
//
//    @Autowired
//    private ClassRepository classRepository;
//
//    @Autowired
//    private TeacherRepository teacherRepository;
//
//    @Transactional
//    public List<TeachingContent> findAll() {
//        return teachingContentRepository.findAll();
//    }
//
//    @Transactional
//    public TeachingContent findByTcId(String tcId) {
//        return teachingContentRepository.findByTcId(tcId);
//    }
//
//    @Transactional
//    public TeachingContent createTeachingContent(TeachingContent teachingContent) {
//        return teachingContentRepository.save(teachingContent);
//    }
//
//    @Transactional
//    public TeachingContent updateTeachingContent(TeachingContent teachingContent) {
//        if (!programRepository.existsById(teachingContent.getProgram().getPId())) {
//            throw new RuntimeException("Program not found");
//        }
//        if (!lessonRepository.existsById(teachingContent.getLesson().getLId())) {
//            throw new RuntimeException("Lesson not found");
//        }
//        if (!classRepository.existsById(teachingContent.getClassEntity().getClassId())) {
//            throw new RuntimeException("Class not found");
//        }
//        if (!teacherRepository.existsById(teachingContent.getTeacher().getTcId())) {
//            throw new RuntimeException("Teacher not found");
//        }
//        Optional<TeachingContent> existingContent = teachingContentRepository.findById(teachingContent.getTeachingId());
//        if (existingContent.isPresent()) {
//            return teachingContentRepository.save(teachingContent);
//        } else {
//            throw new RuntimeException("Teaching content not found");
//        }
//    }
//
//    @Transactional
//    public void deleteByTcId(String tcId) {
//        teachingContentRepository.deleteByTcId(tcId);
//    }
//
//    @Transactional
//    public Optional<TeachingContent> findById(String tcId) {
//        return teachingContentRepository.findById(tcId);
//    }
//}
