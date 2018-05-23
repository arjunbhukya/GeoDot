package com.accion.geodot.models;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@XmlRootElement
public class LocationDetailsDO implements Serializable {

	private static final long serialVersionUID = 4404889333741198476L;

	@JsonInclude(Include.NON_NULL)
	private String locationUUID;

	@JsonInclude(Include.NON_NULL)
	private Double langitude;

	@JsonInclude(Include.NON_NULL)
	private Double latitude;

	@JsonInclude(Include.NON_NULL)
	private Double altitude;

	public String getLocationUUID() {
		return locationUUID;
	}

	public Double getLangitude() {
		return langitude;
	}

	public void setLangitude(Double langitude) {
		this.langitude = langitude;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getAltitude() {
		return altitude;
	}

	public void setAltitude(Double altitude) {
		this.altitude = altitude;
	}

	public void setLocationUUID(String locationUUID) {
		this.locationUUID = locationUUID;
	}

	

}
