package com.toan.english_center.Service;

import com.toan.english_center.DTO.StudentDTO;
import com.toan.english_center.Entity.Account;
import com.toan.english_center.Entity.Student;
import com.toan.english_center.Repository.AccountRepository;
import com.toan.english_center.Repository.StudentRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private AccountRepository accountRepository;

    @Transactional
    public List<StudentDTO> findAllSv() {
        return studentRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Transactional
    public StudentDTO findBySvId(String svId) {
        Student student = studentRepository.findBySvId(svId);
        return convertToDTO(student);
    }

    @Transactional
    public StudentDTO createStudent(StudentDTO studentDTO) {
        Student student = new Student();

        Account account = accountRepository.findById(studentDTO.getaId())
                .orElseThrow(() -> new RuntimeException("Account not found with id: " + studentDTO.getaId()));

        if (account.getaType() != 2) {
            throw new RuntimeException("Cannot assign account with type " + account.getaType() + " to a Student.");
        }

        student.setAccount(account);
        BeanUtils.copyProperties(studentDTO, student);
        student.setSvId(studentDTO.getSvId() == null ? generateSimpleTcId() : studentDTO.getSvId());
        student.setCreatedDate(LocalDate.now());

        student = studentRepository.save(student);
        return convertToDTO(student);
    }

    private String generateSimpleTcId() {
        long currentTime = System.currentTimeMillis() % 1000;
        int randomNum = new Random().nextInt(90) + 10;
        return "ST" + currentTime + randomNum;
    }

    @Transactional
    public void deleteBySvId(String svId) {
        studentRepository.deleteBySvId(svId);
    }

    @Transactional
    public StudentDTO save(String svId, StudentDTO updatedStudentDTO) {
        Optional<Student> existingStudentOpt = studentRepository.findById(svId);

        if (existingStudentOpt.isPresent()) {
            Student existingStudent = existingStudentOpt.get();
            BeanUtils.copyProperties(updatedStudentDTO, existingStudent);
            existingStudent.setUpdatedDate(new Timestamp(System.currentTimeMillis()));

            existingStudent = studentRepository.save(existingStudent);
            return convertToDTO(existingStudent);
        } else {
            throw new IllegalArgumentException("Student not found with ID: " + svId);
        }
    }

    private StudentDTO convertToDTO(Student student) {
        StudentDTO studentDTO = new StudentDTO();
        BeanUtils.copyProperties(student, studentDTO);
        studentDTO.setaId(student.getAccount().getaId());
        return studentDTO;
    }
}
