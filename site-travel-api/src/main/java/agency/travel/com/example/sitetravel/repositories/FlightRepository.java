package agency.travel.com.example.sitetravel.repositories;

import agency.travel.com.example.sitetravel.entities.Flight;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Long> {


    @Query("SELECT DISTINCT f.departureCity FROM Flight f")
    List<String> findAllDistinctDepartureCity();

    @Query("SELECT f FROM Flight f WHERE "
            + "(:destination IS NULL OR f.destinationCity = :destination) "
            + "AND (:startDate IS NULL OR f.startDate >= :startDate) "
            + "AND (:endDate IS NULL OR f.endDate <= :endDate) "
            + "AND (:departureCity IS NULL OR f.departureCity = :departureCity) ")
    Page<Flight> searchFlights(
            @Param("destination") String destination,
            @Param("startDate") LocalDate startDate,
            @Param("endDate") LocalDate endDate,
            @Param("departureCity") String departureCity,
            Pageable pageable);



}
