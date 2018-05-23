package com.accion.geodot.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

public class GeoDotResponse {

	@JsonInclude(Include.NON_NULL)
	@JsonProperty("GeoDotDetails")
	LocationDetailsDO locationDetailsDO = null;

	Boolean success;
	
	@JsonInclude(Include.NON_NULL)
	List<String> errors = null;

	public Boolean getSuccess() {
		return success;
	}

	public void setSuccess(Boolean success) {
		this.success = success;
	}

	public List<String> getErrors() {
		return errors;
	}

	public void setErrors(List<String> errors) {
		this.errors = errors;
	}

	public LocationDetailsDO getLocationDetailsDO() {
		return locationDetailsDO;
	}

	public void setLocationDetailsDO(LocationDetailsDO locationDetailsDO) {
		this.locationDetailsDO = locationDetailsDO;
	}

	@Override
	public String toString() {
		return "GeoDotResponse [locationDetailsDO=" + locationDetailsDO + "]";
	}

	
}
