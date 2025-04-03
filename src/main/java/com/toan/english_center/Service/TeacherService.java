package com.toan.english_center.Service;


import com.toan.english_center.DTO.TeacherDTO;
import com.toan.english_center.Entity.Account;
import com.toan.english_center.Entity.Teacher;
import com.toan.english_center.Repository.AccountRepository;
import com.toan.english_center.Repository.TeacherRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class TeacherService {

    @Autowired
    private TeacherRepository teacherRepository;

    @Autowired
    private AccountRepository accountRepository;

    @Transactional
    public List<TeacherDTO> findAllTc() {
        return teacherRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Transactional
    public TeacherDTO findByTcId(String tcId) {
        Teacher teacher = teacherRepository.findById(tcId).orElse(null);
        return convertToDTO(teacher);
    }

    @Transactional
    public void deleteByTcId(String tcId) {
        teacherRepository.deleteByTcId(tcId);
    }

    @Transactional
    public TeacherDTO createTeacher(TeacherDTO teacherDTO) {
        Teacher teacher = new Teacher();

        Account account = accountRepository.findById(teacherDTO.getaId())
                .orElseThrow(() -> new RuntimeException("Account not found with id: " + teacherDTO.getaId()));

        if (account.getaType() != 1) {
            throw new RuntimeException("Cannot assign account with type " + account.getaType() + " to a Teacher.");
        }

        teacher.setAccount(account);
        BeanUtils.copyProperties(teacherDTO, teacher);
        teacher.setTcId(teacherDTO.getTcId() == null ? generateSimpleTcId() : teacherDTO.getTcId());
        teacher.setCreatedDate(LocalDate.now());

        teacher = teacherRepository.save(teacher);
        return convertToDTO(teacher);
    }

    private String generateSimpleTcId() {
        long currentTime = System.currentTimeMillis() % 1000;
        int randomNum = new Random().nextInt(90) + 10;
        return "TC" + currentTime + randomNum;
    }

    @Transactional
    public TeacherDTO save(String tcId, TeacherDTO updatedTeacherDTO) {
        Optional<Teacher> existingTeacherOpt = teacherRepository.findById(tcId);

        if (existingTeacherOpt.isPresent()) {
            Teacher existingTeacher = existingTeacherOpt.get();
            BeanUtils.copyProperties(updatedTeacherDTO, existingTeacher);
            existingTeacher.setUpdatedDate(new Timestamp(System.currentTimeMillis()));

            existingTeacher = teacherRepository.save(existingTeacher);
            return convertToDTO(existingTeacher);
        } else {
            throw new IllegalArgumentException("Teacher not found with ID: " + tcId);
        }
    }

    private TeacherDTO convertToDTO(Teacher teacher) {
        TeacherDTO teacherDTO = new TeacherDTO();
        BeanUtils.copyProperties(teacher, teacherDTO);
        teacherDTO.setaId(teacher.getAccount().getaId());
        return teacherDTO;
    }
}
