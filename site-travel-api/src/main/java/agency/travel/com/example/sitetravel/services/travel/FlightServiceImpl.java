package agency.travel.com.example.sitetravel.services.travel;

import agency.travel.com.example.sitetravel.dtos.FlightDto;
import agency.travel.com.example.sitetravel.entities.Flight;
import agency.travel.com.example.sitetravel.exceptions.NotFoundException;
import agency.travel.com.example.sitetravel.mappers.FlightMapper;
import agency.travel.com.example.sitetravel.repositories.FlightRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlightServiceImpl implements FlightService{

    private final FlightRepository flightRepository;
    private final FlightMapper flightMapper;

    public FlightServiceImpl(FlightRepository flightRepository, FlightMapper flightMapper) {
        this.flightRepository = flightRepository;
        this.flightMapper = flightMapper;
    }

    @Override
    public List<FlightDto> getAllFlights() {
        List<Flight> flights = flightRepository.findAll();
        return flightMapper.toFlightDtos(flights);
    }

    @Override
    public FlightDto getFlightById(Long id) {
        return flightMapper.toFlightDto(flightRepository.findById(id).orElseThrow(() -> new NotFoundException("Flight not found")));
    }

    @Override
    public FlightDto createFlight(FlightDto flightDto) {
        Flight flight = flightMapper.toFlight(flightDto);
        flight = flightRepository.save(flight);
        return flightMapper.toFlightDto(flight);
    }
    @Override
    public FlightDto updateFlight(Long id, FlightDto flightDto) {
        Flight existingFlight = flightRepository.findById(id).orElseThrow(() -> new NotFoundException("Flight not found"));
        Flight updatedFlight = flightMapper.toFlight(flightDto);
        updatedFlight.setId(existingFlight.getId());
        flightRepository.save(updatedFlight);
        return flightMapper.toFlightDto(updatedFlight);
    }

    @Override
    public void deleteFlight(Long id) {
        flightRepository.deleteById(id);
    }




}
