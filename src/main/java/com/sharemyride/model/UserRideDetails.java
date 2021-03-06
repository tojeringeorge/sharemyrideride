package com.sharemyride.model;
// Generated Dec 4, 2018 3:11:14 PM by Hibernate Tools 5.0.6.Final

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * UserRideDetails generated by hbm2java
 */
@Entity
@Table(name = "user_ride_details", catalog = "share_my_ride")
public class UserRideDetails implements java.io.Serializable {

	private Integer id;
	private UserOfferRide userOfferRide;
	private UserSearchRide userSearchRide;
	private String latitude;
	private String longitude;
	private Date dateTime;
	private String type;
	private Date createdDate;
	private Date updatedDate;
	private String createdBy;
	private String updatedBy;
	private String status;
	private String remark;

	public UserRideDetails() {
	}

	public UserRideDetails(UserOfferRide userOfferRide, UserSearchRide userSearchRide, String latitude,
			String longitude, Date dateTime, String type, Date createdDate, Date updatedDate, String createdBy,
			String updatedBy, String status, String remark) {
		this.userOfferRide = userOfferRide;
		this.userSearchRide = userSearchRide;
		this.latitude = latitude;
		this.longitude = longitude;
		this.dateTime = dateTime;
		this.type = type;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
		this.createdBy = createdBy;
		this.updatedBy = updatedBy;
		this.status = status;
		this.remark = remark;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_offer_ride_id")
	public UserOfferRide getUserOfferRide() {
		return this.userOfferRide;
	}

	public void setUserOfferRide(UserOfferRide userOfferRide) {
		this.userOfferRide = userOfferRide;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_search_ride_id")
	public UserSearchRide getUserSearchRide() {
		return this.userSearchRide;
	}

	public void setUserSearchRide(UserSearchRide userSearchRide) {
		this.userSearchRide = userSearchRide;
	}

	@Column(name = "latitude", length = 45)
	public String getLatitude() {
		return this.latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	@Column(name = "longitude", length = 45)
	public String getLongitude() {
		return this.longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "date_time", length = 19)
	public Date getDateTime() {
		return this.dateTime;
	}

	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}

	@Column(name = "type", length = 45)
	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_date", length = 19)
	public Date getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updated_date", length = 19)
	public Date getUpdatedDate() {
		return this.updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	@Column(name = "created_by", length = 45)
	public String getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	@Column(name = "updated_by", length = 45)
	public String getUpdatedBy() {
		return this.updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	@Column(name = "status")
	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Column(name = "remark")
	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}
