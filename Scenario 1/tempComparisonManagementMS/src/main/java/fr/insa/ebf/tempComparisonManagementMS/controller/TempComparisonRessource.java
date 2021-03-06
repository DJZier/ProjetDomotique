package fr.insa.ebf.tempComparisonManagementMS.controller;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import fr.insa.ebf.tempComparisonManagementMS.model.Window;

@RestController
public class TempComparisonRessource {
	
	private final String winMSURI = "http://localhost:8083/window";
	private final String tempExtMSURI = "http://localhost:8082/temperature/tempExt";
	private final String tempIntMSURI = "http://localhost:8082/temperature/tempInt";
	private final int idWin = 1;
	private final int idTemp = 1;
	private boolean status;
	
	@GetMapping("/comparisonResult")
	public boolean comparisonResult() {
		return true;
	}

	@GetMapping("/runShouldWindowsOpen")
	public boolean getStateWindowst() {
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		
		// Instanciate of RestTemplate for Rest calls
		RestTemplate restTemplate = new RestTemplate();
		float tempExt = restTemplate.getForObject(tempExtMSURI , float.class);
		float tempInt = restTemplate.getForObject(tempIntMSURI, float.class);
		if ((tempInt < tempExt) && ((18 < tempExt) && (tempExt < 27))) {
			status = true;
		}
		else {
			status = false;
		}
		restTemplate.put(winMSURI + "/openWindow/" + idWin, status);
		return status;
	}
	
	@GetMapping("/postNewWindow")
	public int postNewWindow() {
		
		Window newWindow = new Window();
		
		// Instanciate of RestTemplate for Rest calls
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<Window> requestWinEntity = new HttpEntity<>(newWindow, headers);
		
		ResponseEntity<Window> responseEntity = restTemplate.postForEntity(winMSURI+"/addWindow/8", requestWinEntity, Window.class);
		System.out.println("Status Code: " + responseEntity.getStatusCode()); 
		System.out.println("Id: " + responseEntity.getBody().getId()); 
		System.out.println("Id: " + responseEntity.getBody().isOpened()); 
		return responseEntity.getStatusCode().value();
	}	
}
