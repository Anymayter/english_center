//package com.toan.english_center.Controller;
//
//
//import com.toan.english_center.Entity.Staff;
//import com.toan.english_center.Service.StaffService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/api/staff")
//public class StaffController {
//
//    @Autowired
//    private StaffService staffService;
//
//    // 1. Lấy thông tin tất cả nhân viên
//    @GetMapping("/getAll")
//    public List<Staff> getAllStaff() {
//        return staffService.findAllStaff();
//    }
//
//    // 2. Lấy thông tin nhân viên theo ID
//    @GetMapping("/get/{staffId}")
//    public Staff getStaffById(@PathVariable String staffId) {
//        return staffService.findByStaffId(staffId);
//    }
//
//    // 5. Cập nhật thông tin nhân viên theo ID
//    @PutMapping("/update/{staffId}")
//    public Staff updateStaff(@PathVariable String staffId, @RequestBody Staff updatedStaff) {
//        return staffService.save(staffId, updatedStaff);
//    }
//
//    // 3. Thêm mới nhân viên
//    @PostMapping("/create")
//    public Staff createStaff(@RequestBody Staff staff) {
//        if (staff.getStaffId() == null || staff.getStaffId().isEmpty()) {
//            staff.setStaffId(generateSimpleStaffId());
//        }
//        return staffService.createStaff(staff);
//    }
//
//    private String generateSimpleStaffId() {
//        // Custom logic to generate a simple staffId
//        return "ST" + String.valueOf(System.currentTimeMillis()).substring(5);
//    }
//
//    // 4. Xóa nhân viên theo ID
//    @DeleteMapping("/delete/{staffId}")
//    public void deleteById(@PathVariable String staffId) {
//        staffService.deleteByStaffId(staffId);
//    }
//
//}
