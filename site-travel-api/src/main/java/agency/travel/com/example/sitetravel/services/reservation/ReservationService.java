package agency.travel.com.example.sitetravel.services.reservation;

import agency.travel.com.example.sitetravel.dtos.ReservationDto;

import java.util.List;

public interface ReservationService {

    ReservationDto createReservation(Long userId, Long travelId);

    List<ReservationDto> getAllReservations();

    ReservationDto getReservationById(Long reservationId);

    void deleteReservation(Long reservationId);

    ReservationDto addTravelsToReservation(Long userId, Long reservationId, List<Long> travelIds);
}
