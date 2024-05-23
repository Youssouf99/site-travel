package agency.travel.com.example.sitetravel.services.payment;

import agency.travel.com.example.sitetravel.dtos.PaymentDto;
import agency.travel.com.example.sitetravel.dtos.RequestPaymentDto;

import java.util.List;

public interface PaymentService {

    PaymentDto savePayment(Long idReservation, Double amount, RequestPaymentDto requestPaymentDto);

    List<PaymentDto> getAllPayments();

    PaymentDto getPaymentById(Long id);

    void deletePaymentById(Long id);
}
