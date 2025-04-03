package com.toan.english_center.Controller;


import com.toan.english_center.DTO.StaffDTO;
import com.toan.english_center.DTO.StudentDTO;
import com.toan.english_center.Entity.Staff;
import com.toan.english_center.Entity.Student;
import com.toan.english_center.Service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/staff")
public class StaffController {

    @Autowired
    private StaffService staffService;

    // 1. Lấy thông tin tất cả nhân viên
    @GetMapping("/getAll")
    public List<Staff> getAllStaff() {
        return staffService.findAllStaff();
    }

    // 2. Lấy thông tin nhân viên theo ID
    @GetMapping("/get/{staffId}")
    public Staff getStaffById(@PathVariable String staffId) {
        return staffService.findByStaffId(staffId);
    }

    // 5. Cập nhật thông tin nhân viên theo ID
    @PutMapping("/update/{staffId}")
    public Staff updateStaff(@PathVariable String staffId, @RequestBody Staff updatedStaff) {
        return staffService.save(staffId, updatedStaff);
    }


    @PostMapping("/create")
    public ResponseEntity<Staff> createStaff(@RequestBody StaffDTO staffDTO) {
        Staff staff = staffService.createStaff(staffDTO);
        return ResponseEntity.ok(staff);
    }

    private String generateSimpleTcId() {
        // Custom logic to generate a simple tcId
        return "ST" + String.valueOf(System.currentTimeMillis()).substring(5);
    }

    // 4. Xóa nhân viên theo ID
    @DeleteMapping("/delete/{staffId}")
    public void deleteById(@PathVariable String staffId) {
        staffService.deleteByStaffId(staffId);
    }

}
