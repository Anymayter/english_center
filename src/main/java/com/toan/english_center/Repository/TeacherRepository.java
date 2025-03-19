package com.toan.english_center.Repository;


import com.toan.english_center.Entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, String> {
    List<Teacher> findAll();
    Teacher findByTcId(String tcId);
    Teacher save(Teacher teacher);
    void deleteByTcId(String tcId);
    Optional<Teacher> findById(String tcId);
}
