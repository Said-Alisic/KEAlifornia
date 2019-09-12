package hotel.kealifornia.demo.controllers;

import hotel.kealifornia.demo.models.Guest;
import hotel.kealifornia.demo.repositories.GuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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

}
