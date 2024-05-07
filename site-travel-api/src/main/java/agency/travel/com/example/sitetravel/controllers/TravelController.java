package agency.travel.com.example.sitetravel.controllers;

import agency.travel.com.example.sitetravel.dtos.*;
import agency.travel.com.example.sitetravel.entities.Flight;
import agency.travel.com.example.sitetravel.entities.Hotel;
import agency.travel.com.example.sitetravel.entities.Travel;
import agency.travel.com.example.sitetravel.exceptions.NotFoundException;
import agency.travel.com.example.sitetravel.services.travel.TravelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/travels")
public class TravelController {

    private final TravelService travelService;

    @Autowired
    public TravelController(TravelService travelService) {
        this.travelService = travelService;
    }

    @GetMapping("")
    public List<TravelDetailDto> getTravels() {
        return travelService.getAllTravels();

    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        travelService.delete(id);
    }




}
