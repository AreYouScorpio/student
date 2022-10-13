package hu.webuni.student.config;

import hu.webuni.student.service.DefaultDiscountService;
import hu.webuni.student.service.DiscountService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("!prod")
public class DiscountConfiguration {


	@Bean
	public DiscountService discountService() {
		return new DefaultDiscountService();
	}



}
