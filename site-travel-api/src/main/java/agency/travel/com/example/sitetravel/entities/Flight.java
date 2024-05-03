package agency.travel.com.example.sitetravel.entities;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
public class Flight extends Travel {
    private String departureCity;
    private String arrivalCity;


}
