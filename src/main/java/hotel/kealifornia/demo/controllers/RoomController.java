package hotel.kealifornia.demo.controllers;

import hotel.kealifornia.demo.models.Room;
import hotel.kealifornia.demo.repositories.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RoomController {

    @Autowired
    RoomRepository roomRepo;

    @GetMapping("/rooms")
    @ResponseBody
    public List<Room> getAllRoomsInHotel(/*@PathVariable int hotelId*/) {
//        System.out.println(hotelId);
//        return roomRepo.findRoomsByHotelId(hotelId);
        return roomRepo.findAll();
    }

    @PostMapping("/rooms/add")
    @ResponseBody
    public Room handleAddRoom(@ModelAttribute Room room) {
        System.out.println(roomRepo.add(room));

        return room;
    }


    @DeleteMapping("/rooms/delete/{id}")
    public String handleDeleteRoom(@PathVariable int id)  {
        System.out.println(id);
        roomRepo.delete(id);

        return "redirect:/rooms";
    }


    @PutMapping("/rooms/update/{id}")
    public String handleUpdateRoom(@ModelAttribute Room room, @PathVariable int id) {

        try {
            System.out.println("Test room handle update: " + roomRepo.update(id, room));
            return "redirect:/rooms";
        } catch (Exception e) {
            return "redirect:/rooms/update/{id}?error";
        }
    }
}
