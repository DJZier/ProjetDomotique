package fr.insa.ebf.sensorTemperatureService.resource;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.*;

import fr.insa.ebf.sensorTemperatureService.model.temperature;

@RestController
@RequestMapping("/temperature")
public class sensorTemperatureResource {
	List<temperature> tempList=Arrays.asList(
			 new temperature("Inside",27F),
			 new temperature("Outside",21F)
			 );		
	
	@RequestMapping("/tempInt")
	 public float getTemperatureInterior() {		 
		 return tempList.get(0).getTemp();
	 }
	
	@RequestMapping("/tempExt")
	 public float getTemperatureExterior() {		 
		 return tempList.get(1).getTemp();
	 }
}
