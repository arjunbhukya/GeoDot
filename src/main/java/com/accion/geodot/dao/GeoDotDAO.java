package com.accion.geodot.dao;

import org.springframework.stereotype.Component;

import com.accion.geodot.exception.GeoDotServiceException;
import com.accion.geodot.exception.NotFoundException;
import com.accion.geodot.models.LocationDetails;

@Component
public interface GeoDotDAO {

	/**
	 * Create GeoDot location using given langitute, latitute , altitute  and return the unique id created.
	 * @param locationDetails
	 * @return unique id for the geodot locaiton
	 * @throws GeoDotServiceException
	 */
	String createGeoDot(LocationDetails locationDetails) throws GeoDotServiceException;
	
	/**
	 * Retrieve the geodot location details using given geodot location id
	 * @param uuid
	 * @return
	 * @throws NotFoundException
	 */
	LocationDetails getGeoDotDetails(String uuid) throws NotFoundException;
	
	/**
	 * delete the geodot location details
	 * @param uuid
	 * @throws NotFoundException
	 */
	void deleteGeoDotDetails(String uuid) throws NotFoundException;
}
