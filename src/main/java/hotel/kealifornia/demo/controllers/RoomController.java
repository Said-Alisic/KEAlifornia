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

        return "rooms/rooms";
    }
    
    @GetMapping("/rooms/add")
    public String addRoom(Model model) {
        model.addAttribute("newRoom", new Room());

        return "rooms/add-room";
    }

    @PostMapping("/rooms/add")
    public String handleAddRoom(@ModelAttribute Room room) {
        try {
            System.out.println(roomRepo.add(room));
            return "redirect:/rooms";
        } catch (Exception e) {
            return "redirect:/rooms/add?error=true";
        }

    }


    @GetMapping("/rooms/delete/{id}")
    public String handleDeleteRoom(@PathVariable int id)  {
        System.out.println(id);
        roomRepo.delete(id);

        return "redirect:/rooms";
    }

    @GetMapping("/rooms/update/{id}")
    public String updateRoom(Model model, @PathVariable int id) {
        model.addAttribute("updateRoom", roomRepo.findOne(id));

        return "rooms/update-room";
    }

    @PostMapping("/rooms/update/{id}")
    public String handleUpdateRoom(@ModelAttribute Room room, @PathVariable int id) {

        try {
            System.out.println("Test room handle update: " + roomRepo.update(id, room));
            return "redirect:/rooms";
        } catch (Exception e) {
            return "redirect:/rooms/update/{id}?error";
        }
    }
}
