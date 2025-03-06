package com.toan.english_center.Service;


import com.toan.english_center.DTO.MarkDTO;
import com.toan.english_center.Entity.Mark;
import com.toan.english_center.Repository.MarkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class MarkService {

    @Autowired
    private MarkRepository markRepository;

    private MarkDTO convertToDTO(Mark mark) {
        MarkDTO dto = new MarkDTO();
        dto.setMarkId(mark.getMarkId());
        dto.setClassId(mark.getClassId());
        dto.setStudentId(mark.getStudentId());
        dto.setMarkDate(mark.getMarkDate());
        dto.setContent(mark.getContent());
        dto.setPoint(mark.getPoint());
        dto.setCreatedDate(mark.getCreatedDate());
        dto.setUpdatedDate(mark.getUpdatedDate());
        dto.setCreatorId(mark.getCreatorId());
        dto.setUpdatorId(mark.getUpdatorId());
        dto.setStatus(mark.getStatus());
        dto.setJsonData(mark.getJsonData());
        return dto;
    }

    private Mark convertToEntity(MarkDTO dto) {
        Mark mark = new Mark();
        mark.setMarkId(dto.getMarkId());
        mark.setClassId(dto.getClassId());
        mark.setStudentId(dto.getStudentId());
        mark.setMarkDate(dto.getMarkDate());
        mark.setContent(dto.getContent());
        mark.setPoint(dto.getPoint());
        mark.setCreatedDate(dto.getCreatedDate());
        mark.setUpdatedDate(dto.getUpdatedDate());
        mark.setCreatorId(dto.getCreatorId());
        mark.setUpdatorId(dto.getUpdatorId());
        mark.setStatus(dto.getStatus());
        mark.setJsonData(dto.getJsonData());
        return mark;
    }

    public MarkDTO createMark(MarkDTO markDTO) {
        if (markDTO.getMarkId() == null || markDTO.getMarkId().isEmpty()) {
            markDTO.setMarkId(UUID.randomUUID().toString());
        }
        Mark mark = convertToEntity(markDTO);
        Mark savedMark = markRepository.save(mark);
        return convertToDTO(savedMark);
    }

    public MarkDTO updateMark(String id, MarkDTO markDTO) {
        Mark mark = markRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Mark not found"));

        mark.setClassId(markDTO.getClassId());
        mark.setStudentId(markDTO.getStudentId());
        mark.setMarkDate(markDTO.getMarkDate());
        mark.setContent(markDTO.getContent());
        mark.setPoint(markDTO.getPoint());
        mark.setStatus(markDTO.getStatus());
        mark.setJsonData(markDTO.getJsonData());
        mark.setUpdatedDate(new java.util.Date());
        mark.setUpdatorId(markDTO.getUpdatorId());

        Mark updatedMark = markRepository.save(mark);
        return convertToDTO(updatedMark);
    }

    public MarkDTO getMarkById(String id) {
        Mark mark = markRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Mark not found"));
        return convertToDTO(mark);
    }

    public List<MarkDTO> getAllMarks() {
        List<Mark> marks = markRepository.findAll();
        List<MarkDTO> markDTOs = new ArrayList<>();
        for (Mark mark : marks) {
            markDTOs.add(convertToDTO(mark));
        }
        return markDTOs;
    }

    public void deleteMark(String id) {
        Mark mark = markRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Mark not found"));
        markRepository.delete(mark);
    }

    public List<MarkDTO> getMarksByClassId(String classId) {
        List<Mark> marks = markRepository.findByClassId(classId);
        List<MarkDTO> markDTOs = new ArrayList<>();
        for (Mark mark : marks) {
            markDTOs.add(convertToDTO(mark));
        }
        return markDTOs;
    }

    public List<MarkDTO> getMarksByStudentId(String studentId) {
        List<Mark> marks = markRepository.findByStudentId(studentId);
        List<MarkDTO> markDTOs = new ArrayList<>();
        for (Mark mark : marks) {
            markDTOs.add(convertToDTO(mark));
        }
        return markDTOs;
    }

}
