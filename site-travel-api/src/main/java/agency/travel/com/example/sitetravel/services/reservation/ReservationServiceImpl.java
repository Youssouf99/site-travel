package agency.travel.com.example.sitetravel.services.reservation;

import agency.travel.com.example.sitetravel.dtos.ReservationDto;
import agency.travel.com.example.sitetravel.entities.Reservation;
import agency.travel.com.example.sitetravel.entities.Travel;
import agency.travel.com.example.sitetravel.entities.User;
import agency.travel.com.example.sitetravel.exceptions.NotFoundException;
import agency.travel.com.example.sitetravel.mappers.ReservationMapper;
import agency.travel.com.example.sitetravel.repositories.ReservationRepository;
import agency.travel.com.example.sitetravel.services.travel.TravelService;
import agency.travel.com.example.sitetravel.services.user.UserService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ReservationServiceImpl implements ReservationService {

    private final ReservationRepository reservationRepository;
    private final ReservationMapper reservationMapper;
    private final TravelService travelService;
    private final UserService userService;


    public ReservationServiceImpl(ReservationRepository reservationRepository, ReservationMapper reservationMapper, TravelService travelService, UserService userService) {
        this.reservationRepository = reservationRepository;
        this.reservationMapper = reservationMapper;
        this.travelService = travelService;
        this.userService = userService;
    }

    @Override
    public ReservationDto createReservation(Long userId, Long travelId) {
        User user = userService.findById(userId);
        if (user == null) {
            throw new NotFoundException("User not found");
        }
        Travel travel = travelService.findById(travelId);
        if (travel == null) {
            throw new NotFoundException("User not found");
        }
        Reservation reservation = new Reservation();
        reservation.setDate(new Date());
        reservation.setUser(user);
        reservation.getTravels().add(travel);
        reservation.setPriceTotal(travel.getPrice());
        Reservation savedReservation = reservationRepository.save(reservation);
        return reservationMapper.toReservationDto(savedReservation);
    }

    @Override
    public List<ReservationDto> getAllReservations() {
        List<Reservation> reservations = reservationRepository.findAll();
        return reservations.stream().map(reservationMapper::toReservationDto)
                .collect(Collectors.toList());
    }
    @Override
    public ReservationDto getReservationById(Long reservationId) {
        Reservation reservation =  reservationRepository.findById(reservationId)
                .orElseThrow(() -> new NotFoundException("Reservation not found"));

        return reservationMapper.toReservationDto(reservation);
    }

    @Override
    public void deleteReservation(Long reservationId) {
        reservationRepository.deleteById(reservationId);
    }

    @Override
    public ReservationDto addTravelsToReservation(Long userId, Long reservationId, List<Long> travelIds) {

        User user = userService.findById(userId);
        if (user == null) {
            throw new NotFoundException("User not found");
        }

        Reservation reservation = reservationRepository.findByUserAndId(user, reservationId);
        if (reservation == null) {
            throw new NotFoundException("Reservation not found");
        }
        List<Travel> travelsToAdd = travelService.findAllById(travelIds);
        if (travelsToAdd.isEmpty()) {
            throw new NotFoundException("Travel Not Found");
        }
        reservation.getTravels().addAll(travelsToAdd);
        // Recalculer le prix total de la réservation
        double totalPrice = reservation.getPriceTotal();
        for (Travel travel : travelsToAdd) {
            totalPrice += travel.getPrice();
        }
        reservation.setPriceTotal(totalPrice);
        Reservation updatedReservation = reservationRepository.save(reservation);
        return reservationMapper.toReservationDto(updatedReservation);
    }




}
