package edu.unimeet.dto;

import edu.unimeet.entities.UniDept;
import edu.unimeet.entities.User;
import lombok.Getter;

import java.io.Serializable;

@Getter
public class UserViewDTO implements Serializable {

    private static final long serialVersionUID = 1L;


    private final String firstName;

    private final String lastName;

    private final String userName;

    private final String gender;

    private final String email;

    private final String phoneNumber;

    private final String userBio;

    private UniDeptViewDto uniDept;

    public UserViewDTO(String firstName, String lastName, String userName, String gender, String email, String phoneNumber,
                        String userBio,UniDeptViewDto uniDept) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.gender = gender;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.userBio = userBio;
        this.uniDept = uniDept;
    }

    public static UserViewDTO of(User user) {

        return new UserViewDTO(user.getFirstName(), user.getLastName(), user.getUserName(), user.getGender(),
                user.getEmail(), user.getPhoneNumber(), user.getUserBio(),UniDeptViewDto.of(user.getUniDept()));

    }


}
