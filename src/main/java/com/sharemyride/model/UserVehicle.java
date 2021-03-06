package com.sharemyride.model;
// Generated Dec 4, 2018 3:11:14 PM by Hibernate Tools 5.0.6.Final

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * UserVehicle generated by hbm2java
 */
@Entity
@Table(name = "user_vehicle", catalog = "share_my_ride")
public class UserVehicle implements java.io.Serializable {

	private Integer id;
	private User user;
	private String image;
	private String vehicleName;
	private String vehicleNumber;
	private String type;
	private String description;
	private Integer seats;
	private Date createdDate;
	private Date updatedDate;
	private String createdBy;
	private String updatedBy;
	private String status;
	private String remark;
	private Set<UserOfferRide> userOfferRides = new HashSet<UserOfferRide>(0);

	public UserVehicle() {
	}

	public UserVehicle(User user, String image, String vehicleName, String vehicleNumber, String type,
			String description, Integer seats, Date createdDate, Date updatedDate, String createdBy, String updatedBy,
			String status, String remark, Set<UserOfferRide> userOfferRides) {
		this.user = user;
		this.image = image;
		this.vehicleName = vehicleName;
		this.vehicleNumber = vehicleNumber;
		this.type = type;
		this.description = description;
		this.seats = seats;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
		this.createdBy = createdBy;
		this.updatedBy = updatedBy;
		this.status = status;
		this.remark = remark;
		this.userOfferRides = userOfferRides;
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
	@JoinColumn(name = "user_id")
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Column(name = "image", length = 145)
	public String getImage() {
		return this.image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@Column(name = "vehicle_name", length = 145)
	public String getVehicleName() {
		return this.vehicleName;
	}

	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}

	@Column(name = "vehicle_number", length = 45)
	public String getVehicleNumber() {
		return this.vehicleNumber;
	}

	public void setVehicleNumber(String vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}

	@Column(name = "type", length = 45)
	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Column(name = "description", length = 500)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "seats")
	public Integer getSeats() {
		return this.seats;
	}

	public void setSeats(Integer seats) {
		this.seats = seats;
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

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "userVehicle")
	public Set<UserOfferRide> getUserOfferRides() {
		return this.userOfferRides;
	}

	public void setUserOfferRides(Set<UserOfferRide> userOfferRides) {
		this.userOfferRides = userOfferRides;
	}

}
