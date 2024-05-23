package agency.travel.com.example.sitetravel.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@DiscriminatorValue("ACTIVITY")
public class Activity extends Travel{
    private String activityType;
    private int durationHours;

}
