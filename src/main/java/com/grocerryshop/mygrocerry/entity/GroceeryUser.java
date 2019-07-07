package com.grocerryshop.mygrocerry.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class GroceeryUser {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long custId;
	private String customerName;
	@Temporal(TemporalType.DATE)
	private Date dateOfReg;

	private Character customerType;

	public GroceeryUser() {

	}

	public GroceeryUser(String customerName, Date dateOfReg,
			Character customerType) {
		super();
		this.customerName = customerName;
		this.dateOfReg = dateOfReg;
		this.customerType = customerType;
	}

	public Character getCustomerType() {
		return customerType;
	}

	public void setCustomerType(Character customerType) {
		this.customerType = customerType;
	}

	public Long getCustId() {
		return custId;
	}

	public void setCustId(Long custId) {
		this.custId = custId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public Date getDateOfReg() {
		return dateOfReg;
	}

	public void setDateOfReg(Date dateOfReg) {
		this.dateOfReg = dateOfReg;
	}

}
