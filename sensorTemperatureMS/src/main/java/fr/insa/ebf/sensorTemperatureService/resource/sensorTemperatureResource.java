package fr.insa.ebf.sensorTemperatureService.resource;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.*;

import fr.insa.ebf.sensorTemperatureService.model.temperature;

@RestController
@RequestMapping("/temperature")
public class sensorTemperatureResource {
	List<temperature> tempList=Arrays.asList( // LIST FOR TESTING
			 new temperature("Inside",22F),  //Reference temp
			 new temperature("Outside",20F), //outside temp lower and in range -> OPEN
			 new temperature("Outside",25F), //outside temp higher and in range -> CLOSED
			 new temperature("Outside",10F) //outside temp lower and out of range -> CLOSED
			 );		
	
	@RequestMapping("/tempInt")
	 public float getTemperatureInterior() {		 
		 return tempList.get(0).getTemp();
	 }
	
	@RequestMapping("/tempExt")
	 public float getTemperatureExterior() {		 
		 return tempList.get(1).getTemp();
	 }
	
	@RequestMapping("/tempExt2")
	 public float getTemperatureExterior2() {		 
		 return tempList.get(2).getTemp();
	 }
	
	@RequestMapping("/tempExt3")
	 public float getTemperatureExterior3() {		 
		 return tempList.get(3).getTemp();
	 }
}
