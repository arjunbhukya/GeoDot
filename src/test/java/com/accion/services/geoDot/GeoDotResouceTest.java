package com.accion.services.geoDot;

import static org.junit.Assert.assertEquals;

import javax.transaction.SystemException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.accion.geodot.exception.GeoDotServiceException;
import com.accion.geodot.exception.NotFoundException;
import com.accion.geodot.models.GeoDotResponse;
import com.accion.geodot.models.LocationDetailsDO;
import com.accion.geodot.rest.GeoDotResouce;
import com.accion.geodot.service.GeoDotService;



@RunWith(SpringJUnit4ClassRunner.class)
public class GeoDotResouceTest {
	
	@InjectMocks
	private GeoDotResouce geoDotResouce;
	
	@Mock
	private GeoDotService geoDotService;

	
	@Test
	public void testCreateGeoDot() throws GeoDotServiceException {

		Mockito.when(geoDotService.createGeoDot(Mockito.any())).thenReturn(Mockito.anyString());
		LocationDetailsDO locationDetailsDO = populateLocationDetailsDOForCreateService();
		ResponseEntity<GeoDotResponse> responseEntity = geoDotResouce.createGeoDot(locationDetailsDO);
		assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
		
	}
		
	@Test
	public void testCreateGeoDotBadRequest() throws GeoDotServiceException {

		Mockito.when(geoDotService.createGeoDot(Mockito.any())).thenReturn(Mockito.anyString());
		LocationDetailsDO locationDetailsDO = new LocationDetailsDO();
		ResponseEntity<GeoDotResponse> responseEntity = geoDotResouce.createGeoDot(locationDetailsDO);
		assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());
		
	}
	@Test
	public void testCreateGeoDot_InternalError() throws GeoDotServiceException {
		Mockito.when(geoDotService.createGeoDot(Mockito.any())).thenThrow(GeoDotServiceException.class);
		LocationDetailsDO locationDetailsDO = populateLocationDetailsDOForCreateService();
		ResponseEntity<GeoDotResponse> responseEntity = geoDotResouce.createGeoDot(locationDetailsDO);
		assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, responseEntity.getStatusCode());
		
	}
	
	@Test
	public void testGetGeoDotDetails() throws NotFoundException, SystemException {
		LocationDetailsDO locationDetailsDO = new LocationDetailsDO();
		Mockito.when(geoDotService.getGeoDotDetails(Mockito.anyString())).thenReturn(locationDetailsDO);
		ResponseEntity<GeoDotResponse> responseEntity = geoDotResouce.getGeoDotDetails("87345385");
		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
		
	}
		
	@Test
	public void testGetGeoDotDetails_NotFoundException() throws NotFoundException, SystemException {
		Mockito.when(geoDotService.getGeoDotDetails(Mockito.anyString())).thenThrow(NotFoundException.class);
		ResponseEntity<GeoDotResponse> responseEntity = geoDotResouce.getGeoDotDetails("87345385");
		assertEquals(HttpStatus.NOT_FOUND, responseEntity.getStatusCode());
		
	}
		
	@Test
	public void testGetGeoDotDetails_SystemException() throws NotFoundException, SystemException {
		Mockito.when(geoDotService.getGeoDotDetails(Mockito.anyString())).thenThrow(SystemException.class);
		ResponseEntity<GeoDotResponse> responseEntity = geoDotResouce.getGeoDotDetails("87345385");
		assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, responseEntity.getStatusCode());
		
	}
	
	@Test
	public void testGeoDot() throws NotFoundException, SystemException {
		Mockito.doNothing().when(geoDotService).deleteGeoDotDetails(Mockito.anyString());
		ResponseEntity<GeoDotResponse> responseEntity = geoDotResouce.deleteGeoDot("87345385");
		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
		
	}
	
	private LocationDetailsDO populateLocationDetailsDOForCreateService() {
	LocationDetailsDO locationDetailsDO = new LocationDetailsDO();
	locationDetailsDO.setLatitude(384D);
	locationDetailsDO.setLangitude(38942D);
	return locationDetailsDO;
	
	
		
	}

}
