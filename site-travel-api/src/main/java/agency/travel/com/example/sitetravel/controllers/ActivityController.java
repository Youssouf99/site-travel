package agency.travel.com.example.sitetravel.controllers;

import agency.travel.com.example.sitetravel.dtos.ActivityDto;
import agency.travel.com.example.sitetravel.services.travel.ActivityService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/activities")
public class ActivityController {

    private final ActivityService activityService;

    public ActivityController(ActivityService activityService) {
        this.activityService = activityService;
    }


    @GetMapping
    public ResponseEntity<List<ActivityDto>> getAllActivities() {
        List<ActivityDto> activities = activityService.getAllActivities();
        return new ResponseEntity<>(activities, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ActivityDto> getActivityById(@PathVariable Long id) {
        ActivityDto activity = activityService.getActivityById(id);
        return new ResponseEntity<>(activity, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ActivityDto> createActivity(@RequestBody ActivityDto activityDto) {
        ActivityDto createdActivity = activityService.createActivity(activityDto);
        return new ResponseEntity<>(createdActivity, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ActivityDto> updateActivity(@PathVariable Long id, @RequestBody ActivityDto activityDto) {
        ActivityDto updatedActivity = activityService.updateActivity(id, activityDto);
        return new ResponseEntity<>(updatedActivity, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteActivity(@PathVariable Long id) {
        activityService.deleteActivity(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
