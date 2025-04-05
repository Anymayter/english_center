package com.toan.english_center.Repository;


import com.toan.english_center.Entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.toan.english_center.Entity.LearningProgress;

import java.util.List;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, String> {
//    Schedule findByScheduleId(String scheduleId);
//    void deleteByScheduleId(String scheduleId);
    List<Schedule> findAll();
    Schedule save(Schedule schedule);
    @Query("SELECT s FROM Schedule s WHERE s.classId IN " +
            "(SELECT lp.classes.classId FROM LearningProgress lp WHERE lp.student.svId = :svId) " +
            "ORDER BY s.classId")
    List<Schedule> findSchedulesByStudentId(@Param("svId") String svId);
    List<Schedule> findByTcIdOrderByStartTime(String tcId);

}
