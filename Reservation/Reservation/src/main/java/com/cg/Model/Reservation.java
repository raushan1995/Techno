package com.cg.Model;

import lombok.*;

import javax.persistence.*;

@Entity     //annotation for model class
@Table(name = "reservations")  // table in database
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

public class Reservation {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)

     private int id;
    private String typeOfReservation;
    private String modeOfTransaction;
    private String dateOfReservation;
    private String tenureOfReservation;
}
