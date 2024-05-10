package agency.travel.com.example.sitetravel.dtos;

import agency.travel.com.example.sitetravel.entities.Travel;
import agency.travel.com.example.sitetravel.entities.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReservationDto {
    private Long id;
    private double priceTotal;
    private Date date;
    private Long userId;


}
