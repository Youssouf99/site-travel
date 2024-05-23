package agency.travel.com.example.sitetravel.controllers;

import agency.travel.com.example.sitetravel.entities.Activity;
import agency.travel.com.example.sitetravel.entities.Flight;
import agency.travel.com.example.sitetravel.entities.Hotel;
import agency.travel.com.example.sitetravel.entities.Travel;
import agency.travel.com.example.sitetravel.services.travel.TravelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @GetMapping("/cities")
    public List<String> getAllDestinationCities() {
        return travelService.getAllDestinationCities();
    }

    @GetMapping("/departuresCities")
    public List<String> getAllDeparturesCities() {
        return travelService.getAllDeparturesCities();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        travelService.delete(id);
    }


    @GetMapping("/search")
    public ResponseEntity<Page<Travel>> searchTravels(
            @RequestParam(required = false) String destination,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate,
            @RequestParam(required = false) String type,
            @RequestParam(required = false, defaultValue = "price_asc") String sortField,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {

        Page<Travel> travels = travelService.searchTravels(destination, startDate, endDate, type, sortField, page , size);
        return ResponseEntity.ok(travels);
    }

    @GetMapping("/search/flights")
    public ResponseEntity<Page<Flight>> searchFlights(
            @RequestParam(required = false) String destination,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate,
            @RequestParam(required = false) String departureCity,
            @RequestParam(required = false, defaultValue = "price_asc") String sortField,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {

        Page<Flight> flights = travelService.searchFlights(destination, startDate, endDate, departureCity, sortField, page, size);
        return ResponseEntity.ok(flights);

    }

    @GetMapping("/search/hotels")
    public ResponseEntity<Page<Hotel>> searchHotels(
            @RequestParam(required = false) String destination,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate,
            @RequestParam(required = false, defaultValue = "price_asc") String sortField,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {

        Page<Hotel> hotels = travelService.searchHotels(destination, startDate, endDate, sortField, page, size);
        return ResponseEntity.ok(hotels);
    }

    @GetMapping("/search/activities")
    public ResponseEntity<Page<Activity>> searchActivities(
            @RequestParam(required = false) String destination,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate,
            @RequestParam(required = false, defaultValue = "price_asc") String sortField,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {

        Page<Activity> activities = travelService.searchActivities(destination, startDate, endDate, sortField, page, size);
        return ResponseEntity.ok(activities);
    }




}
