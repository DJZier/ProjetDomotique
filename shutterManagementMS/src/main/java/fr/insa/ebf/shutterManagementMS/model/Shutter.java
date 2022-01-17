package fr.insa.ebf.shutterManagementMS.model;

public class Shutter {
	private boolean open;

	public Shutter() {
		super();
		this.open=false;
	}

	public Shutter(boolean state) {
		super();
		this.open = state;
	}

	public boolean getState() {
		return open;
	}

	public void setState(boolean state) {
		this.open = state;
	}

	public void openShutters() {
		this.open=true;
	}

	public void closeShutters() {
		this.open=false;
	}

}
