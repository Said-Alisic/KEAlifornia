package hotel.kealifornia.demo.controllers;

import hotel.kealifornia.demo.models.Room;
import hotel.kealifornia.demo.repositories.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class RoomController {

    @Autowired
    RoomRepository roomRepo;

    @GetMapping("/rooms")
    public String rooms(Model model) {
        List<Room> rooms = roomRepo.readAll("");
        model.addAttribute("rooms", rooms);

        return "rooms";
    }
    
    @GetMapping("/rooms/add")
    public String addRoom(Model model) {
        model.addAttribute("newRoom", new Room());

        return "add-room";
    }

    @PostMapping("/rooms/add")
    public String handleAddRoom(@ModelAttribute Room room) {

        // TODO: 03/09/2019 - add roomRepo.addRoom(Room room) 

        return "redirect:/rooms?added";
    }

}
