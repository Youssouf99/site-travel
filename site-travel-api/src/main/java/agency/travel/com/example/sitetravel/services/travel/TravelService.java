package agency.travel.com.example.sitetravel.services.travel;

import agency.travel.com.example.sitetravel.dtos.*;
import agency.travel.com.example.sitetravel.entities.Activity;
import agency.travel.com.example.sitetravel.entities.Flight;
import agency.travel.com.example.sitetravel.entities.Hotel;

import java.time.LocalDate;
import java.util.List;

public interface TravelService {
    List<TravelDetailDto> getAllTravels();

    void delete(Long id);
}
