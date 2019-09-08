package hotel.kealifornia.demo.controllers;

import hotel.kealifornia.demo.models.Reservation;
import hotel.kealifornia.demo.models.Room;
import hotel.kealifornia.demo.repositories.ReservationRepository;
import hotel.kealifornia.demo.repositories.RoomRepository;
import org.apache.tomcat.jni.Local;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ReservationController {

    @Autowired
    ReservationRepository reservationRepo;

    @Autowired
    RoomRepository roomRepo;

    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    @GetMapping("/reservations")
    public String reservationsPage(Model m) {

        List<Reservation> reservations = reservationRepo.findAll();
        m.addAttribute("reservations", reservations);

        return "reservations/reservations";
    }


    @GetMapping("/reservations/search")
    public String searchRoomsPage() {

        return "reservations/search";
    }

    @PostMapping("/reservations/search")
    public String displayAvailableRooms(@RequestParam String checkInDate, @RequestParam String checkOutDate, Model m) {
        System.out.println("check in " + checkInDate);
        System.out.println("check out " + checkOutDate);

        // Convert request dates string into LocalDate objects
        LocalDate checkIn = LocalDate.parse(checkInDate, formatter);
        LocalDate checkOut = LocalDate.parse(checkOutDate, formatter);

        // Get all rooms
        List<Room> allRooms = roomRepo.findAll();
        // Filter out available rooms in between desired period
        List<Room> availableRooms = getAvailableRoomsBetweenDates(allRooms, checkIn, checkOut);

        // Should show list of available rooms
        m.addAttribute("checkInDate", checkInDate);
        m.addAttribute("checkOutDate", checkOutDate);
        m.addAttribute("daysOfStay", getNumberOfDaysBetween(checkIn,checkOut));
        m.addAttribute("rooms", availableRooms);

        return "reservations/search";
    }


    // === HELPER methods ===
    // Calculates days in between provided days
    private Object getNumberOfDaysBetween(LocalDate checkInDate, LocalDate checkOutDate) {

        Period period = Period.between(checkInDate, checkOutDate);

        return period.getDays();
    }

    // Helper method that filters out available rooms in provided period
    private List<Room> getAvailableRoomsBetweenDates(List<Room> allRooms, LocalDate checkIn, LocalDate checkOut) {
        // TODO: finish this method. a Lot of magic involved
        List<Room> availableRooms = new ArrayList<>();

        // Loop over rooms which have lists of reservations
        allRooms.forEach(room -> {
            // Loop over room's reservations
            room.getReservations().forEach(reservation -> {
                // Check if dates are overlapping - logic and stuff
                // Validate check in date
                if (checkIn.isEqual(reservation.getCheckInDay())
                        || (checkIn.isAfter(reservation.getCheckInDay()) && checkIn.isBefore(reservation.getCheckOutDay()))
                        /* HERE IT IS KUBA! - Added line below to if-statement */
                        || checkIn.isBefore(reservation.getCheckOutDay()) && !checkOut.isBefore(reservation.getCheckInDay())) {
                        return;
                }
                // Validate checkout date
                if (checkOut.isAfter(reservation.getCheckInDay()) && checkOut.isBefore(reservation.getCheckOutDay())) {
                    return;
                }
                System.out.println("inside lambda!");
                // If passed, add room to the available
                if (!availableRooms.contains(room)) {
                   availableRooms.add(room);
                };
            });
        });

        return availableRooms;
    }
}
