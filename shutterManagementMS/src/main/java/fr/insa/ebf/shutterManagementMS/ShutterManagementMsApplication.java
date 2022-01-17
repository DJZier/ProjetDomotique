package fr.insa.ebf.shutterManagementMS;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import fr.insa.ebf.shutterManagementMS.model.Shutter;

@SpringBootApplication
public class ShutterManagementMsApplication {
	@Bean
	public Shutter init() {
		Shutter shutters = new Shutter(false); 
		return shutters; 
	}
	public static void main(String[] args) {
		SpringApplication.run(ShutterManagementMsApplication.class, args);
	}

}
