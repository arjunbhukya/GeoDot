package com.accion.geodot.service;

import java.io.Serializable;

import javax.transaction.SystemException;

import com.accion.geodot.exception.GeoDotServiceException;
import com.accion.geodot.exception.NotFoundException;
import com.accion.geodot.models.LocationDetailsDO;


public interface GeoDotService extends Serializable{
	
	/**
	 * Create GeoDot location using given langitute, latitute , altitute  and return the unique id created.
	 * @param locationDetails
	 * @return unique id for the geodot locaiton
	 * @throws GeoDotServiceException 
	 */
	String createGeoDot(LocationDetailsDO locationDetailsDO) throws GeoDotServiceException;
	
	/**
	 * Retrieve the geodot location details using given geodot location id
	 * @param uuid
	 * @return
	 * @throws NotFoundException 
	 * @throws SystemException 
	 */
	LocationDetailsDO getGeoDotDetails(String uuid) throws NotFoundException, SystemException;
	
	/**
	 * To delete the GeoDot location details
	 * @param uuid
	 * @throws NotFoundException 
	 * @throws SystemException 
	 */
	void deleteGeoDotDetails(String uuid) throws NotFoundException, SystemException;

}
