package com.toan.english_center.Service;

import com.toan.english_center.DTO.StudentDTO;
import com.toan.english_center.DTO.TeacherDTO;
import com.toan.english_center.Entity.Account;
import com.toan.english_center.Entity.Student;
import com.toan.english_center.Entity.Teacher;
import com.toan.english_center.Repository.AccountRepository;
import com.toan.english_center.Repository.StudentRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private AccountRepository accountRepository;

    @Transactional
    public List<Student> findAllSv() {
        return studentRepository.findAll();
    }

    @Transactional
    public Student findBySvId(String svId) {
        return studentRepository.findBySvId(svId);
    }

    @Transactional
    public Student createStudent(StudentDTO studentDTO) {
        Student student = new Student();

        Account account = accountRepository.findById(studentDTO.getaId())
                .orElseThrow(() -> new RuntimeException("Account not found with id: " + studentDTO.getaId()));

        student.setAccount(account);

        student.setSvId(studentDTO.getSvId() == null ? generateSimpleTcId() : studentDTO.getSvId());
        student.setSvName(studentDTO.getSvName());
        student.setSvDob(studentDTO.getSvDob());
        student.setSvEmail(studentDTO.getSvEmail());
        student.setSvPhoneNumber(studentDTO.getSvPhoneNumber());
        student.setSvGender(studentDTO.getSvGender());
        student.setSvImage(studentDTO.getSvImage());
        student.setSvRole(studentDTO.getSvRole());
        student.setSvStatus(studentDTO.getSvStatus());
        student.setCreatorId(studentDTO.getCreatorId());
        student.setJsonData(studentDTO.getJsonData());
        student.setCreatedDate(LocalDate.now());

        return studentRepository.save(student);
    }

    private String generateSimpleTcId() {
        // Custom logic to generate a simple tcId
        return "TC" + String.valueOf(System.currentTimeMillis()).substring(5);
    }

    @Transactional
    public void deleteBySvId(String svId) {
        studentRepository.deleteBySvId(svId);
    }

    // 5. Cập nhật thông tin sinh viên theo ID
    @Transactional
    public Student save(String svId, Student updatedStudent) {
        Optional<Student> existingStudentOpt = studentRepository.findById(svId);

        if (existingStudentOpt.isPresent()) {
            Student existingStudent = existingStudentOpt.get();

            // Update fields
            existingStudent.setSvName(updatedStudent.getSvName());
            existingStudent.setSvDob(updatedStudent.getSvDob());
            existingStudent.setSvEmail(updatedStudent.getSvEmail());
            existingStudent.setSvPhoneNumber(updatedStudent.getSvPhoneNumber());
            existingStudent.setSvGender(updatedStudent.getSvGender());
            existingStudent.setSvImage(updatedStudent.getSvImage());
            existingStudent.setSvAddress(updatedStudent.getSvAddress());
            existingStudent.setSvFbUrl(updatedStudent.getSvFbUrl());
            existingStudent.setSvRole(updatedStudent.getSvRole());
            existingStudent.setUpdatedDate(updatedStudent.getUpdatedDate());
            existingStudent.setUpdatorId(updatedStudent.getUpdatorId());
            existingStudent.setSvStatus(updatedStudent.getSvStatus());
            existingStudent.setJsonData(updatedStudent.getJsonData());

            // Save changes
            return studentRepository.save(existingStudent);
        } else {
            throw new IllegalArgumentException("Student not found with ID: " + svId);
        }
    }
}
