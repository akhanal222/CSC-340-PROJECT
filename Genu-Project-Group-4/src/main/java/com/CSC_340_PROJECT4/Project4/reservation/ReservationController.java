/*
package com.CSC_340_PROJECT4.Project4.reservation;

import com.CSC_340_PROJECT4.Project4.restaurant.RestaurantOwner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/reservations")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @GetMapping("/all")
    public String getAllReservations(Model model) {
        List<Reservation> reservations = reservationService.getAllReservations();
        model.addAttribute("reservations", reservations);
        return "redirect:/Customer/Reservation"; // Make sure this template exists
    }

    @GetMapping("")
    public String showCreateReservationForm(Model model) {
        model.addAttribute("reservation", new Reservation());
        return "/Customer/Reservation";
    }

    @PostMapping("/create")
    public String createReservation(@ModelAttribute Reservation reservation, Model model) {
        model.addAttribute("reservation", new Reservation());
        reservationService.createReservation(reservation);
        return "redirect:/Customer/Reservation";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteReservation(@PathVariable int id) {
        reservationService.deleteReservation(id);
        return "redirect:/reservations/all";
    }
}
*/

package com.CSC_340_PROJECT4.Project4.reservation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/reservations")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @GetMapping("/all")
    public String getAllReservations(Model model) {
        List<Reservation> reservations = reservationService.getAllReservations();
        model.addAttribute("reservations", reservations);
        return "Customer/ReservationList"; // show all the reservation customer have made
    }

    @GetMapping("")
    public String showCreateReservationForm(Model model){
        model.addAttribute("reservation", new Reservation()); // Redirect to the Reservation page
        return "Customer/Reservation";
    }

    @PostMapping("/create") // Make a new reservation
    public String createReservation(@ModelAttribute Reservation reservation, Model model) {
        model.addAttribute("reservation", new Reservation());
        return "Customer/ReservationList";
    }

    @DeleteMapping("/delete/{id}") // delete the reservation
    public String deleteReservation(@PathVariable int id) {
        reservationService.deleteReservation(id);
        return "redirect:/reservations/all";
    }
}
