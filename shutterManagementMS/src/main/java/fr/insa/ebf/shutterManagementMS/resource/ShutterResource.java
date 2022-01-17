package fr.insa.ebf.shutterManagementMS.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.insa.ebf.shutterManagementMS.model.Shutter;


@RestController
@RequestMapping("/shutter")
public class ShutterResource {
	@Autowired
	private Shutter myShutters;
	
	@GetMapping("/openShutter")
	public String openShutters() {
		String response=null;
		if (!myShutters.getState()) {
			myShutters.openShutters();
			response = "Shutter opened";
		}	
		else {
			response = "Shutter already in good state";
		}
		return response;
	}
	
	@GetMapping("/closeShutters/")
	public String closeShutters() {
		String response=null;
		if (myShutters.getState()) {
			myShutters.closeShutters();
			response = "Shutters closed";
		}	
		else {
			response = "Shutter already in good state";
		}
		return response;
	}
	
}
