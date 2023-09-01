package com.cg.Controller;

import com.cg.Model.Reservation;
import com.cg.Repository.ReservationRepository;
import com.cg.Service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping
public class ReservationController {

    @Autowired
    private ReservationService reservationService;    //connect reservation service

    @Autowired
    private ReservationRepository reservationRepository;

    // display list of reservations

    @GetMapping("/")
    public String viewHomePage(Model model) {
        model.addAttribute("listReservations", reservationService.getAllReservations());
        return "index";        //after fetch details page will redirect to index page
    }


    @GetMapping("/showNewReservationForm")
    public String showNewUserForm(Model model) {
        // create model attribute to bind form data
        Reservation reservation = new Reservation();
        model.addAttribute("reservation", reservation);
        return "new_reservation";     //
    }

    @PostMapping("/saveReservation")
    public String saveReservation(@ModelAttribute("reservation") Reservation reservation) {
        // save user to database
        reservationService.saveReservation(reservation);

        return "redirect:/";     // after fill user details and submit , page will redirect to index page
    }

    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") int id, Model model) {

        // get user from the service
        Reservation reservation = reservationService.getReservationById(id);

        // set user as a model attribute to pre-populate the form
        model.addAttribute("reservation", reservation);
        return "update_reservation";   // after update the details page will redirect to index page
    }

    @GetMapping("/deleteReservation/{id}")
    public String deleteReservation(@PathVariable(value = "id") int id) {

        // call delete user method
        this.reservationService.deleteReservationById(id);
        return "redirect:/"; // after delete page will be on index page
    }

}
