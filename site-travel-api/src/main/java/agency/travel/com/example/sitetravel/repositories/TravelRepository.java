package agency.travel.com.example.sitetravel.repositories;

import agency.travel.com.example.sitetravel.entities.Travel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TravelRepository extends JpaRepository<Travel, Long> {
}
