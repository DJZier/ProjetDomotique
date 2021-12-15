package fr.insa.ebf.WindowInfo;

import java.util.Arrays;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import fr.insa.ebf.WindowInfo.model.Window;


@SpringBootApplication
public class WindowInfoApplication {
	
	@Bean 
	public List <Window> init(){
		List <Window> initList=Arrays.asList(
				new Window(1),
				new Window(2),
				new Window(3),
				new Window(4)
				);
		return initList;
	}

	public static void main(String[] args) {
		SpringApplication.run(WindowInfoApplication.class, args);
	}

}
