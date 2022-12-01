package edu.unimeet.dto;

import lombok.Data;

@Data
public class UserCreateDTO {


    private String firstName;

    private String lastName;

    private String userName;

    private String gender;

    private String email;

    private String phoneNumber;

    private String userBio;

    private String userPassword;


}
