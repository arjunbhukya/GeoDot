package com.accion.geodot.util;

import static com.accion.geodot.util.GeoDotConstants.*;

import java.sql.Timestamp;
import java.util.UUID;

import org.springframework.stereotype.Component;

import com.accion.geodot.models.LocationDetails;
import com.accion.geodot.models.LocationDetailsDO;
@Component
public class GeoDotUtil {

	
	public LocationDetails buildLocationDetailsEntity(LocationDetailsDO locationDetailsDO) {
		
		LocationDetails locationDetails=new LocationDetails();
		locationDetails.setAltitude(locationDetailsDO.getAltitude());
		locationDetails.setCreatedDate(new Timestamp(System.currentTimeMillis()));
		locationDetails.setLangitude(locationDetailsDO.getLangitude());
		locationDetails.setLastModifiedBy(SYSTEM);
		locationDetails.setCreatedBy(SYSTEM);
		locationDetails.setLatitude(locationDetailsDO.getLatitude());
		locationDetails.setLocationUUID(generateUUID());
		locationDetails.setLastModifiedDate(new Timestamp(System.currentTimeMillis()));
		return locationDetails;
		
	}


	private String generateUUID() {
		return UUID.randomUUID().toString().replaceAll(UNDERSCORE,EMPTY_STRING).substring(ZERO,SIX);
	}
	
	
public LocationDetailsDO buildLocationDetailsDO(LocationDetails locationDetails) {
		
		LocationDetailsDO locationDetailsDO=new LocationDetailsDO();
		
		locationDetailsDO.setAltitude(locationDetails.getAltitude());
		locationDetailsDO.setLangitude(locationDetails.getLangitude());
		locationDetailsDO.setLatitude(locationDetails.getLatitude());
		locationDetailsDO.setLocationUUID(locationDetails.getLocationUUID());
		
		return locationDetailsDO;
		
	}
}
