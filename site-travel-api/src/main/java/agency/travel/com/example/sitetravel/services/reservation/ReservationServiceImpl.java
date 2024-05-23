package agency.travel.com.example.sitetravel.services.reservation;

import agency.travel.com.example.sitetravel.dtos.ReservationDto;
import agency.travel.com.example.sitetravel.entities.Hotel;
import agency.travel.com.example.sitetravel.entities.Reservation;
import agency.travel.com.example.sitetravel.entities.Travel;
import agency.travel.com.example.sitetravel.entities.User;
import agency.travel.com.example.sitetravel.exceptions.AvailableOfRoomsException;
import agency.travel.com.example.sitetravel.exceptions.NotFoundException;
import agency.travel.com.example.sitetravel.mappers.ReservationMapper;
import agency.travel.com.example.sitetravel.repositories.ReservationRepository;
import agency.travel.com.example.sitetravel.repositories.TravelRepository;
import agency.travel.com.example.sitetravel.repositories.UserRepository;
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
    private final TravelRepository travelRepository;
    private final UserRepository userRepository;


    public ReservationServiceImpl(ReservationRepository reservationRepository, ReservationMapper reservationMapper, TravelRepository travelRepository, UserRepository userRepository) {
        this.reservationRepository = reservationRepository;
        this.reservationMapper = reservationMapper;
        this.travelRepository = travelRepository;
        this.userRepository = userRepository;
    }

    @Override
    public ReservationDto createReservation(Long userId, Long travelId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new NotFoundException("User not found"));

        Travel travel = travelRepository.findById(travelId)
                .orElseThrow(() -> new NotFoundException("Travel not found"));

        if (travel instanceof Hotel hotel){
            if (hotel.getAvailableOfRooms() < 1 ) {
                throw new AvailableOfRoomsException("No available rooms for this Hotel");
            }
           hotel.setAvailableOfRooms(hotel.getAvailableOfRooms() -1 );
        }

        Reservation reservation = new Reservation();
        reservation.setDate(new Date());
        reservation.setUser(user);
        reservation.setTravel(travel);
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




}
