package agency.travel.com.example.sitetravel.services.travel;


import agency.travel.com.example.sitetravel.dtos.TravelDto;
import agency.travel.com.example.sitetravel.entities.Activity;
import agency.travel.com.example.sitetravel.entities.Flight;
import agency.travel.com.example.sitetravel.entities.Hotel;
import agency.travel.com.example.sitetravel.entities.Travel;
import agency.travel.com.example.sitetravel.exceptions.NotFoundException;
import agency.travel.com.example.sitetravel.mappers.TravelMapper;
import agency.travel.com.example.sitetravel.repositories.ActivityRepository;
import agency.travel.com.example.sitetravel.repositories.FlightRepository;
import agency.travel.com.example.sitetravel.repositories.HotelRepository;
import agency.travel.com.example.sitetravel.repositories.TravelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;


@Service
public class TravelServiceImpl implements TravelService {
    private final TravelRepository travelRepository;
    private final ActivityRepository activityRepository;
    private final FlightRepository flightRepository;
    private final HotelRepository hotelRepository;
    private final TravelMapper travelMapper;

    @Autowired
    public TravelServiceImpl(TravelRepository travelRepository, ActivityRepository activityRepository, FlightRepository flightRepository, HotelRepository hotelRepository, TravelMapper travelMapper) {
        this.travelRepository = travelRepository;
        this.activityRepository = activityRepository;
        this.flightRepository = flightRepository;
        this.hotelRepository = hotelRepository;
        this.travelMapper = travelMapper;
    }

    private Sort getSortByStartDateOrPrice(String sortField) {
        if (sortField == null) {
            return Sort.by("price").ascending(); // Default sort
        }

        return switch (sortField) {
            case "price_desc" -> Sort.by("price").descending();
            case "date_asc" -> Sort.by("startDate").ascending();
            case "date_desc" -> Sort.by("startDate").descending();
            default -> Sort.by("price").ascending(); // Default sort
        };
    }



    @Override
    public List<TravelDto> searchTravelsByDestination(String destinationCity) {
        List<Travel> travels = travelRepository.findByDestinationCityContainingIgnoreCase(destinationCity);
        return travelMapper.toTravelDtos(travels);
    }


    @Override
    public List<String> getAllDestinationCities() {
        return travelRepository.findAllDistinctDestinationCity();
    }

    @Override
    public List<String> getAllDeparturesCities() {
        return flightRepository.findAllDistinctDepartureCity();
    }


    @Override
    public void delete(Long id) {
        travelRepository.deleteById(id);
    }



    @Override
    public Page<Travel> searchTravels(String destination, LocalDate startDate, LocalDate endDate, String type, String sortField, int page, int size) {
        Class<? extends Travel> typeClass = null;
        if (type != null) {
            typeClass = switch (type.toUpperCase()) {
                case "HOTEL" -> Hotel.class;
                case "FLIGHT" -> Flight.class;
                case "ACTIVITY" -> Activity.class;
                default -> throw new NotFoundException("Travel Not Found with type : " + type);
            };
        }
        Sort sort = getSortByStartDateOrPrice(sortField);
        Pageable pageable = PageRequest.of(page, size, sort);

        return travelRepository.searchTravels(destination, startDate, endDate, typeClass, pageable);
    }


    @Override
    public Page<Activity> searchActivities(String destination, LocalDate startDate,
                                           LocalDate endDate, String sortField, int page, int size) {
        Sort sort = getSortByStartDateOrPrice(sortField);
        Pageable pageable = PageRequest.of(page, size, sort);

        return activityRepository.searchActivities(destination, startDate, endDate, pageable);
    }

    @Override
    public Page<Hotel> searchHotels(String destination, LocalDate startDate, LocalDate endDate,
                                    String sortField, int page, int size) {
        Sort sort = getSortByStartDateOrPrice(sortField);

        Pageable pageable = PageRequest.of(page, size, sort);

        return hotelRepository.searchHotels(destination, startDate, endDate , pageable);
    }


    @Override
    public Page<Flight> searchFlights(String destination, LocalDate startDate, LocalDate endDate,
                                      String departureCity, String sortField, int page, int size) {
        Sort sort = getSortByStartDateOrPrice(sortField);
        Pageable pageable = PageRequest.of(page, size, sort);
        return flightRepository.searchFlights(destination, startDate, endDate, departureCity, pageable);
    }



}
