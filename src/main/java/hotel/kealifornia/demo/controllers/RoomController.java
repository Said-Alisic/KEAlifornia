package hotel.kealifornia.demo.controllers;

import hotel.kealifornia.demo.models.Room;
import hotel.kealifornia.demo.repositories.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
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
    public Room handleAddRoom(@RequestBody Room room) {
        System.out.println(roomRepo.add(room).toString());
        return room;
    }


    @DeleteMapping("/rooms/delete/{id}")
    public int handleDeleteRoom(@PathVariable int id)  {
        System.out.println(id + " - " + roomRepo.delete(id));

        return id;
    }


    @PutMapping("/rooms/update")
    @ResponseBody
    public Room handleUpdateRoom(@RequestBody Room room) {
        System.out.println(roomRepo.update(room.getRoomId(), room));

        return room;
    }
}

