package com.Techno.Techno.Service;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ReservationDto {

    private int id;
    private String typeOfReservation;
    private String modeOfTransaction;
    private String dateOfReservation;
    private String tenureOfReservation;
}
