package agency.travel.com.example.sitetravel.repositories;

import agency.travel.com.example.sitetravel.entities.Reservation;
import agency.travel.com.example.sitetravel.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    Reservation findByUserAndId(User user, Long reservationId);



}
