package agency.travel.com.example.sitetravel.entities;

import agency.travel.com.example.sitetravel.enums.Stays;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class HotelActivity extends Travel{
    private Stays type;
    private String address;
    private String city;

}
