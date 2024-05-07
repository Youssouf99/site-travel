package agency.travel.com.example.sitetravel.services.travel;

import agency.travel.com.example.sitetravel.dtos.ActivityDto;

import java.util.List;

public interface ActivityService {
    List<ActivityDto> getAllActivities();

    ActivityDto getActivityById(Long id);

    ActivityDto createActivity(ActivityDto activityDto);

    ActivityDto updateActivity(Long id, ActivityDto activityDTO);

    void deleteActivity(Long id);
}
