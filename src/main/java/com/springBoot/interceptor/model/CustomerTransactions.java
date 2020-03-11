package com.springBoot.interceptor.model;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

@Entity
public class CustomerTransactions {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@ManyToOne
	@JoinColumn(name = "masterData_id")
	private MasterData masterData;
	
	@Transient
	private long masterDataId;

	@ManyToOne
	@JoinColumn(name = "customer_id")
	private Customer customer;
	
	@Transient
	private long customerId;
	
	@Column(name = "transactionDate")
	private Date transactionDate;
	
	@Column(name = "createdAt")
	private Timestamp createdAt = new Timestamp(Calendar.getInstance().getTimeInMillis());
	
	@Column(name = "updatedAt")
	private Timestamp updatedAt = new Timestamp(Calendar.getInstance().getTimeInMillis());
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public MasterData getMasterData() {
		return masterData;
	}

	public void setMasterData(MasterData masterData) {
		this.masterData = masterData;
	}

	public long getMasterDataId() {
		return masterDataId;
	}

	public void setMasterDataId(long masterDataId) {
		this.masterDataId = masterDataId;
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

	public Date getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
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
