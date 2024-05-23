package agency.travel.com.example.sitetravel.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@AllArgsConstructor
@EqualsAndHashCode(callSuper=false)
public class HotelDto extends TravelDto{
    private String hotelName;
    private int availableOfRooms;
}
