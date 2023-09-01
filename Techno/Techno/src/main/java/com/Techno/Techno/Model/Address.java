package com.Techno.Techno.Model;
import lombok.*;

import javax.persistence.*;


@Entity

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Table(name = "address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_id")
    private int addressId;
    private String city;
    private String state;
    private String country;
    private Long pinCode;
    private String addressLine1;
    private String addressLine2;

}

