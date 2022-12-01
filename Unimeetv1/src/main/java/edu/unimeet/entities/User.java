package edu.unimeet.entities;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "tb_users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user")
    private Integer userId;

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "lastName")
    private String lastName;

    @Column(name = "tx_userName")
    private String userName;

    @Column(name = "Gender")
    private String gender;

    @Column(name = "Email")
    private String email;

    @Column(name = "PhoneNumber")
    private String phoneNumber;

    @Column(name = "UserBio")
    private String userBio;

    @Column(name = "UserPassword")
    private String userPassword;

    @ManyToOne
    @JoinColumn(name = "uniDeptID")
    private UniDept uniDept;

    public User(String firstName, String lastName, String userName, String gender, String email, String phoneNumber,
                String userBio, String userPassword) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.gender = gender;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.userBio = userBio;
        this.userPassword = userPassword;
    }


}