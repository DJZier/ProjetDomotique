package fr.insa.ebf.tempComparisonManagementMS.model;

public class Window {
	
	private boolean isOpen;
	private int idWindow;
	
	public void openWindow() {
		isOpen=true;
	}
	
	public void closeWindow() {
		isOpen=false;
	}
	
	public boolean isOpened() {
		return isOpen;
	}
	
	public int getId() {
		return idWindow;
	}
	
	public void setId(int id) {
		idWindow=id;
	}
	public Window (){
		isOpen=false;
		idWindow=0;
	}
	public Window (int id){
		isOpen=false;
		idWindow=id;
	}
}
