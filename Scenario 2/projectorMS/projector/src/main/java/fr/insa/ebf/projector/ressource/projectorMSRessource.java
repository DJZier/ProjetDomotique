package fr.insa.ebf.projector.ressource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.insa.ebf.projector.model.ProjectorMSModel;

@RestController
@RequestMapping("/projector")
public class projectorMSRessource {
	
	@GetMapping("/projector/Power/{statu}")
	public void changetWindowState(@PathVariable boolean statu) {
		ProjectorMSModel myProjector = new ProjectorMSModel(false);
		if (statu) {
			myProjector.powerProjector();
			System.out.println("Projector powered on");
		}
		else if (!statu) {
			myProjector.shutdownProjector();
			System.out.println("Projector shutodwned");
		}
	}
}




