package fr.insa.ebf.LightMS.model;


public class Light {
		
	boolean isPowered;
		
	public void powerLight() {
		isPowered=true;
	}
	
	public void shutdownLight() {
		isPowered=false;
	}
	public Light(boolean power) {
		super();
		this.isPowered = power;
	}
		
}
