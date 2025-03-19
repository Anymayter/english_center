package com.toan.english_center.Repository;


import com.toan.english_center.Entity.Classes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClassRepository extends JpaRepository<Classes, String> {
    Classes save(Classes classes);
    Classes findByClassId(String classId);
    void deleteByClassId(String classId);
    List<Classes> findAll();
    Optional<Classes> findById(String classId);
}
