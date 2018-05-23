package com.accion.geodot.service;

import javax.transaction.SystemException;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.accion.geodot.dao.GeoDotDAO;
import com.accion.geodot.exception.GeoDotServiceException;
import com.accion.geodot.exception.NotFoundException;
import com.accion.geodot.models.LocationDetails;
import com.accion.geodot.models.LocationDetailsDO;
import com.accion.geodot.util.GeoDotUtil;

@Service
public class GeoDotServiceImpl implements GeoDotService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3666230743166163174L;

	@Autowired
	private GeoDotUtil geoDotUtil;

	@Autowired
	private GeoDotDAO geoDotDAO;

	@Override
	public String createGeoDot(LocationDetailsDO locationDetailsDO) throws GeoDotServiceException {
		String geoDotID = geoDotDAO.createGeoDot(geoDotUtil.buildLocationDetailsEntity(locationDetailsDO));
		return geoDotID;
	}

	@Override
	public LocationDetailsDO getGeoDotDetails(String uuid) throws NotFoundException, SystemException {
		LocationDetails locationDetails = null;
		try {
			locationDetails = geoDotDAO.getGeoDotDetails(uuid);
			if (locationDetails == null) {
				throw new NotFoundException("Resource not found");
			}

		}

		catch (NotFoundException nfe) {
			throw nfe;
		} catch (Exception ex) {
			throw new SystemException();
		}
		return geoDotUtil.buildLocationDetailsDO(locationDetails);
	}

	@Override
	@Transactional
	public void deleteGeoDotDetails(String uuid) throws NotFoundException, SystemException {
		LocationDetails locationDetails = geoDotDAO.getGeoDotDetails(uuid);
		if (locationDetails == null) {
			throw new NotFoundException("Resource not found");
		}
		try {
			geoDotDAO.deleteGeoDotDetails(uuid);
		} catch (Exception ex) {
			throw new SystemException();
		}
	}

}
