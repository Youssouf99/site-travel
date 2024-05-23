package agency.travel.com.example.sitetravel.mappers;


import agency.travel.com.example.sitetravel.dtos.HotelDto;
import agency.travel.com.example.sitetravel.entities.Hotel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.List;


@Mapper(componentModel = "spring")
public interface HotelMapper {

    HotelMapper INSTANCE = Mappers.getMapper(HotelMapper.class);

    HotelDto toHotelDto(Hotel hotel);

    @Mapping(target = "reservations", ignore = true)
    Hotel toHotel(HotelDto hotelDto);

    List<HotelDto> toHotelDtos(List<Hotel> hotels);

    @Mapping(target = "reservations", ignore = true)
    @Mapping(target = "id", ignore = true)
    void updateHotelFromHotelDto(HotelDto hotelDTO, @MappingTarget Hotel hotel);



}
