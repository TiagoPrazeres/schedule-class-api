package com.valdir.todo.configuration;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.valdir.todo.services.DBService;

@Configuration
@Profile("test")
public class TestConfig {
	
	@Autowired
	private DBService dbService;
	
	@Bean
	public boolean instancia() throws ParseException {
		this.dbService.instanciaBaseDeDados();
		return true;
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
			return new WebMvcConfigurer() {
					@Override
					public void addCorsMappings(CorsRegistry registry) {
							registry.addMapping("/**").allowedOrigins("*").allowedMethods("GET", "POST","PUT", "DELETE");
					}
			};
	}

}
