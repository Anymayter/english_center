package com.toan.english_center.Controller;



import com.toan.english_center.DTO.ScheduleDTO;
import com.toan.english_center.DTO.ScheduleResponseDTO;
import com.toan.english_center.Entity.Schedule;
import com.toan.english_center.Service.ScheduleService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/schedule")
public class ScheduleController {

    @Autowired
    private ScheduleService scheduleService;

    @PostMapping("/create")
    public ResponseEntity<ScheduleResponseDTO> createSchedule(@Valid @RequestBody ScheduleDTO createDTO) {
        Schedule schedule = scheduleService.createSchedule(createDTO);
        ScheduleResponseDTO response = mapToResponseDTO(schedule);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    private ScheduleResponseDTO mapToResponseDTO(Schedule schedule) {
        ScheduleResponseDTO dto = new ScheduleResponseDTO();
        dto.setScheduleId(schedule.getScheduleId());
        dto.setClassId(schedule.getClassId());
        dto.setClassName(schedule.getClasses().getClassName());
        dto.setTcId(schedule.getTcId());
        dto.setTeacherName(schedule.getTeacher().getTcName());
        dto.setStartTime(schedule.getStartTime());
        dto.setEndTime(schedule.getEndTime());
        dto.setScheduleStatus(schedule.getScheduleStatus());
        dto.setCreatedDate(schedule.getCreatedDate());
        return dto;
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<ScheduleResponseDTO>> getAllSchedule() {
        List<Schedule> schedules = scheduleService.getAllSchedule();
        List<ScheduleResponseDTO> response = new ArrayList<>();
        for (Schedule schedule : schedules) {
            response.add(mapToResponseDTO(schedule));
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/student/{svId}")
    public List<Schedule> getSchedulesByStudent(@PathVariable String svId) {
        return scheduleService.getSchedulesByStudentId(svId);
    }

    @GetMapping("/teacher/{tcId}")
    public List<ScheduleDTO> getSchedulesByTeacherId(@PathVariable String tcId) {
        return scheduleService.findSchedulesByTeacherId(tcId);
    }

}
