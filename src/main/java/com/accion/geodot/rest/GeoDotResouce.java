package com.accion.geodot.rest;

import javax.transaction.SystemException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.accion.geodot.exception.GeoDotServiceException;
import com.accion.geodot.exception.NotFoundException;
import com.accion.geodot.models.GeoDotResponse;
import com.accion.geodot.models.LocationDetailsDO;
import com.accion.geodot.service.GeoDotService;
import com.accion.geodot.util.GeoDotUtil;

import static com.accion.geodot.util.GeoDotConstants.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
@RestController
@RequestMapping(value = "/geodot/service/v1")
public class GeoDotResouce {

	@Autowired
	private GeoDotService geoDotService;

	@RequestMapping(value = "", method = RequestMethod.POST, produces = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<GeoDotResponse> createGeoDot(@RequestBody LocationDetailsDO locationDetailsDO) {
		
		String geoDotId=null;
		List<String> errors=null;
		GeoDotResponse geoDotResponse=new GeoDotResponse();
		
		if (locationDetailsDO.getLangitude() == null) {
			errors=new ArrayList<String>();
			errors.add(LANGITUDE_IS_MANDATORY);
		}
		if (locationDetailsDO.getLatitude() == null) {
			if(Objects.isNull(errors)){
				errors=new ArrayList<String>();
			}
			errors.add(LATITUDE_IS_MANDATORY);
		}
		if(Objects.nonNull(errors)) {
			geoDotResponse.setErrors(errors);
			geoDotResponse.setSuccess(false);
			return new ResponseEntity<GeoDotResponse>(geoDotResponse, HttpStatus.BAD_REQUEST);
		}
		try {
			
			geoDotId=geoDotService.createGeoDot(locationDetailsDO);
			LocationDetailsDO locationDetailsResponseDO=new  LocationDetailsDO();
			locationDetailsResponseDO.setLocationUUID(geoDotId);
			geoDotResponse.setLocationDetailsDO(locationDetailsResponseDO);
			geoDotResponse.setSuccess(true);
			
		} catch (GeoDotServiceException ex) {
			errors=new ArrayList<String>();
			errors.add(TECHNICAL_ERROR);
			geoDotResponse.setSuccess(false);
			geoDotResponse.setErrors(errors);
			return new ResponseEntity<GeoDotResponse>(geoDotResponse, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<GeoDotResponse>(geoDotResponse, HttpStatus.CREATED);
	}

	

	@RequestMapping(value = "/{uuid}", method = RequestMethod.GET, produces = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<GeoDotResponse> getGeoDotDetails(@PathVariable String uuid) {
		LocationDetailsDO locationDetailsDO = null;
		List<String> errors=null;
		GeoDotResponse geoDotResponse=new GeoDotResponse();
		try {
			locationDetailsDO = geoDotService.getGeoDotDetails(uuid);
			geoDotResponse.setLocationDetailsDO(locationDetailsDO);
			geoDotResponse.setSuccess(true);
			
		} catch (NotFoundException e) {
			errors=new ArrayList<String>();
			errors.add(NOT_FOUND_ERROR);
			geoDotResponse.setSuccess(false);
			geoDotResponse.setErrors(errors);
			return new ResponseEntity<GeoDotResponse>(geoDotResponse, HttpStatus.NOT_FOUND);
		} catch (SystemException e) {
			errors=new ArrayList<String>();
			errors.add(TECHNICAL_ERROR);
			geoDotResponse.setSuccess(false);
			geoDotResponse.setErrors(errors);
			return new ResponseEntity<GeoDotResponse>(geoDotResponse, HttpStatus.INTERNAL_SERVER_ERROR);

		}
		return new ResponseEntity<GeoDotResponse>(geoDotResponse, HttpStatus.OK);

	}

	@RequestMapping(value = "/{uuid}", method = RequestMethod.DELETE, produces = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<GeoDotResponse> deleteGeoDot(@PathVariable String uuid) {
		
		List<String> errors=null;
		GeoDotResponse geoDotResponse=new GeoDotResponse();
		try {
			geoDotService.deleteGeoDotDetails(uuid);
			geoDotResponse.setSuccess(true);
			
		} catch (NotFoundException e) {
			errors=new ArrayList<String>();
			errors.add(NOT_FOUND_ERROR);
			geoDotResponse.setErrors(errors);
			geoDotResponse.setSuccess(false);
			return new ResponseEntity<GeoDotResponse>(geoDotResponse, HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			errors=new ArrayList<String>();
			errors.add(TECHNICAL_ERROR);
			geoDotResponse.setErrors(errors);
			geoDotResponse.setSuccess(false);
			return new ResponseEntity<GeoDotResponse>(geoDotResponse, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<GeoDotResponse>(geoDotResponse, HttpStatus.OK);

	}
}
