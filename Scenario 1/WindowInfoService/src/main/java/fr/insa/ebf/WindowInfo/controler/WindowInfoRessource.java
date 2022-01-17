package fr.insa.ebf.WindowInfo.controler;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

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
	
	@PostMapping("/addWindow/{id}")
	public ResponseEntity<Window> addNewWindow(@RequestBody Window newWindow, @PathVariable("id") int id, UriComponentsBuilder builder){
		if (newWindow.getId()==0) {
			newWindow.setId(myWindowsList.size()+1);
		}
		myWindowsList.add(newWindow);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/window/{id}").buildAndExpand(myWindowsList.get(id).getId()).toUri());
		return new ResponseEntity<Window>(myWindowsList.get(newWindow.getId()), headers, HttpStatus.CREATED);
	}
	
	@GetMapping("/{id}")
	public Window showWindow(@PathVariable("id") int id){
		return myWindowsList.get(id);
	}
	
	@GetMapping("/listWindow")
	public List <Window> showListWindow(){
		return myWindowsList;
	}
}

