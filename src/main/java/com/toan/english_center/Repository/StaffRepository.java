package com.toan.english_center.Repository;


import com.toan.english_center.Entity.Staff;
import com.toan.english_center.Entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StaffRepository extends JpaRepository<Staff, String> {
    Staff findByStaffId(String staffId);
    Staff findByStaffName(String staffName);
    List<Staff> findAll();
    Staff save(Staff staff);
    void deleteByStaffId(String staffId);
}
