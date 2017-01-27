package br.com.tamagu.resvut42x;

import java.util.Locale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.i18n.FixedLocaleResolver;

@SpringBootApplication
public class ResVut42xApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(ResVut42xApplication.class, args);
	}
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(ResVut42xApplication.class);
	}
	
	@Bean
	public FixedLocaleResolver localResolver() {
		return new FixedLocaleResolver(new Locale("pt", "BR"));
	}	
}
