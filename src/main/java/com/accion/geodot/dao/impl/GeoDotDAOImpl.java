package com.accion.geodot.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accion.geodot.dao.GeoDotDAO;
import com.accion.geodot.dao.GeoDotRepository;
import com.accion.geodot.models.LocationDetails;

@Service
public class GeoDotDAOImpl implements GeoDotDAO{

	@Autowired
	private GeoDotRepository geoDotRepository;

	@Override
	public String createGeoDot(LocationDetails locationDetails) {
		geoDotRepository.save(locationDetails);
		return locationDetails.getLocationUUID();
	}

	@Override
	public LocationDetails getGeoDotDetails(String uuid) {
		return geoDotRepository.findByLocationUUID(uuid);
	}

	@Override
	public void deleteGeoDotDetails(String uuid) {
		geoDotRepository.deleteByLocationUUID(uuid);
		
	}

}
