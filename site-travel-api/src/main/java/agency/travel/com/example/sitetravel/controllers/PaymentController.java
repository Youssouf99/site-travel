package agency.travel.com.example.sitetravel.controllers;

import agency.travel.com.example.sitetravel.dtos.PaymentDto;
import agency.travel.com.example.sitetravel.dtos.RequestPaymentDto;
import agency.travel.com.example.sitetravel.services.payment.PaymentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/payments")
public class PaymentController {

    public final PaymentService paymentService;


    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping
    public ResponseEntity<PaymentDto> createPayment(@RequestParam Long idReservation,
                                                    @RequestParam(required = false) Double amount,
                                                    @RequestBody RequestPaymentDto requestPaymentDto) {
        PaymentDto paymentDto = paymentService.savePayment(idReservation, amount, requestPaymentDto);

        return new ResponseEntity<>(paymentDto, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<PaymentDto>> getAllPayments() {
        List<PaymentDto> paymentDtos = paymentService.getAllPayments();
        return new ResponseEntity<>(paymentDtos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PaymentDto> getPaymentById(@PathVariable("id") Long id) {
        PaymentDto paymentDto = paymentService.getPaymentById(id);
        return new ResponseEntity<>(paymentDto, HttpStatus.OK);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePayment(@PathVariable("id") Long id) {
        paymentService.deletePaymentById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
