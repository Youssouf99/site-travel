package agency.travel.com.example.sitetravel.services.travel;

import agency.travel.com.example.sitetravel.dtos.FlightDto;

import java.util.List;

public interface FlightService {
    List<FlightDto> getAllFlights();

    FlightDto getFlightById(Long id);

    FlightDto createFlight(FlightDto flightDto);

    FlightDto updateFlight(Long id, FlightDto flightDto);

    void deleteFlight(Long id);
}
