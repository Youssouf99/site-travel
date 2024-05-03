package agency.travel.com.example.sitetravel;

import agency.travel.com.example.sitetravel.config.ExceptionHandlerAdvice;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@Import({ExceptionHandlerAdvice.class})
public class SiteTravelApplication {

    public static void main(String[] args) {
        SpringApplication.run(SiteTravelApplication.class, args);
    }

}
