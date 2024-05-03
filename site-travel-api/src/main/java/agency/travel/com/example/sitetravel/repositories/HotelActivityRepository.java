package agency.travel.com.example.sitetravel.repositories;

import agency.travel.com.example.sitetravel.entities.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightRepository extends JpaRepository<Flight, Long> {
}
