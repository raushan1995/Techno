package com.Techno.Techno.Service;

import com.Techno.Techno.Model.Address;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserDto {
    private int id;
    private String userName;
    private String dateOfBirth;
    private String emailId;
    private Long phoneNumber;
    private String gender;
    private String userStatus;
    private Address address;
}
