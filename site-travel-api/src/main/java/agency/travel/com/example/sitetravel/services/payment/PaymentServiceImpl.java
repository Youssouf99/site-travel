package agency.travel.com.example.sitetravel.services.payment;

import agency.travel.com.example.sitetravel.dtos.PaymentDto;
import agency.travel.com.example.sitetravel.dtos.RequestPaymentDto;
import agency.travel.com.example.sitetravel.entities.Payment;
import agency.travel.com.example.sitetravel.entities.Reservation;
import agency.travel.com.example.sitetravel.exceptions.NotFoundException;
import agency.travel.com.example.sitetravel.mappers.PaymentMapper;
import agency.travel.com.example.sitetravel.repositories.PaymentRepository;
import agency.travel.com.example.sitetravel.repositories.ReservationRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service

public class PaymentServiceImpl implements PaymentService{

    private final PaymentRepository paymentRepository;
    private final PaymentMapper paymentMapper;
    private final ReservationRepository reservationRepository;

    public PaymentServiceImpl(PaymentRepository paymentRepository, PaymentMapper paymentMapper, ReservationRepository reservationRepository) {
        this.paymentRepository = paymentRepository;
        this.paymentMapper = paymentMapper;
        this.reservationRepository = reservationRepository;
    }

    @Override
    public PaymentDto savePayment(Long idReservation, Double amount, RequestPaymentDto requestPaymentDto) {
        Reservation reservation = reservationRepository.findById(idReservation)
                .orElseThrow(() -> new NotFoundException("Reservation Not Found"));

        Payment payment = paymentMapper.toPayment(requestPaymentDto);
        payment.setAmount((amount != null) ? amount : reservation.getPriceTotal());
        payment.setReservation(reservation);
        payment.setPaymentDateTime(LocalDateTime.now());
        return paymentMapper.toPaymentDTO(paymentRepository.save(payment));
    }

    @Override
    public List<PaymentDto> getAllPayments() {
        List<Payment> payments = paymentRepository.findAll();
        return payments.stream().map(paymentMapper::toPaymentDTO)
                .collect(Collectors.toList());

    }
    @Override
    public PaymentDto getPaymentById(Long id){
        Payment payment = paymentRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Payment Not Found"));
        return paymentMapper.toPaymentDTO(payment);
    }

    @Override
    public void deletePaymentById(Long id){
        if (reservationRepository.existsById(id)){
            throw new NotFoundException("Payment Not Found");
        }
        paymentRepository.deleteById(id);
    }


}
