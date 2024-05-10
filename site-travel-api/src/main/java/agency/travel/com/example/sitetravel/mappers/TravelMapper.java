package agency.travel.com.example.sitetravel.mappers;


import agency.travel.com.example.sitetravel.dtos.*;
import agency.travel.com.example.sitetravel.entities.*;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;


@Mapper(componentModel = "spring")
public interface TravelMapper {
    //TravelMapper INSTANCE = Mappers.getMapper(TravelMapper.class);

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

/*    default TravelDto toTravelDto(Travel travel) {
        if (travel == null) {
            return null;
        }
        if (travel instanceof Flight) {
            Flight flight = (Flight) travel;
            FlightDto flightDto = new FlightDto();
            flightDto.setId(flight.getId());
            flightDto.setName(flight.getName());
            flightDto.setDescription(flight.getDescription());
            flightDto.setStartDate(flight.getStartDate());
            flightDto.setEndDate(flight.getEndDate());
            flightDto.setPrice(flight.getPrice());
            flightDto.setDepartureCity(flight.getDepartureCity());
            flightDto.setArrivalCity(flight.getArrivalCity());
            return flightDto;
        } else if (travel instanceof Hotel) {
            Hotel hotel = (Hotel) travel;
            HotelDto hotelDto = new HotelDto();
            hotelDto.setId(hotel.getId());
            hotelDto.setName(hotel.getName());
            hotelDto.setDescription(hotel.getDescription());
            hotelDto.setStartDate(hotel.getStartDate());
            hotelDto.setEndDate(hotel.getEndDate());
            hotelDto.setPrice(hotel.getPrice());
            hotelDto.setAddress(hotel.getAddress());
            hotelDto.setCity(hotel.getCity());
            return hotelDto;
        } else if (travel instanceof Activity) {
            Activity activity = (Activity) travel;
            ActivityDto activityDto = new ActivityDto();
            activityDto.setId(activity.getId());
            activityDto.setName(activity.getName());
            activityDto.setDescription(activity.getDescription());
            activityDto.setStartDate(activity.getStartDate());
            activityDto.setEndDate(activity.getEndDate());
            activityDto.setPrice(activity.getPrice());
            return activityDto;
        }
        return null;
    }

        default Travel toTravel(TravelDto travelDto) {
        if (travelDto == null) {
            return null;
        }
        if (travelDto instanceof FlightDto) {
            FlightDto flightDto = (FlightDto) travelDto;
            Flight flight = new Flight();
            flight.setId(flightDto.getId());
            flight.setName(flightDto.getName());
            flight.setDescription(flightDto.getDescription());
            flight.setStartDate(flightDto.getStartDate());
            flight.setEndDate(flightDto.getEndDate());
            flight.setPrice(flightDto.getPrice());
            flight.setDepartureCity(flightDto.getDepartureCity());
            flight.setArrivalCity(flightDto.getArrivalCity());
            return flight;
        } else if (travelDto instanceof HotelDto) {
            HotelDto hotelDto = (HotelDto) travelDto;
            Hotel hotel = new Hotel();
            hotel.setId(hotelDto.getId());
            hotel.setName(hotelDto.getName());
            hotel.setDescription(hotelDto.getDescription());
            hotel.setStartDate(hotelDto.getStartDate());
            hotel.setEndDate(hotelDto.getEndDate());
            hotel.setPrice(hotelDto.getPrice());
            hotel.setAddress(hotelDto.getAddress());
            hotel.setCity(hotelDto.getCity());
            return hotel;
        } else if (travelDto instanceof ActivityDto) {
            ActivityDto activityDto = (ActivityDto) travelDto;
            Activity activity = new Activity();
            activity.setId(activityDto.getId());
            activity.setName(activityDto.getName());
            activity.setDescription(activityDto.getDescription());
            activity.setStartDate(activityDto.getStartDate());
            activity.setEndDate(activityDto.getEndDate());
            activity.setPrice(activityDto.getPrice());
            return activity;
        }
        return null;
    }

    */



}
