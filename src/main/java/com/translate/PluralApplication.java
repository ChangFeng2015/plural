package com.translate;

import com.didispace.swagger.EnableSwagger2Doc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableSwagger2Doc
@SpringBootApplication
public class PluralApplication {

	public static void main(String[] args) {
		SpringApplication.run(PluralApplication.class, args);
	}
}
