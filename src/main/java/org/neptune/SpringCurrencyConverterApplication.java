package org.neptune;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"org.neptune"} )
public class SpringCurrencyConverterApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCurrencyConverterApplication.class, args);
	}
}
