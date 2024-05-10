package agency.travel.com.example.sitetravel.controllers;

import agency.travel.com.example.sitetravel.dtos.ReservationDto;
import agency.travel.com.example.sitetravel.services.reservation.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/reservations")
public class ReservationController {

    private final ReservationService reservationService;

    @Autowired
    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }


    @PostMapping
    public ResponseEntity<ReservationDto> createReservation(@RequestParam("userId") Long userId, @RequestParam("travelId") Long travelId) {
        ReservationDto createdReservation = reservationService.createReservation(userId, travelId);
        if (createdReservation != null) {
            return new ResponseEntity<>(createdReservation, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReservationDto> getReservationById(@PathVariable("id") Long reservationId) {
        ReservationDto reservationDto = reservationService.getReservationById(reservationId);
        if (reservationDto != null) {
            return new ResponseEntity<>(reservationDto, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping
    public ResponseEntity<List<ReservationDto>> getAllReservations() {
        List<ReservationDto> reservations = reservationService.getAllReservations();
        return new ResponseEntity<>(reservations, HttpStatus.OK);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReservation(@PathVariable("id") Long reservationId) {
        reservationService.deleteReservation(reservationId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    @PutMapping("/addTravels")
    public ResponseEntity<ReservationDto> addTravelsToReservation(@RequestParam("userId") Long userId,
                                                                  @RequestParam("reservationId") Long reservationId,
                                                                  @RequestBody List<Long> travelIds) {
        ReservationDto updatedReservation = reservationService.addTravelsToReservation(userId, reservationId, travelIds);
        if (updatedReservation != null) {
            return new ResponseEntity<>(updatedReservation, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


}
