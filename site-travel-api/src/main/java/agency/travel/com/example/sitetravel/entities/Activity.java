package agency.travel.com.example.sitetravel.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
@Entity
@DiscriminatorValue("ACTIVITY")
public class Activity extends HotelActivity{
}
