package hotel.kealifornia.demo.controllers;

import hotel.kealifornia.demo.models.Guest;
import hotel.kealifornia.demo.models.Reservation;
import hotel.kealifornia.demo.models.Room;
import hotel.kealifornia.demo.repositories.GuestRepository;
import hotel.kealifornia.demo.repositories.ReservationRepository;
import hotel.kealifornia.demo.repositories.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @Autowired
    GuestRepository guestRepo;

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

    @GetMapping("/reservations/add/{roomId}/{checkInDate}/{checkOutDate}")
    public String displayBookingPage(
            @PathVariable int roomId,
            @PathVariable String checkInDate,
            @PathVariable String checkOutDate,
            Model m) {

        LocalDate checkIn = LocalDate.parse(checkInDate, formatter);
        LocalDate checkOut = LocalDate.parse(checkOutDate, formatter);
        Room room = roomRepo.findOne(roomId);

        Reservation reservation = new Reservation();
        // Set total price
        reservation.setTotal(room.getPrice() * getNumberOfDaysBetween(checkIn, checkOut));
        reservation.setCheckInDay(checkIn);
        reservation.setCheckOutDay(checkOut);
        reservation.setRoom(room);

        m.addAttribute("reservation", reservation);

        return "reservations/add";
    }


    @PostMapping("/reservations/add/{checkInDate}/{checkOutDate}")
    public String addReservation(@ModelAttribute Reservation reservation, @PathVariable String checkInDate, @PathVariable String checkOutDate) {

        LocalDate checkIn = LocalDate.parse(checkInDate, formatter);
        LocalDate checkOut = LocalDate.parse(checkOutDate, formatter);

        reservation.setCheckInDay(checkIn);
        reservation.setCheckOutDay(checkOut);

        // Add New Guest to db, get back id
        Guest guest = guestRepo.add(reservation.getGuest());
        // Set guest id that was added to db
        reservation.getGuest().setGuestId(guest.getGuestId());
        // Add New reservation to db
        reservationRepo.add(reservation);

        return "redirect:/reservations";
    }

    // === HELPER methods ===
    // Calculates days in between provided days
    private int getNumberOfDaysBetween(LocalDate checkInDate, LocalDate checkOutDate) {

        Period period = Period.between(checkInDate, checkOutDate);

        return period.getDays();
    }

    // Helper method that filters out available rooms in provided period
    private List<Room> getAvailableRoomsBetweenDates(List<Room> allRooms, LocalDate checkIn, LocalDate checkOut) {
        List<Room> availableRooms = new ArrayList<>();

        // Loop over rooms which have lists of reservations
        for (int i = 0; i < allRooms.size(); i++) {
            Room room = allRooms.get(i);
            List<Reservation> reservations = room.getReservations();
            // Check if dates are overlapping - logic and stuff
            for (int j = 0; j < reservations.size(); j++) {
                if (checkIn.isEqual(reservations.get(j).getCheckInDay())
                        || checkIn.isAfter(reservations.get(j).getCheckInDay()) && checkIn.isBefore(reservations.get(j).getCheckOutDay())
                        || checkIn.isBefore(reservations.get(j).getCheckInDay()) && checkOut.isAfter(reservations.get(j).getCheckInDay())
                        || checkIn.isAfter(reservations.get(j).getCheckInDay()) && checkOut.isAfter(reservations.get(j).getCheckInDay()) && checkIn.isBefore(reservations.get(j).getCheckOutDay())
                        || checkOut.isAfter(reservations.get(j).getCheckInDay()) && checkOut.isBefore(reservations.get(j).getCheckOutDay())) {
                    break;
                }

                // If passed, add room to the available if not there yet
                if (!availableRooms.contains(room)) {
                    availableRooms.add(room);
                }
            }

        }

        return availableRooms;
    }
}
