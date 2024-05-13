package agency.travel.com.example.sitetravel.dtos;

import lombok.Data;

import java.time.LocalDate;

@Data
public class TravelDetailDto {

    private Long id;
    private String name;
    private String description;
    private LocalDate startDate;
    private LocalDate endDate;
    private double price;
    private String address;
    private String city;
    private String departureCity;
    private String arrivalCity;
    private String travelType;


}
