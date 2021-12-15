package fr.insa.ebf.WindowInfo.controler;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.insa.ebf.WindowInfo.model.Window;

@RestController
@RequestMapping("/window")
public class WindowInfoRessource {
	
	@Autowired
	private List<Window> myWindowsList;
	
	
	@PutMapping("/openWindow/{id}")
	public void changetWindowState(@PathVariable int id,@RequestBody boolean open) {
		if (open && !myWindowsList.get(id).isOpened()) {
			myWindowsList.get(id).openWindow();
			System.out.println("Window opened");
		}
		else if (!open && myWindowsList.get(id).isOpened()) {
			myWindowsList.get(id).closeWindow();
			System.out.println("Window closed");
		}
		else {
			System.out.println("Window already in good state");
		}
	}
}

