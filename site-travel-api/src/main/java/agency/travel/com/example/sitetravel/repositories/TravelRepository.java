package agency.travel.com.example.sitetravel.repositories;

import agency.travel.com.example.sitetravel.entities.Activity;
import agency.travel.com.example.sitetravel.entities.Flight;
import agency.travel.com.example.sitetravel.entities.Hotel;
import agency.travel.com.example.sitetravel.entities.Travel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface TravelRepository extends JpaRepository<Travel, Long> {
    List<Flight> findFlightsByDepartureCityAndArrivalCityAndStartDateAfterAndEndDateBefore(String departureCity, String arrivalCity, LocalDate startDate, LocalDate endDate);

    List<Hotel> findHotelsByCityAndStartDateAfterAndEndDateBefore(String city, LocalDate startDate, LocalDate endDate);

    List<Activity> findActivitiesByCityAndStartDateAfterAndEndDateBefore(String city, LocalDate startDate, LocalDate endDate);


}
