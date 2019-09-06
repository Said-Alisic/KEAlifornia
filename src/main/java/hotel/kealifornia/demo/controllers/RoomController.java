package hotel.kealifornia.demo.controllers;

import hotel.kealifornia.demo.models.Room;
import hotel.kealifornia.demo.repositories.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class RoomController {

    @Autowired
    RoomRepository roomRepo;

    @GetMapping("/rooms")
    public String rooms(Model model) {
        List<Room> rooms = roomRepo.findAll();
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
        System.out.println(roomRepo.add(room));

        return "redirect:/rooms?added";
    }


    @GetMapping("/rooms/delete/{id}")
    public String handleDeleteRoom(@PathVariable int id)  {
        System.out.println(id);
        roomRepo.delete(id);

        return "redirect:/rooms?deleted";
    }

    @GetMapping("/rooms/update/{id}")
    public String updateRoom(Model model, @PathVariable int id) {
        model.addAttribute("updateRoom", roomRepo.findOne(id));

        return "update-room";
    }

    @PostMapping("/rooms/update/{id}")
    public String handleUpdateRoom(@ModelAttribute Room room, @PathVariable int id) {

        System.out.println("Test room handle update: " + room.toString());

        return "redirect:/rooms?updated";
    }

}
