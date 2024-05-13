package agency.travel.com.example.sitetravel.mappers;

import agency.travel.com.example.sitetravel.dtos.*;
import agency.travel.com.example.sitetravel.entities.*;
import agency.travel.com.example.sitetravel.services.travel.TravelService;
import agency.travel.com.example.sitetravel.services.user.UserService;
import jakarta.persistence.Converter;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring")
public interface ReservationMapper {
    ReservationMapper INSTANCE = Mappers.getMapper(ReservationMapper.class);


    @Mapping(source = "user.id", target = "userId")
    ReservationDto toReservationDto(Reservation reservation);

    @Mapping(source = "userId", target = "user.id")
    @Mapping(target = "travels", ignore = true)
    Reservation toReservation(ReservationDto reservationDto);



}
