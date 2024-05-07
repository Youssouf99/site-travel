package agency.travel.com.example.sitetravel.services.travel;

import agency.travel.com.example.sitetravel.dtos.FlightDto;
import agency.travel.com.example.sitetravel.entities.Flight;
import agency.travel.com.example.sitetravel.exceptions.NotFoundException;
import agency.travel.com.example.sitetravel.mappers.TravelMapper;
import agency.travel.com.example.sitetravel.repositories.FlightRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlightServiceImpl implements FlightService{

    private final FlightRepository flightRepository;
    private final TravelMapper travelMapper;

    public FlightServiceImpl(FlightRepository flightRepository, TravelMapper travelMapper) {
        this.flightRepository = flightRepository;
        this.travelMapper = travelMapper;
    }

    @Override
    public List<FlightDto> getAllFlights() {
        List<Flight> flights = flightRepository.findAll();
        return travelMapper.toFlightDtos(flights);
    }

    @Override
    public FlightDto getFlightById(Long id) {
        return travelMapper.toFlightDto(flightRepository.findById(id).orElseThrow(() -> new NotFoundException("Flight not found")));
    }

    @Override
    public FlightDto createFlight(FlightDto flightDto) {
        Flight flight = travelMapper.toFlight(flightDto);
        flight = flightRepository.save(flight);
        return travelMapper.toFlightDto(flight);
    }
    @Override
    public FlightDto updateFlight(Long id, FlightDto flightDto) {
        Flight existingFlight = flightRepository.findById(id).orElseThrow(() -> new NotFoundException("Flight not found"));
        Flight updatedFlight = travelMapper.toFlight(flightDto);
        updatedFlight.setId(existingFlight.getId());
        flightRepository.save(updatedFlight);
        return travelMapper.toFlightDto(updatedFlight);
    }

    @Override
    public void deleteFlight(Long id) {
        flightRepository.deleteById(id);
    }




}
