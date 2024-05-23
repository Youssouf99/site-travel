package agency.travel.com.example.sitetravel.mappers;

import agency.travel.com.example.sitetravel.dtos.FlightDto;
import agency.travel.com.example.sitetravel.entities.Flight;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;


@Mapper(componentModel = "spring")
public interface FlightMapper {
    FlightMapper INSTANCE = Mappers.getMapper(FlightMapper.class);

    FlightDto toFlightDto(Flight flight);
    @Mapping(target = "reservations", ignore = true)
    Flight toFlight(FlightDto flightDto);

    List<FlightDto> toFlightDtos(List<Flight> flights);

    List<Flight> toFlights(List<FlightDto> flightDTOs);
}
