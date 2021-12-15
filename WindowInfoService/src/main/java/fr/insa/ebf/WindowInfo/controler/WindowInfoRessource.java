package fr.insa.ebf.WindowInfo.controler;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
	
	@PostMapping("/addWindow")
	public ResponseEntity<Window> addNewWindow(@RequestBody Window newWindow){
		myWindowsList.add(newWindow);
		return new ResponseEntity<Window>(myWindowsList.get(newWindow.getId()), HttpStatus.CREATED);
	}
	
	@GetMapping("/listWindow")
	public List <Window> showListWindow(){
		return myWindowsList;
	}
}

