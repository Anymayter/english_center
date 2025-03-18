package com.toan.english_center.DTO;

public class AccountDTO {
    private String aId;
    private String aUid;
    private String aPwd;
    private Integer aType;
    private Integer aStatus;
    private String jsonData;

    // Getter và setter

    public String getaId() {
        return aId;
    }

    public void setaId(String aId) {
        this.aId = aId;
    }

    public String getaUid() {
        return aUid;
    }

    public void setaUid(String aUid) {
        this.aUid = aUid;
    }

    public String getaPwd() {
        return aPwd;
    }

    public void setaPwd(String aPwd) {
        this.aPwd = aPwd;
    }

    public Integer getaType() {
        return aType;
    }

    public void setaType(Integer aType) {
        this.aType = aType;
    }

    public Integer getaStatus() {
        return aStatus;
    }

    public void setaStatus(Integer aStatus) {
        this.aStatus = aStatus;
    }

    public String getJsonData() {
        return jsonData;
    }

    public void setJsonData(String jsonData) {
        this.jsonData = jsonData;
    }
}
