package fr.insa.ebf.LightMS.Ressource;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.insa.ebf.LightMS.model.Light;

@RestController
@RequestMapping("/light")
public class LightMSRessource {
		
		@GetMapping("/Power/{statu}")
		public String changetLightsState(@PathVariable boolean statu) {
			Light myLight = new Light(false);
			String response = null;
			if (statu) {
				myLight.powerLight();
				response="Lights powered on";
			}
			else if (!statu) {
				myLight.shutdownLight();
				response="Light powered off";
			}
			return response;
		}
		
}
