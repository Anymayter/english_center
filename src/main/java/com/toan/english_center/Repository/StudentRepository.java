package com.toan.english_center.Repository;

import com.toan.english_center.DTO.StudentDTO;
import com.toan.english_center.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, String> {
    List<Student> findAll();
    Student findBySvId(String svId);
    Student save(Student student);
    void deleteBySvId(String svId);
    Optional<Student> findById(String svId);
}
