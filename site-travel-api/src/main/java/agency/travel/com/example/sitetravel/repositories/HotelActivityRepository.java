package agency.travel.com.example.sitetravel.repositories;

import agency.travel.com.example.sitetravel.entities.HotelActivity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HotelActivityRepository extends JpaRepository<HotelActivity, Long> {
}
