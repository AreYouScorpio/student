package hu.webuni.student.config;

import hu.webuni.student.service.DiscountService;
import hu.webuni.student.service.SpecialDiscountService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("prod")
public class ProdDiscountConfiguration {


    @Bean
    public DiscountService discountService() {
        return new SpecialDiscountService();
    }


}
