package com.example.internshipsentura.dto;

import lombok.Data;

import java.util.List;

@Data
public class UserDto {
    private String uid;
    private String email;
    private String givenName;
    private String middleName;
    private String name;
    private String familyName;
    private String nickname;
    private String phoneNumber;
    private String comment;
    private String picture;
    private String directory;
    private String metadata; // Keep it as a String
    private List<String> tags;
    private boolean isSuspended;

    public String getRoles() {
        return null;
    }
}
