package agency.travel.com.example.sitetravel.repositories;


import agency.travel.com.example.sitetravel.entities.Travel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface TravelRepository extends JpaRepository<Travel, Long> {

    List<Travel> findByDestinationCityContainingIgnoreCase(String destinationCity);

    @Query("SELECT DISTINCT t.destinationCity FROM Travel t")
    List<String> findAllDistinctDestinationCity();



    @Query("SELECT t FROM Travel t WHERE "
            + "(:destination IS NULL OR t.destinationCity = :destination) "
            + "AND (:startDate IS NULL OR t.startDate >= :startDate) "
            + "AND (:endDate IS NULL OR t.endDate <= :endDate) "
            + "AND (:type IS NULL OR TYPE(t) = :type) ")
    Page<Travel> searchTravels(
            @Param("destination") String destination,
            @Param("startDate") LocalDate startDate,
            @Param("endDate") LocalDate endDate,
            @Param("type") Class<? extends Travel> type,
            Pageable pageable);

}
