package org.lti.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table
public class Product {

	
	@Id
	private Integer id;
	@Column(name="description",nullable = false)
	private String description;
	@Column(name="quantity")
	private Integer qty;
	@Column(name="price")
	private double price;
	@Column(name="manufactureDate",nullable = false)
	private LocalDate manufactureDate;
	@Column(name="useBeforeMonths")
	private Integer useBeforeMonths;
	private LocalDate expiryDate;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getQty() {
		return qty;
	}
	public void setQty(Integer qty) {
		this.qty = qty;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public LocalDate getManufactureDate() {
		return manufactureDate;
	}
	public void setManufactureDate(LocalDate manufactureDate) {
		this.manufactureDate = manufactureDate;
	}
	public Integer getUseBeforeMonths() {
		return useBeforeMonths;
	}
	public void setUseBeforeMonths(Integer useBeforeMonths) {
		this.useBeforeMonths = useBeforeMonths;
	}
	public LocalDate getExpiryDate() {
		return expiryDate;
	}
	public void setExpiryDate(LocalDate expiryDate) {
		this.expiryDate = expiryDate;
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", description=" + description + ", qty=" + qty + ", price=" + price
				+ ", manufactureDate=" + manufactureDate + ", useBeforeMonths=" + useBeforeMonths + ", expiryDate="
				+ expiryDate + "]";
	}
	public Product() {
		super();
	}

	
}
