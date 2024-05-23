package agency.travel.com.example.sitetravel.repositories;

import agency.travel.com.example.sitetravel.entities.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
