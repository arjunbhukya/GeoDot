package com.accion.geodot.models;
import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 * This class represents the Location_Details table in database.
 * @author Arjun Bhukya
 *
 */
@Entity
@Table(name="LOCATION_DETAILS")
public class LocationDetails implements Serializable {
	
	private static final long serialVersionUID = 4404889333741198476L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "LOCATION_DETAILS_ID")
	private Long id;
		
	@Column(name = "LOCATION_UUID")
	private String locationUUID;
	
	@Column(name = "LANGITUDE")
	private String langitude;
	
	@Column(name = "LATITUDE")
	private String latitude;
	
	@Column(name = "ALTITUDE")
	private String altitude;
	
	@Column(name = "created_by")
	private String createdBy = null;

	@Column(name = "created")
	private Timestamp createdDate = null;

	@Column(name = "last_updated_by")
	private String lastModifiedBy = null;
	
	@Column(name = "last_modified")
	private Timestamp lastModifiedDate = null;


	/**
	 * @return the createdBy
	 */
	public String getCreatedBy() {
		return createdBy;
	}

	/**
	 * @param pCreatedBy
	 *            the createdBy to set
	 */
	public void setCreatedBy(String pCreatedBy) {
		createdBy = pCreatedBy;
	}

	/**
	 * @return the createdDate
	 */
	public Timestamp getCreatedDate() {
		return createdDate;
	}

	/**
	 * @param pCreatedDate
	 *            the createdDate to set
	 */
	public void setCreatedDate(Timestamp pCreatedDate) {
		createdDate = pCreatedDate;
	}

	/**
	 * @return the lastModifiedBy
	 */
	public String getLastModifiedBy() {
		return lastModifiedBy;
	}

	/**
	 * @param pLastModifiedBy
	 *            the lastModifiedBy to set
	 */
	public void setLastModifiedBy(String pLastModifiedBy) {
		lastModifiedBy = pLastModifiedBy;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getLocationUUID() {
		return locationUUID;
	}
	public void setLocationUUID(String locationUUID) {
		this.locationUUID = locationUUID;
	}
		
	public String getLangitude() {
		return langitude;
	}

	public void setLangitude(String langitude) {
		this.langitude = langitude;
	}

	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getAltitude() {
		return altitude;
	}
	public void setAltitude(String altitude) {
		this.altitude = altitude;
	}

	public Timestamp getLastModifiedDate() {
		return lastModifiedDate;
	}

	public void setLastModifiedDate(Timestamp lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}
	
	
	
}
