package com.toan.english_center.Repository;


import com.toan.english_center.Entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, String> {
//    Schedule findByScheduleId(String scheduleId);
//    void deleteByScheduleId(String scheduleId);
    List<Schedule> findAll();
    Schedule save(Schedule schedule);
}
