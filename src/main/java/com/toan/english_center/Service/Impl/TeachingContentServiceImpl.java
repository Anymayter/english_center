package com.toan.english_center.Service.Impl;

import com.toan.english_center.DTO.TeachingContentDTO;
import com.toan.english_center.Entity.TeachingContent;
import com.toan.english_center.Exception.TeachingContentNotFoundException;
import com.toan.english_center.Repository.TeachingContentRepository;
import com.toan.english_center.Service.TeachingContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TeachingContentServiceImpl implements TeachingContentService {

    @Autowired
    private TeachingContentRepository teachingContentRepository;

    @Override
    public TeachingContentDTO createTeachingContent(TeachingContentDTO teachingContentDTO) {
        TeachingContent teachingContent = convertToEntity(teachingContentDTO);
        teachingContentRepository.save(teachingContent);
        return teachingContentDTO;
    }

    @Override
    public TeachingContentDTO getTeachingContentById(String id) {
        TeachingContent teachingContent = teachingContentRepository.findById(id)
                .orElseThrow(() -> new TeachingContentNotFoundException("Teaching Content not found"));
        return convertToDTO(teachingContent);
    }

    @Override
    public List<TeachingContentDTO> getAllTeachingContents() {
        return teachingContentRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    @Override
    public TeachingContentDTO updateTeachingContent(String id, TeachingContentDTO teachingContentDTO) {
        TeachingContent teachingContent = teachingContentRepository.findById(id)
                .orElseThrow(() -> new TeachingContentNotFoundException("Teaching Content not found"));
        // Update fields from DTO to Entity
        teachingContent.setTitle(teachingContentDTO.getTitle());
        teachingContent.setContent(teachingContentDTO.getContent());
        teachingContent.setFilepath(teachingContentDTO.getFilepath());
        teachingContent.setUpdatedDate(teachingContentDTO.getUpdatedDate());
        teachingContent.setUpdatorId(teachingContentDTO.getUpdatorId());
        teachingContent.setTeachingContentStatus(teachingContentDTO.getTeachingContentStatus());
        teachingContent.setJsonData(teachingContentDTO.getJsonData());
        teachingContentRepository.save(teachingContent);
        return teachingContentDTO;
    }

    @Override
    public void deleteTeachingContent(String id) {
        teachingContentRepository.deleteById(id);
    }

    private TeachingContentDTO convertToDTO(TeachingContent teachingContent) {
        TeachingContentDTO teachingContentDTO = new TeachingContentDTO();
        // Set fields from Entity to DTO
        teachingContentDTO.setTeachingId(teachingContent.getTeachingId());
        teachingContentDTO.setPId(teachingContent.getPId());
        teachingContentDTO.setLId(teachingContent.getLId());
        teachingContentDTO.setClassId(teachingContent.getClassId());
        teachingContentDTO.setTeacherId(teachingContent.getTeacherId());
        teachingContentDTO.setTitle(teachingContent.getTitle());
        teachingContentDTO.setContent(teachingContent.getContent());
        teachingContentDTO.setFilepath(teachingContent.getFilepath());
        teachingContentDTO.setCreatedDate(teachingContent.getCreatedDate());
        teachingContentDTO.setUpdatedDate(teachingContent.getUpdatedDate());
        teachingContentDTO.setCreatorId(teachingContent.getCreatorId());
        teachingContentDTO.setUpdatorId(teachingContent.getUpdatorId());
        teachingContentDTO.setTeachingContentStatus(teachingContent.getTeachingContentStatus());
        teachingContentDTO.setJsonData(teachingContent.getJsonData());
        return teachingContentDTO;
    }

    private TeachingContent convertToEntity(TeachingContentDTO teachingContentDTO) {
        TeachingContent teachingContent = new TeachingContent();
        // Set fields from DTO to Entity
        teachingContent.setTeachingId(teachingContentDTO.getTeachingId());
        teachingContent.setPId(teachingContentDTO.getPId());
        teachingContent.setLId(teachingContentDTO.getLId());
        teachingContent.setClassId(teachingContentDTO.getClassId());
        teachingContent.setTeacherId(teachingContentDTO.getTeacherId());
        teachingContent.setTitle(teachingContentDTO.getTitle());
        teachingContent.setContent(teachingContentDTO.getContent());
        teachingContent.setFilepath(teachingContentDTO.getFilepath());
        teachingContent.setCreatedDate(teachingContentDTO.getCreatedDate());
        teachingContent.setUpdatedDate(teachingContentDTO.getUpdatedDate());
        teachingContent.setCreatorId(teachingContentDTO.getCreatorId());
        teachingContent.setUpdatorId(teachingContentDTO.getUpdatorId());
        teachingContent.setTeachingContentStatus(teachingContentDTO.getTeachingContentStatus());
        teachingContent.setJsonData(teachingContentDTO.getJsonData());
        return teachingContent;
    }
}