package agency.travel.com.example.sitetravel.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.*;

@Entity
@DiscriminatorValue("FLIGHT")
@Getter
@Setter
@EqualsAndHashCode(callSuper=false)
public class Flight extends Travel {
    private String departureCity;
    private String airline;
    private String flightNumber;


}
