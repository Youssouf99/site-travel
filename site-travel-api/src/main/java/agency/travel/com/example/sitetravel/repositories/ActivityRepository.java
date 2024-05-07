package agency.travel.com.example.sitetravel.repositories;

import agency.travel.com.example.sitetravel.entities.Activity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActivityRepository extends JpaRepository<Activity, Long> {
}
