package agency.travel.com.example.sitetravel.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestPaymentDto {
    private String cardNumber;
    private String cardExpiry;
    private int cardCvvSecret;

}
