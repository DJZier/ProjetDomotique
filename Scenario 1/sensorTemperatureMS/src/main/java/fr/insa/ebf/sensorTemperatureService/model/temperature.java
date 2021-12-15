package fr.insa.ebf.sensorTemperatureService.model;

public class temperature {
	private float temp;
	private String sensorType;
	
	public temperature() {
		super();
	}
	public temperature(String sensorType, float temp) {
		super();
		this.temp = temp;
		this.sensorType = sensorType;
	}
	
	public float getTemp() {
		return temp;
	}
	public void setTemp(float temp) {
		this.temp = temp;
	}
	public String getSensorType() {
		return sensorType;
	}
	public void setSensorType(String sensorType) {
		this.sensorType = sensorType;
	}
}
