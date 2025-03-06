package com.toan.english_center.Service.Impl;

import com.toan.english_center.DTO.ProgramDTO;
import com.toan.english_center.Entity.Program;
import com.toan.english_center.Repository.ProgramRepository;
import com.toan.english_center.Service.ProgramService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProgramServiceImpl implements ProgramService {

    @Autowired
    private ProgramRepository programRepository;

    @Override
    public ProgramDTO createProgram(ProgramDTO programDTO) {
        Program program = new Program();
        // Set fields from DTO to Entity
        program.setId(programDTO.getId());
        program.setName(programDTO.getName());
        program.setDescription(programDTO.getDescription());
        program.setCreatedDate(programDTO.getCreatedDate());
        program.setUpdatedDate(programDTO.getUpdatedDate());
        program.setCreatorId(programDTO.getCreatorId());
        program.setUpdatorId(programDTO.getUpdatorId());
        program.setProgramStatus(programDTO.getProgramStatus());
        program.setJsonData(programDTO.getJsonData());
        programRepository.save(program);
        return programDTO;
    }

    @Override
    public ProgramDTO getProgramById(String id) {
        Program program = programRepository.findById(id).orElseThrow(() -> new RuntimeException("Program not found"));
        return convertToDTO(program);
    }

    @Override
    public List<ProgramDTO> getAllPrograms() {
        return programRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    @Override
    public ProgramDTO updateProgram(String id, ProgramDTO programDTO) {
        Program program = programRepository.findById(id).orElseThrow(() -> new RuntimeException("Program not found"));
        // Update fields from DTO to Entity
        program.setName(programDTO.getName());
        program.setDescription(programDTO.getDescription());
        program.setUpdatedDate(programDTO.getUpdatedDate());
        program.setUpdatorId(programDTO.getUpdatorId());
        program.setProgramStatus(programDTO.getProgramStatus());
        program.setJsonData(programDTO.getJsonData());
        programRepository.save(program);
        return programDTO;
    }

    @Override
    public void deleteProgram(String id) {
        programRepository.deleteById(id);
    }

    private ProgramDTO convertToDTO(Program program) {
        ProgramDTO programDTO = new ProgramDTO();
        // Set fields from Entity to DTO
        programDTO.setId(program.getId());
        programDTO.setName(program.getName());
        programDTO.setDescription(program.getDescription());
        programDTO.setCreatedDate(program.getCreatedDate());
        programDTO.setUpdatedDate(program.getUpdatedDate());
        programDTO.setCreatorId(program.getCreatorId());
        programDTO.setUpdatorId(program.getUpdatorId());
        programDTO.setProgramStatus(program.getProgramStatus());
        programDTO.setJsonData(program.getJsonData());
        return programDTO;
    }
}