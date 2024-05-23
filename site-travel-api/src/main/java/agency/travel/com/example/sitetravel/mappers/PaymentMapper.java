package agency.travel.com.example.sitetravel.mappers;

import agency.travel.com.example.sitetravel.dtos.PaymentDto;
import agency.travel.com.example.sitetravel.dtos.RequestPaymentDto;
import agency.travel.com.example.sitetravel.entities.Payment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface PaymentMapper {
    PaymentMapper INSTANCE = Mappers.getMapper(PaymentMapper.class);

    @Mapping(source = "reservation.id", target = "reservationId")
    PaymentDto toPaymentDTO(Payment payment);

    @Mapping(target = "reservation", ignore = true)
    Payment toPayment(PaymentDto paymentDto);


    @Mapping(target = "id", ignore = true)
    @Mapping(target = "paymentDateTime", ignore = true)
    @Mapping(target = "amount", ignore = true)
    @Mapping(target = "reservation", ignore = true)
    Payment toPayment(RequestPaymentDto requestPaymentDto);


}
