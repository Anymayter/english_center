package com.toan.english_center.Service;


import com.toan.english_center.Entity.Teacher;
import com.toan.english_center.Repository.TeacherRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.List;

@Service
public class TeacherService {

    @Autowired
    private TeacherRepository teacherRepository;

    @Transactional
    public List<Teacher> findAllTc() {
        return teacherRepository.findAll();
    }

    @Transactional
    public Teacher findByTcId(String tcId) {
        return teacherRepository.findById(tcId).orElse(null);
    }

//    @Transactional
//    public Teacher createTc(Teacher teacher) {
//        return teacherRepository.save(teacher);
//    }

    @Transactional
    public void deleteByTcId(String tcId) {
        teacherRepository.deleteByTcId(tcId);
    }


    @Transactional
    public Teacher createTc(Teacher teacher) {
        if (teacher.getCreatedDate() == null) {
            teacher.setCreatedDate(LocalDate.now());
        }
        return teacherRepository.save(teacher);
    }

    @Transactional
    public Teacher save(String tcId, Teacher updatedTeacher) {
        Teacher existingTeacher = teacherRepository.findByTcId(tcId);

        if (existingTeacher != null) {
            existingTeacher.setTcName(updatedTeacher.getTcName());
            existingTeacher.setTcEmail(updatedTeacher.getTcEmail());
            existingTeacher.setTcDob(updatedTeacher.getTcDob());
            existingTeacher.setTcPhoneNumber(updatedTeacher.getTcPhoneNumber());
            existingTeacher.setTcGender(updatedTeacher.getTcGender());
            existingTeacher.setTcImage(updatedTeacher.getTcImage());
            existingTeacher.setTcRole(updatedTeacher.getTcRole());
            existingTeacher.setUpdatedDate(new Timestamp(System.currentTimeMillis())); // Set updated date
            existingTeacher.setUpdatorId(updatedTeacher.getUpdatorId());
            existingTeacher.setTcStatus(updatedTeacher.getTcStatus());
            existingTeacher.setJsonData(updatedTeacher.getJsonData());

            return teacherRepository.save(existingTeacher);
        }

        return null;
    }
}
