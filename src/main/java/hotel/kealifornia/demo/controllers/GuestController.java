package hotel.kealifornia.demo.controllers;

import hotel.kealifornia.demo.models.Guest;
import hotel.kealifornia.demo.repositories.GuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GuestController {

    @Autowired
    GuestRepository guestRepo;


    @GetMapping("/guests")
    @ResponseBody
    public List<Guest> guests() {

        return guestRepo.findAll();
    }


    @PostMapping("/guests/add")
    @ResponseBody
    public Guest handleAddGuest(@RequestBody Guest guest) {
        System.out.println(guest.toString());

       return guestRepo.addGuestTest(guest);

    }

    @PutMapping("/guests/edit/{id}")
    @ResponseBody
    public Guest handleEditGuest(@RequestBody Guest guest, @PathVariable int id) {
        System.out.println(guest.toString() + " | id: " + id);

        return null;
    }




}
