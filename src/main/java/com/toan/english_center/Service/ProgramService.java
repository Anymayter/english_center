package com.toan.english_center.Service;

import com.toan.english_center.DTO.ProgramDTO;
import java.util.List;

public interface ProgramService {
    ProgramDTO createProgram(ProgramDTO programDTO);
    ProgramDTO getProgramById(String id);
    List<ProgramDTO> getAllPrograms();
    ProgramDTO updateProgram(String id, ProgramDTO programDTO);
    void deleteProgram(String id);
}