package com.hotelapp.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Menu {
	public Menu() {
		super();
	}
	@Id
	@GeneratedValue(generator = "menu_id", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "menu_id",sequenceName = "menu_id" )
	private Integer menuId;
	private String menuName;
	private double price;
	@ManyToOne
	@JoinColumn(name="hotel_id")
	@JsonIgnore
	private Hotel hotel;
	
	public Integer getMenuId() {
		return menuId;
	}
	public void setMenuId(Integer menuId) {
		this.menuId = menuId;
	}
	public String getMenuName() {
		return menuName;
	}
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Hotel getHotel() {
		return hotel;
	}
	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}
	public Menu(String menuName, double price) {
		super();
		this.menuName = menuName;
		this.price = price;
	}
	@Override
	public String toString() {
		return "Menu [menuName=" + menuName + ", price=" + price + "]";
	}
	
	
	

}
