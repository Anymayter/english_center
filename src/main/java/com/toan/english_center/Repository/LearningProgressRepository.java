package com.toan.english_center.Repository;

import com.toan.english_center.Entity.LearningProgress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LearningProgressRepository extends JpaRepository<LearningProgress, String> {
//    LearningProgress save(LearningProgress learningProgress);
    boolean existsByStudent_SvIdAndClasses_ClassId(String svId, String classId);
}
