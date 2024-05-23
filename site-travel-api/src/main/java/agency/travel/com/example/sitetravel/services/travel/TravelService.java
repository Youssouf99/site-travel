package agency.travel.com.example.sitetravel.services.travel;

import agency.travel.com.example.sitetravel.dtos.*;

import agency.travel.com.example.sitetravel.entities.Activity;
import agency.travel.com.example.sitetravel.entities.Flight;
import agency.travel.com.example.sitetravel.entities.Hotel;
import agency.travel.com.example.sitetravel.entities.Travel;
import org.springframework.data.domain.Page;

import java.time.LocalDate;
import java.util.List;

public interface TravelService {

    List<TravelDto> searchTravelsByDestination(String destinationCity);

    List<String> getAllDestinationCities();

    List<String> getAllDeparturesCities();

    void delete(Long id);



    Page<Travel> searchTravels(String destination, LocalDate startDate, LocalDate endDate, String type, String sortField, int page, int size);

    Page<Activity> searchActivities(String destination, LocalDate startDate,
                                    LocalDate endDate, String sortField, int page, int size);

    Page<Hotel> searchHotels(String destination, LocalDate startDate, LocalDate endDate,
                             String sortField, int page, int size);

    Page<Flight> searchFlights(String destination, LocalDate startDate, LocalDate endDate,
                               String departureCity, String sortField, int page, int size);
}
