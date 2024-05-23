package agency.travel.com.example.sitetravel.dtos;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TravelDto {
    private Long id;
    private String name;
    private String description;
    @Column(columnDefinition = "DATE")
    private LocalDate startDate;
    @Column(columnDefinition = "DATE")
    private LocalDate endDate;
    private double price;
    private String imageUrl;
    private int numberOfStars;
    private String destinationCity;
    private String address;



}
