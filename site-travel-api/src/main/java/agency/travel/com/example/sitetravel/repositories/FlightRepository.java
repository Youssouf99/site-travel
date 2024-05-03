package agency.travel.com.example.sitetravel.repositories;

import agency.travel.com.example.sitetravel.entities.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Long> {
}
