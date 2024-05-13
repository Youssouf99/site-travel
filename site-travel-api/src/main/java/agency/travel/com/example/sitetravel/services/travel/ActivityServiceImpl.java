package agency.travel.com.example.sitetravel.services.travel;

import agency.travel.com.example.sitetravel.dtos.ActivityDto;
import agency.travel.com.example.sitetravel.entities.Activity;
import agency.travel.com.example.sitetravel.exceptions.NotFoundException;
import agency.travel.com.example.sitetravel.mappers.TravelMapper;
import agency.travel.com.example.sitetravel.repositories.ActivityRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActivityServiceImpl implements ActivityService {


    private final ActivityRepository activityRepository;
    private final TravelMapper travelMapper;

    public ActivityServiceImpl(ActivityRepository activityRepository, TravelMapper travelMapper) {
        this.activityRepository = activityRepository;
        this.travelMapper = travelMapper;
    }


    @Override
    public List<ActivityDto> getAllActivities() {
        List<Activity> activities = activityRepository.findAll();
        return travelMapper.toActivityDtos(activities);
    }

    @Override
    public ActivityDto getActivityById(Long id) {
        Activity activity = activityRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Activity not found with id: " + id));
        return travelMapper.toActivityDto(activity);
    }

    @Override
    public ActivityDto createActivity(ActivityDto activityDto) {
        Activity activity = travelMapper.toActivity(activityDto);
        activity = activityRepository.save(activity);
        return travelMapper.toActivityDto(activity);
    }

    @Override
    public ActivityDto updateActivity(Long id, ActivityDto activityDTO) {
        Activity activity = activityRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Activity not found with id: " + id));
        travelMapper.updateActivityFromActivityDto(activityDTO, activity);

        activityRepository.save(activity);
        return travelMapper.toActivityDto(activity);
    }

    @Override
    public void deleteActivity(Long id) {
        Activity activity = activityRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Activity not found with id: " + id));
        activityRepository.delete(activity);    }


}
