package org.lti.dto;

import java.time.LocalDate;

public class ProductDto {

	private Integer id;
	private Integer useBeforeMonths;
	private LocalDate expiryDate;
	
	private String description;

	private Integer qty;
	
	private double price;
	
	private LocalDate manufactureDate;
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
	
}
