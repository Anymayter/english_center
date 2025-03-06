package com.toan.english_center.Repository;

import com.toan.english_center.DTO.MarkDTO;
import com.toan.english_center.Entity.Mark;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Repository
public interface MarkRepository extends JpaRepository<Mark, String> {

    List<Mark> findByClassId(String classId);
    List<Mark> findByStudentId(String studentId);
//    MarkDTO createMark(MarkDTO markDTO);
//    MarkDTO updateMark(String id, MarkDTO markDTO);
//    MarkDTO getMarkById(String id);
//    List<MarkDTO> getAllMarks();
//    void deleteMark(String id);
//    List<MarkDTO> getMarksByClassId(String classId);
//    List<MarkDTO> getMarksByStudentId(String studentId);

}
