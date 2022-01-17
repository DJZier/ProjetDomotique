package fr.insa.ebf.projector.model;


public class ProjectorMSModel {
	
	boolean isPowered;
	
	public void powerProjector() {
		isPowered=true;
	}
	
	public void shutdownProjector() {
		isPowered=false;
	}

	public ProjectorMSModel(boolean isPowered) {
		super();
		this.isPowered = isPowered;
	}
	
	

}
