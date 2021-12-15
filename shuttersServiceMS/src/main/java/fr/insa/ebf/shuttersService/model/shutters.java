package fr.insa.ebf.shuttersService.model;

public class shutters {
private int id;
private boolean state;

public shutters() {
	super();
	this.state=false;
	this.id=0;
}

public shutters(int id) {
	super();
	this.id = id;
	this.state = false;
}

public shutters(boolean state) {
	super();
	this.state = state;
}

public shutters(int id, boolean state) {
	super();
	this.id = id;
	this.state = state;
}

public boolean getState() {
	return state;
}

public void setState(boolean state) {
	this.state = state;
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public void openShutters() {
	this.state=true;
}

public void closeShutters() {
	this.state=false;
}

}
