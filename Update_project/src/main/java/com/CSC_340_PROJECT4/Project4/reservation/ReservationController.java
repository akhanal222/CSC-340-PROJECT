package com.CSC_340_PROJECT4.Project4.reservation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservations")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @GetMapping("/all")   // show all the reservation
    public List<Reservation> getAllReservations() {
        return reservationService.getAllReservations();
    }

    @PostMapping("/create")   // Make a new Reservation
    public Reservation createReservation(@RequestBody Reservation reservation) {
        return reservationService.createReservation(reservation);
    }

    @DeleteMapping("/delete/{id}")   // delete the Reservation
    public void deleteReservation(@PathVariable int id) {
        reservationService.deleteReservation(id);
    }
}
