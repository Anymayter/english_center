package com.toan.english_center.DTO;

public class LoginRequest {

    private String username;
    private String password;


    // Constructor mặc định
    public LoginRequest() {
    }

    // Constructor có tham số
    public LoginRequest(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // Getter and setter

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
