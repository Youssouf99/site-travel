package agency.travel.com.example.sitetravel.mappers;

import agency.travel.com.example.sitetravel.dtos.*;
import agency.travel.com.example.sitetravel.entities.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ReservationMapper {
    ReservationMapper INSTANCE = Mappers.getMapper(ReservationMapper.class);

    @Mapping(source = "user.id", target = "userId")
    @Mapping(source = "travel.id", target = "travelId")
    ReservationDto toReservationDto(Reservation reservation);



}
