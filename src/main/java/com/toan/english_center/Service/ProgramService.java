//package com.toan.english_center.Service;
//
//
//import com.toan.english_center.Entity.Program;
//import jakarta.transaction.Transactional;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class ProgramService {
//
//    @Autowired
//    private ProgramRepository programRepository;
//
//
//    @Transactional
//    public Program save(Program program) {
//        return programRepository.save(program);
//    }
//
//    @Transactional
//    public Program findByPId(String pId) {
//        return programRepository.findByPId(pId);
//    }
//
//    @Transactional
//    public void deleteByPId(String pId) {
//        programRepository.deleteByPId(pId);
//    }
//
//    @Transactional
//    public List<Program> findByPName(String pName) {
//        return programRepository.findByPName(pName);
//    }
//
//    @Transactional
//    public List<Program> findAll() {
//        return programRepository.findAll();
//    }
//
//}
