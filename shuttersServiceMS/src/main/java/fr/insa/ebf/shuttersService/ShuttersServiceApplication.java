package fr.insa.ebf.shuttersService;

import java.util.Arrays;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import fr.insa.ebf.shuttersService.model.*;

@SpringBootApplication
public class ShuttersServiceApplication {
	@Bean 
	public List <shutters> init(){
		List <shutters> initList=Arrays.asList(
				new shutters(1),
				new shutters(2),
				new shutters(3),
				new shutters(4)
				);
		return initList;
	}
	public static void main(String[] args) {
		SpringApplication.run(ShuttersServiceApplication.class, args);
	}

}
