package com.toan.english_center.Service;

import com.toan.english_center.DTO.TeachingContentDTO;
import java.util.List;

public interface TeachingContentService {
    TeachingContentDTO createTeachingContent(TeachingContentDTO teachingContentDTO);
    TeachingContentDTO getTeachingContentById(String id);
    List<TeachingContentDTO> getAllTeachingContents();
    TeachingContentDTO updateTeachingContent(String id, TeachingContentDTO teachingContentDTO);
    void deleteTeachingContent(String id);
}