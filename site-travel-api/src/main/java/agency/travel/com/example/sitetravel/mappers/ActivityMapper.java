package agency.travel.com.example.sitetravel.mappers;

import agency.travel.com.example.sitetravel.dtos.ActivityDto;
import agency.travel.com.example.sitetravel.entities.Activity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ActivityMapper {

    ActivityMapper INSTANCE = Mappers.getMapper(ActivityMapper.class);


    ActivityDto toActivityDto(Activity activity);

    @Mapping(target = "reservations", ignore = true)
    Activity toActivity(ActivityDto activityDto);

    List<ActivityDto> toActivityDtos(List<Activity> activities);

    List<Activity> toActivities(List<ActivityDto> activityDTOs);
    @Mapping(target = "reservations", ignore = true)
    @Mapping(target = "id", ignore = true)
    void updateActivityFromActivityDto(ActivityDto activityDTO, @MappingTarget Activity activity);

}
