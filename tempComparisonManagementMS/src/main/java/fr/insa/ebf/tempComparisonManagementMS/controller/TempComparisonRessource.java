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

	@GetMapping("/shouldWindowsOpen")
	public boolean getStateWindowst() {
		
		// Instanciate of RestTemplate for Rest calls
		RestTemplate restTemplate = new RestTemplate();
		float tempExt = restTemplate.getForObject("http://localhost:8082/temperature/tempExt", float.class);
		float tempInt = restTemplate.getForObject("http://localhost:8082/temperature/tempInt", float.class);
		if ((tempInt < tempExt) && ((18 < tempExt) && (tempExt < 27))) {
			return true;
		}
		else {
			return false;
		}		
	}
}
