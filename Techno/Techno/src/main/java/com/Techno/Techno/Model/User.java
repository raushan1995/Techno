package com.Techno.Techno.Model;

import lombok.*;

import javax.persistence.*;

@Entity     //annotation for model class
@Table(name = "users")  // table in database
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class User {

    @Id     // annotation for primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)   // auto generation pk
    private int id;
    private String userName;
    private String dateOfBirth;
    private String emailId;
    private Long phoneNumber;
    private String gender;
    private String userStatus;

    private String reservationId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_address_id")
    private Address address;



}
