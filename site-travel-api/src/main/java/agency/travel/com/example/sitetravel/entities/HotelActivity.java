package agency.travel.com.example.sitetravel.entities;

import agency.travel.com.example.sitetravel.enums.Stay;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper=false) //indiquer à Lombok de générer les méthodes equals/hashCode sans inclure les champs hérités.
public abstract class HotelActivity extends Travel{
    private String address;
    private String city;

}
