package com.hotelapp.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Address {
	public Address() {
		super();
	}
	@Id
	@GeneratedValue(generator = "add_id", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "add_id",sequenceName = "address_id" )
	private Integer addressId;
	private String streetName;
	private String city;
	private long zipcode;
	private String state;
	
	public Integer getAddressId() {
		return addressId;
	}
	public void setAddressId(Integer addressId) {
		this.addressId = addressId;
	}
	public String getStreetName() {
		return streetName;
	}
	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public long getZipcode() {
		return zipcode;
	}
	public void setZipcode(long zipcode) {
		this.zipcode = zipcode;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public Address(String streetName, String city, long zipcode, String state) {
		super();
		this.streetName = streetName;
		this.city = city;
		this.zipcode = zipcode;
		this.state = state;
	}
	@Override
	public String toString() {
		return "Address [streetName=" + streetName + ", city=" + city + ", zipcode=" + zipcode + ", state=" + state
				+ "]";
	}
	
	
	

	
	
	
	

}
