package agency.travel.com.example.sitetravel.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private double amount;

        @Column(nullable = false)
        private LocalDateTime paymentDateTime;

        @Column(nullable = false, length = 16)
        private String cardNumber;

        @Column(nullable = false, length = 7)
        private String cardExpiry;

        @Column(nullable = false, length = 4)
        private String cardCvvSecret;

        @ManyToOne
        @JoinColumn(nullable = false)
        private Reservation reservation;


}
