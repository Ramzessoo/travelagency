package pl.ramzessoo.travelagency.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.ramzessoo.travelagency.model.Hotel;
import pl.ramzessoo.travelagency.service.HotelService;

@Controller
@RequestMapping("/hotels")
public class NewHotelController {
    @Autowired
    private HotelService hotelService;
    @PostMapping("/newhotel")
    public String handleNewHotel(ModelMap modelMap, @ModelAttribute("hotel") final Hotel hotel){
//        modelMap.addAttribute("hotel", new HotelController());
//        modelMap.addAttribute("hotelName");
        return "redirect:/";
    }
}
