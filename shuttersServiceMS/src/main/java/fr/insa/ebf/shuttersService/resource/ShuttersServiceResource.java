package fr.insa.ebf.shuttersService.resource;

import org.springframework.web.bind.annotation.*;

import fr.insa.ebf.shuttersService.model.*;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/shutter")
public class ShuttersServiceResource {
	
	@Autowired
	private List<shutters> myShuttersList;
	
	
	@PutMapping("/openShutter/{id}")
	public void changetShutterState(@PathVariable int id,@RequestBody boolean open) {
		if (open && !myShuttersList.get(id).getState()) {
			myShuttersList.get(id).openShutters();
			System.out.println("Shutter opened");
		}
		else if (!open && myShuttersList.get(id).getState()) {
			myShuttersList.get(id).closeShutters();
			System.out.println("Shutter closed");
		}
		else {
			System.out.println("Shutter already in good state");
		}
	}
}
