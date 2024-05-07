package agency.travel.com.example.sitetravel.mappers;


import agency.travel.com.example.sitetravel.dtos.*;
import agency.travel.com.example.sitetravel.entities.*;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;


@Mapper(componentModel = "spring")
public interface TravelMapper {
    TravelMapper INSTANCE = Mappers.getMapper(TravelMapper.class);

    FlightDto toFlightDto(Flight flight);
    @Mapping(target = "reservations", ignore = true)
    Flight toFlight(FlightDto flightDto);


    List<FlightDto> toFlightDtos(List<Flight> flights);

    List<Flight> toFlights(List<FlightDto> flightDTOs);


    ActivityDto toActivityDto(Activity activity);

    @Mapping(target = "reservations", ignore = true)
    Activity toActivity(ActivityDto activityDto);

    List<ActivityDto> toActivityDtos(List<Activity> activities);

    List<Activity> toActivities(List<ActivityDto> activityDTOs);


    @Mapping(target = "reservations", ignore = true)
    @Mapping(target = "id", ignore = true)
    void updateActivityFromActivityDto(ActivityDto activityDTO, @MappingTarget Activity activity);


    HotelDto toHotelDto(Hotel hotel);

    @Mapping(target = "reservations", ignore = true)
    Hotel toHotel(HotelDto hotelDto);

    List<HotelDto> toHotelDtos(List<Hotel> hotels);

    @Mapping(target = "reservations", ignore = true)
    @Mapping(target = "id", ignore = true)
    void updateHotelFromHotelDto(HotelDto hotelDTO, @MappingTarget Hotel hotel);


    List<TravelDto> toTravelDtos(List<Travel> travels);

    TravelDto toTravelDto(Travel travel);

    @Mapping(target = "travelType", expression = "java(travel.getClass().getSimpleName())")
    @Mapping(expression = "java(travel instanceof Flight ? ((Flight) travel).getDepartureCity() : null)", target = "departureCity")
    @Mapping(expression = "java(travel instanceof Flight ? ((Flight) travel).getArrivalCity() : null)", target = "arrivalCity")
    @Mapping(expression = "java(travel instanceof Hotel ? ((Hotel) travel).getAddress() : travel instanceof Activity ? ((Activity) travel).getAddress() : null)", target = "address")
    @Mapping(expression = "java(travel instanceof Hotel ? ((Hotel) travel).getCity() : travel instanceof Activity ? ((Activity) travel).getCity() : null)", target = "city")
//    @Mapping(expression = "java(travel instanceof Hotel || travel instanceof Activity ? ((HotelActivity) travel).getCity() : null)", target = "city")
    TravelDetailDto toTravelDetailDto(Travel travel);


}
