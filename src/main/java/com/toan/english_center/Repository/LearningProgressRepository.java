package com.toan.english_center.Repository;

import com.toan.english_center.Entity.LearningProgress;
import com.toan.english_center.Entity.Student;
import io.lettuce.core.dynamic.annotation.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LearningProgressRepository extends JpaRepository<LearningProgress, String> {
//    LearningProgress save(LearningProgress learningProgress);
    boolean existsByStudent_SvIdAndClasses_ClassId(String svId, String classId);

    @Query("SELECT lp.student FROM LearningProgress lp WHERE lp.classes.classId = :classId")
    List<Student> findAllStudentsInClass(@Param("classId") String classId);
}
