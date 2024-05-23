package agency.travel.com.example.sitetravel.repositories;

import agency.travel.com.example.sitetravel.entities.Hotel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface HotelRepository extends JpaRepository<Hotel, Long> {
    List<Hotel> findByStartDateBetween(LocalDate startDate, LocalDate endDate);
    List<Hotel> findByPriceBetween(double minPrice, double maxPrice);

    @Query("SELECT h FROM Hotel h WHERE "
            + "(:destination IS NULL OR h.destinationCity = :destination) "
            + "AND (:startDate IS NULL OR h.startDate >= :startDate) "
            + "AND (:endDate IS NULL OR h.endDate <= :endDate) ")
    Page<Hotel> searchHotels(
            @Param("destination") String destination,
            @Param("startDate") LocalDate startDate,
            @Param("endDate") LocalDate endDate,
            Pageable pageable);
}
