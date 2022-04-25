package com.alishirmohammadi.AirlineTicketBookingSystem.controller;
import com.alishirmohammadi.AirlineTicketBookingSystem.entity.Airlines;
import com.alishirmohammadi.AirlineTicketBookingSystem.service.AirlinesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import java.util.List;

@Controller
public class AirlinesController {
    @Autowired
    AirlinesService airlinesService;
    @GetMapping("/airlines")

    public String findAllAirlines(Model model) {
        List<Airlines> airlines = airlinesService.findAllAirlines();
        model.addAttribute("airlines", airlines);
        return "list-airlines";
    }
    @GetMapping("/airline/{id}")

    public String findAirlineById(@PathVariable("id") Long id, Model model) {
       Airlines airlines =airlinesService.findAirlinesById(id);
        model.addAttribute("airlines", airlines);
        return "list-airlines";
    }

    @GetMapping("/addAirline")
    public String showCreateForm(Airlines airlines) {
        return "add-airline";
    }
    @PostMapping("/add-airline")
    public String createAirline(Airlines airlines, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-airline";
        }

       airlinesService.saveAirlines(airlines);
        model.addAttribute("airlines", airlinesService.findAllAirlines());
        return "redirect:/airlines";
    }

    @GetMapping("/updateAirline/{id}")
    public String showUpdateForm(@PathVariable("id") Long id, Model model) {
        Airlines airlines = airlinesService.findAirlinesById(id);
        model.addAttribute("airlines", airlines);
        return "update-airline";
    }
    @PostMapping("/update-airline/{id}")

    public String updateAirline(@PathVariable("id") Long id, Airlines airlines, BindingResult result, Model model) {


        airlinesService.updateAirlines(airlines);
        model.addAttribute("airlines", airlinesService.findAllAirlines());
        return "redirect:/airlines";
    }
    @GetMapping("/remove-airline/{id}")

    public String deleteAirline(@PathVariable("id") Long id, Model model) {
       airlinesService.deleteAirlines(id);
        model.addAttribute("airlines", airlinesService.findAllAirlines());
        return "redirect:/airlines";
    }

}
