package agency.travel.com.example.sitetravel.controllers;

import agency.travel.com.example.sitetravel.dtos.FlightDto;
import agency.travel.com.example.sitetravel.services.travel.FlightService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/flights")
public class FlightController {

    private final FlightService flightService;

    public FlightController(FlightService flightService) {
        this.flightService = flightService;
    }

    @GetMapping
    public ResponseEntity<List<FlightDto>> getAllFlights() {
        List<FlightDto> flights = flightService.getAllFlights();
        return new ResponseEntity<>(flights, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FlightDto> getFlightById(@PathVariable Long id) {
        FlightDto flight = flightService.getFlightById(id);
        return new ResponseEntity<>(flight, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<FlightDto> createFlight(@RequestBody FlightDto flightDto) {
        FlightDto createdFlight = flightService.createFlight(flightDto);
        return new ResponseEntity<>(createdFlight, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FlightDto> updateFlight(@PathVariable Long id, @RequestBody FlightDto flightDto) {
        FlightDto updatedFlight = flightService.updateFlight(id, flightDto);
        return new ResponseEntity<>(updatedFlight, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFlight(@PathVariable Long id) {
        flightService.deleteFlight(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
