package agency.travel.com.example.sitetravel.repositories;

import agency.travel.com.example.sitetravel.entities.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface HotelRepository extends JpaRepository<Hotel, Long> {
    List<Hotel> findByCityAndStartDateBeforeAndEndDateAfter(String city, LocalDate checkOutDate, LocalDate checkInDate);
    
    List<Hotel> findByCity(String city);

    List<Hotel> findByStartDateBetween(LocalDate startDate, LocalDate endDate);

    List<Hotel> findByPriceBetween(double minPrice, double maxPrice);
}
