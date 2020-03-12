package com.springBoot.interceptor.model;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

import org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.springBoot.interceptor.util.DateUtils;

@Entity
@JsonIgnoreProperties
public class CustomerTransactions implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "createdAt")
	private Timestamp createdAt = new Timestamp(Calendar.getInstance().getTimeInMillis());
	@Column(name = "updatedAt")
	private Timestamp updatedAt = new Timestamp(Calendar.getInstance().getTimeInMillis());

	@ManyToMany(targetEntity = MasterData.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "customerTransactionsId")
	private List<MasterData> masterData;

	@Transient
	private List<Long> masterDataIds;

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Customer customer;

	@Transient
	private long customerId;

	@Column(name = "serviceDate")
	private Date serviceDate;

	@Column(name = "cost")
	private double cost;
	
	@Transient
	private String masterDataDetails;

	public List<MasterData> getMasterData() {
		return masterData;
	}

	public void setMasterData(List<MasterData> masterData) {
		this.masterData = masterData;
	}

	public List<Long> getMasterDataIds() {
		return masterDataIds;
	}

	public void setMasterDataIds(List<Long> masterDataIds) {
		this.masterDataIds = masterDataIds;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

	public Object getServiceDate() {
		return DateUtils.convertToDate(serviceDate);

	}

	public void setServiceDate(Date serviceDate) {
		this.serviceDate = serviceDate;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public CustomerTransactions(long id, Timestamp createdAt, Timestamp updatedAt, List<MasterData> masterData,
			List<Long> masterDataIds, Customer customer, long customerId, Date serviceDate, double cost) {
		super();
		this.id = id;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.masterData = masterData;
		this.masterDataIds = masterDataIds;
		this.customer = customer;
		this.customerId = customerId;
		this.serviceDate = serviceDate;
		this.cost = cost;
	}

	public CustomerTransactions() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getMasterDataDetails() {

		List<String> list = new ArrayList<>();

		for (MasterData s : getMasterData()) {
			list.add(s.getName());
		}
		return StringUtils.join(list, ",");
	}

	public void setMasterDataDetails(String masterDataDetails) {
		this.masterDataDetails = masterDataDetails;
	}

}
