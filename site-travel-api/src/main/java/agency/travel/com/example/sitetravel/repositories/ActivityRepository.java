package agency.travel.com.example.sitetravel.repositories;

import agency.travel.com.example.sitetravel.entities.Activity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface ActivityRepository extends JpaRepository<Activity, Long> {

    @Query("SELECT a FROM Activity a WHERE "
            + "(:destination IS NULL OR a.destinationCity = :destination) "
            + "AND (:startDate IS NULL OR a.startDate >= :startDate) "
            + "AND (:endDate IS NULL OR a.endDate <= :endDate) ")
    Page<Activity> searchActivities(
            @Param("destination") String destination,
            @Param("startDate") LocalDate startDate,
            @Param("endDate") LocalDate endDate,
            Pageable pageable);

}
