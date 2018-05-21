package com.accion.geodot.models;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class LocationDetailsDO implements Serializable {

	private static final long serialVersionUID = 4404889333741198476L;

	private String locationUUID;

	private String langitude;

	private String latitude;

	private String altitude;

	public String getLocationUUID() {
		return locationUUID;
	}

	public String getLangitude() {
		return langitude;
	}

	public void setLangitude(String langitude) {
		this.langitude = langitude;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getAltitude() {
		return altitude;
	}

	public void setAltitude(String altitude) {
		this.altitude = altitude;
	}

	public void setLocationUUID(String locationUUID) {
		this.locationUUID = locationUUID;
	}

	

}
