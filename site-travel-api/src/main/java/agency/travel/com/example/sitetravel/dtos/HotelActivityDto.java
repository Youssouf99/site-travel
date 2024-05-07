package agency.travel.com.example.sitetravel.dtos;

import agency.travel.com.example.sitetravel.enums.Stay;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper=false)
public class HotelActivityDto extends TravelDto {
    private String address;
    private String city;

}
