package hotel.kealifornia.demo.controllers;

import hotel.kealifornia.demo.models.Room;
import hotel.kealifornia.demo.repositories.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {

    @Autowired
    RoomRepository roomRepo;

    @GetMapping("/")
    private String home(Model m) {

        List<Room> rooms = roomRepo.readAll("");
        m.addAttribute("rooms", rooms);

        return "home";
    }
}
