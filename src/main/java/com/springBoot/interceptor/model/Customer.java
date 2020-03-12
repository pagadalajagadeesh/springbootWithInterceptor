package com.springBoot.interceptor.model;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Calendar;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.apache.commons.lang3.StringUtils;

import com.springBoot.interceptor.util.DateUtils;

@Entity
public class Customer implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "active")
	private boolean active = true;
	@Column(name = "createdAt")
	private Timestamp createdAt = new Timestamp(Calendar.getInstance().getTimeInMillis());
	@Column(name = "updatedAt")
	private Timestamp updatedAt = new Timestamp(Calendar.getInstance().getTimeInMillis());

	@Column(name = "firstName")
	private String firstName;
	@Column(name = "lastName")
	private String lastName;
	@Column(name = "mobileNumber")
	private String mobileNumber;
	@Column(name = "address")
	private String address;
	@Column(name = "joiningDate")
	private Date joiningDate;
	@Column(name = "email")
	private String email;

	public Customer() {
	}

	public Customer(String firstName, String lastName, String mobileNumber, String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.mobileNumber = mobileNumber;
		this.email = email;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return StringUtils.capitalize(firstName) ;
	}

	public void setFirstName(String firstName) {
		this.firstName = StringUtils.capitalize(firstName);
	}

	public String getLastName() {
		return StringUtils.capitalize(lastName);
	}

	public void setLastName(String lastName) {
		this.lastName = StringUtils.capitalize(lastName);
	}

	public Object getJoiningDate() {
		return DateUtils.convertToDate(joiningDate);
	}

	public void setJoiningDate(Date joiningDate) {
		this.joiningDate = joiningDate;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public Timestamp getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Timestamp updatedAt) {
		this.updatedAt = updatedAt;
	}

	public Timestamp getCreatedAt() {
		return createdAt;
	}
 
}
