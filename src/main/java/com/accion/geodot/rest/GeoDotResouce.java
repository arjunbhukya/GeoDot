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
import com.accion.geodot.models.LocationDetailsDO;
import com.accion.geodot.service.GeoDotService;
import static com.accion.geodot.util.GeoDotConstants.*;
@RestController
@RequestMapping(value = "/geodot/service/v1")
public class GeoDotResouce {

	@Autowired
	private GeoDotService geoDotService;

	@RequestMapping(value = "", method = RequestMethod.POST, produces = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<String> createGeoDot(@RequestBody LocationDetailsDO locationDetailsDO) {
		
		String geoDotId=null;
		try {
			
			geoDotId=geoDotService.createGeoDot(locationDetailsDO);
			
		} catch (GeoDotServiceException ex) {
			ex.printStackTrace();
			return new ResponseEntity<String>(TECHNICAL_ERROR, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<String>(geoDotId, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{uuid}", method = RequestMethod.GET, produces = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<LocationDetailsDO> getGeoDotDetails(@PathVariable String uuid) {
		LocationDetailsDO locationDetailsDO = null;
		try {
			locationDetailsDO = geoDotService.getGeoDotDetails(uuid);
		} catch (NotFoundException e) {
			return new ResponseEntity<LocationDetailsDO>(locationDetailsDO, HttpStatus.NOT_FOUND);
		} catch (SystemException e) {
			return new ResponseEntity<LocationDetailsDO>(locationDetailsDO, HttpStatus.INTERNAL_SERVER_ERROR);

		}
		return new ResponseEntity<LocationDetailsDO>(locationDetailsDO, HttpStatus.OK);

	}

	@RequestMapping(value = "/{uuid}", method = RequestMethod.DELETE, produces = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<String> deleteGeoDot(@PathVariable String uuid) {
		try {
			geoDotService.deleteGeoDotDetails(uuid);
		} catch (NotFoundException e) {
			return new ResponseEntity<String>(NOT_FOUND_ERROR, HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			return new ResponseEntity<String>(TECHNICAL_ERROR, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<String>("Given resouce deleted successfully", HttpStatus.OK);

	}
}
