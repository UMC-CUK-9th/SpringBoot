package com.example.umc9th.domain.user.dto;

public class UserInfoDto {

    private final String name;
    private final String email;
    private final String phoneNumber;
    private final int point;

    public UserInfoDto(String name, String email, String phoneNumber, int point) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.point = point;
    }

    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getPhoneNumber() { return phoneNumber; }
    public int getPoint() { return point; }
}