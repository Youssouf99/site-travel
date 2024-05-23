package agency.travel.com.example.sitetravel.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentDto {
    private Long id;
    private double amount;
    private LocalDateTime paymentDateTime;
    private String cardNumber;
    private String cardExpiry;
    private int cardCvvSecret;
    private Long reservationId;
}
