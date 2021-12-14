package fr.insa.ebf.tempComparisonManagementMS.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class TempComparisonRessource {
	
	@GetMapping("/comparisonResult")
	public boolean comparisonResult() {
		return true;
	}
	
	@GetMapping("/tempExt")
	public int getTempExt() {
		return 25;
	}
	
	@GetMapping("/tempInt")
	public int getTempInt() {
		return 19;
	}
	
	@GetMapping("/shouldWindowsOpen")
	public boolean getStateWindowst() {
		
		// Instanciate of RestTemplate for Rest calls
		RestTemplate restTemplate = new RestTemplate();
		int tempExt = restTemplate.getForObject("http://localhost:8081/tempExt", int.class);
		int tempInt = restTemplate.getForObject("http://localhost:8081/tempInt", int.class);
		if ((tempInt < tempExt) && ((18 < tempExt) && (tempExt < 27))) {
			return true;
		}
		else {
			return false;
		}		
	}
}
