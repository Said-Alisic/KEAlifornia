package hotel.kealifornia.demo.controllers;

import hotel.kealifornia.demo.models.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ReservationController {

//    @Autowired
//    ReservationRepository reservationRepo;

    @GetMapping("/reservations")
    public String reservationsPage(Model m) {

        // TODO: Pull all reservations from db
//        List<Reservation> reservations = reservationRepo.findAll();
//        m.addAttribute("reservations", reservations);

        return "reservations/reservations";
    }

}
