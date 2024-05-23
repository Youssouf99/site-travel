package agency.travel.com.example.sitetravel.mappers;


import agency.travel.com.example.sitetravel.dtos.*;
import agency.travel.com.example.sitetravel.entities.*;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;


@Mapper(componentModel = "spring")
public interface TravelMapper {
   TravelMapper INSTANCE = Mappers.getMapper(TravelMapper.class);

    TravelDto toTravelDto(Travel travel);

    List<TravelDto> toTravelDtos(List<Travel> travels);




}
