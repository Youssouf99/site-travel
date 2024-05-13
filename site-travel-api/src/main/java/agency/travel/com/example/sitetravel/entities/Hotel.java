package agency.travel.com.example.sitetravel.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@DiscriminatorValue("HOTEL")
public class Hotel extends HotelActivity{
}
