package com.toan.english_center.Service;

import com.toan.english_center.DTO.ScheduleDTO;
import com.toan.english_center.Entity.*;
import com.toan.english_center.Exception.ResourceNotFoundException;
import com.toan.english_center.Repository.ClassRepository;
import com.toan.english_center.Repository.ScheduleRepository;
import com.toan.english_center.Repository.TeacherRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ScheduleService {

    @Autowired
    private ScheduleRepository scheduleRepository;

    @Autowired
    private ClassRepository classRepository;

    @Autowired
    private TeacherRepository teacherRepository;

    @Transactional
    public Schedule createSchedule(ScheduleDTO dto) {
        // Kiểm tra lớp học tồn tại
        Classes classObj = classRepository.findById(dto.getClassId())
                .orElseThrow(() -> new ResourceNotFoundException("Không tìm thấy lớp với ID: " + dto.getClassId()));

        // Kiểm tra giáo viên tồn tại
        Teacher teacher = teacherRepository.findById(dto.getTcId())
                .orElseThrow(() -> new ResourceNotFoundException("Không tìm thấy giáo viên với ID: " + dto.getTcId()));

        // Tạo mã lịch trình mới (ví dụ: SCH-12345)
        String scheduleId = generateScheduleId();

        // Tạo đối tượng Schedule mới
        Schedule schedule = new Schedule();
        schedule.setScheduleId(scheduleId);
        schedule.setClassId(dto.getClassId());
        schedule.setTcId(dto.getTcId());
        schedule.setClasses(classObj); // Set the Classes object
        schedule.setTeacher(teacher); // Set the Teacher object
        schedule.setStartTime(dto.getStartTime());
        schedule.setEndTime(dto.getEndTime());
        schedule.setCreatedDate(new Date());
        schedule.setCreatorId(dto.getCreatorId());
        schedule.setScheduleStatus(1);
        schedule.setJsonData(dto.getJsonData());

        // Lưu và trả về kết quả
        return scheduleRepository.save(schedule);
    }

    // Phương thức tạo mã lịch trình mới
    private String generateScheduleId() {
        return "SCH-" + System.currentTimeMillis() % 100000;
    }

    @Transactional
    public List<Schedule> getAllSchedule() {
        return scheduleRepository.findAll();
    }

    @Transactional
    public List<Schedule> getSchedulesByStudentId(String svId) {
        return scheduleRepository.findSchedulesByStudentId(svId);
    }

    @Transactional
    public List<ScheduleDTO> findSchedulesByTeacherId(String tcId) {
        List<Schedule> schedules = scheduleRepository.findByTcIdOrderByStartTime(tcId);
        return schedules.stream().map(schedule -> {
            ScheduleDTO dto = new ScheduleDTO();
            dto.setScheduleId(schedule.getScheduleId());
//            dto.setTcId(schedule.getTcId());
            dto.setClassId(schedule.getClassId());
            dto.setClassName(schedule.getClasses().getClassName());
            dto.setClassDescription(schedule.getClasses().getClassDescription());
            dto.setStartTime(schedule.getStartTime());
            dto.setEndTime(schedule.getEndTime());
            return dto;
        }).collect(Collectors.toList());
    }


}
