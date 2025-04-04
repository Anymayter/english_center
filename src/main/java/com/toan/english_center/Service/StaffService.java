package com.toan.english_center.Service;

import com.toan.english_center.DTO.StaffDTO;
import com.toan.english_center.DTO.StudentDTO;
import com.toan.english_center.Entity.Account;
import com.toan.english_center.Entity.Staff;
import com.toan.english_center.Entity.Student;
import com.toan.english_center.Entity.Teacher;
import com.toan.english_center.Repository.AccountRepository;
import com.toan.english_center.Repository.StaffRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.List;
import java.util.Random;

@Service
public class StaffService {

    @Autowired
    private StaffRepository staffRepository;

    @Autowired
    private AccountRepository accountRepository;

    @Transactional
    public List<Staff> findAllStaff() {
        return staffRepository.findAll();
    }

    @Transactional
    public Staff findByStaffId(String staffId) {
        return staffRepository.findById(staffId).orElse(null);
    }

    @Transactional
    public void deleteByStaffId(String staffId) {
        staffRepository.deleteByStaffId(staffId);
    }

    @Transactional
    public Staff createStaff(StaffDTO staffDTO) {
        Staff staff = new Staff();

        Account account = accountRepository.findById(staffDTO.getaId())
                .orElseThrow(() -> new RuntimeException("Account not found with id: " + staffDTO.getaId()));

        // Kiểm tra loại tài khoản
        if (account.getaType() != 3) { // Giả sử aType = 1 là Staff
            throw new RuntimeException("Cannot assign account with type " + account.getaType() + " to a Staff.");
        }

        staff.setAccount(account);

        staff.setStaffId(staffDTO.getStaffId() == null ? generateSimpleTcId() : staffDTO.getStaffId());
        staff.setStaffName(staffDTO.getStaffName());
        staff.setStaffDob(staffDTO.getStaffDob());
        staff.setStaffEmail(staffDTO.getStaffEmail());
        staff.setStaffPhoneNumber(staffDTO.getStaffPhoneNumber());
        staff.setStaffGender(staffDTO.getStaffGender());
        staff.setStaffImage(staffDTO.getStaffImage());
        staff.setStaffRole(staffDTO.getStaffRole());
        staff.setStaffStatus(staffDTO.getStaffStatus());
        staff.setCreatorId(staffDTO.getCreatorId());
        staff.setJsonData(staffDTO.getJsonData());
        staff.setCreatedDate(LocalDate.now());

        return staffRepository.save(staff);
    }

    private String generateSimpleTcId() {
        long currentTime = System.currentTimeMillis() % 1000; // Lấy 3 số cuối của timestamp
        int randomNum = new Random().nextInt(90) + 10; // Số ngẫu nhiên từ 10 - 99
        return "ST" + currentTime + randomNum;
    }

    @Transactional
    public Staff save(String staffId, Staff updatedStaff) {
        Staff existingStaff = staffRepository.findByStaffId(staffId);

        if (existingStaff != null) {
            existingStaff.setStaffName(updatedStaff.getStaffName());
            existingStaff.setStaffDob(updatedStaff.getStaffDob());
            existingStaff.setStaffEmail(updatedStaff.getStaffEmail());
            existingStaff.setStaffPhoneNumber(updatedStaff.getStaffPhoneNumber());
            existingStaff.setStaffGender(updatedStaff.getStaffGender());
            existingStaff.setStaffImage(updatedStaff.getStaffImage());
            existingStaff.setStaffRole(updatedStaff.getStaffRole());
            existingStaff.setUpdatedDate(new Timestamp(System.currentTimeMillis())); // Set updated date
            existingStaff.setUpdatorId(updatedStaff.getUpdatorId());
            existingStaff.setStaffStatus(updatedStaff.getStaffStatus());
            existingStaff.setJsonData(updatedStaff.getJsonData());

            return staffRepository.save(existingStaff);
        }

        return null;
    }
}
