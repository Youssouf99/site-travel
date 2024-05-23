package agency.travel.com.example.sitetravel.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@AllArgsConstructor
@EqualsAndHashCode(callSuper=false)
public class ActivityDto extends TravelDto {
    private String activityType;
    private int durationHours;
}
