package agency.travel.com.example.sitetravel.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="travel_type", discriminatorType = DiscriminatorType.STRING)
@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class Travel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    @Column(columnDefinition = "DATE")
    private LocalDate startDate;
    @Column(columnDefinition = "DATE")
    private LocalDate endDate;
    private double price;
    @OneToMany(mappedBy = "travel")
    private List<Reservation> reservations = new ArrayList<>();

}
