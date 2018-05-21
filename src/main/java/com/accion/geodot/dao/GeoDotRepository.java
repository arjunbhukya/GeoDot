package com.accion.geodot.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.accion.geodot.models.LocationDetails;

public interface GeoDotRepository extends PagingAndSortingRepository<LocationDetails, Long>{
	
	public LocationDetails findByLocationUUID(String locationUUID);
	
	public void deleteByLocationUUID(String locationUUID);
	
}