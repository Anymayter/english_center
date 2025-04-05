package com.toan.english_center.DTO;

import javax.naming.ldap.PagedResultsControl;
import java.sql.Timestamp;
import java.time.LocalDate;

public class StudentDTO {

    private String svId;
    private String aId;
    private String svName;
    private String svEmail;
    private String svDob;
    private String svPhoneNumber;
    private String svGender;
    private String svImage;
    private String svAddress;
    private String svFbUrl;
    private String svRole;
    private LocalDate createdDate;
    private LocalDate updatedDate;
    private String creatorId; // creator_id
    private String updatorId; // updator_id
    private Integer svStatus; // sv_status
    private String jsonData; // jsondata

    // Getter and setter

    public String getSvId() {
        return svId;
    }

    public void setSvId(String svId) {
        this.svId = svId;
    }

    public String getaId() {
        return aId;
    }

    public void setaId(String aId) {
        this.aId = aId;
    }

    public String getSvName() {
        return svName;
    }

    public void setSvName(String svName) {
        this.svName = svName;
    }

    public String getSvEmail() {
        return svEmail;
    }

    public void setSvEmail(String svEmail) {
        this.svEmail = svEmail;
    }

    public String getSvDob() {
        return svDob;
    }

    public void setSvDob(String svDob) {
        this.svDob = svDob;
    }

    public String getSvPhoneNumber() {
        return svPhoneNumber;
    }

    public void setSvPhoneNumber(String svPhoneNumber) {
        this.svPhoneNumber = svPhoneNumber;
    }

    public String getSvGender() {
        return svGender;
    }

    public void setSvGender(String svGender) {
        this.svGender = svGender;
    }

    public String getSvImage() {
        return svImage;
    }

    public void setSvImage(String svImage) {
        this.svImage = svImage;
    }

    public String getSvAddress() {
        return svAddress;
    }

    public void setSvAddress(String svAddress) {
        this.svAddress = svAddress;
    }

    public String getSvFbUrl() {
        return svFbUrl;
    }

    public void setSvFbUrl(String svFbUrl) {
        this.svFbUrl = svFbUrl;
    }

    public String getSvRole() {
        return svRole;
    }

    public void setSvRole(String svRole) {
        this.svRole = svRole;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }

    public LocalDate getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(LocalDate updatedDate) {
        this.updatedDate = updatedDate;
    }

    public String getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(String creatorId) {
        this.creatorId = creatorId;
    }

    public String getUpdatorId() {
        return updatorId;
    }

    public void setUpdatorId(String updatorId) {
        this.updatorId = updatorId;
    }

    public Integer getSvStatus() {
        return svStatus;
    }

    public void setSvStatus(Integer svStatus) {
        this.svStatus = svStatus;
    }

    public String getJsonData() {
        return jsonData;
    }

    public void setJsonData(String jsonData) {
        this.jsonData = jsonData;
    }
}
