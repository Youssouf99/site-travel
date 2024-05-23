package agency.travel.com.example.sitetravel.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.*;

@Entity
@Getter
@Setter
@DiscriminatorValue("HOTEL")
public class Hotel extends Travel{
    private String hotelName;
    private int availableOfRooms;


}
