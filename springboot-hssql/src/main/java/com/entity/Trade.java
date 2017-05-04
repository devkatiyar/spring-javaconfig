package com.entity;

public class Trade {

	private String unit;
	private String stock;

	public Trade(String unit, String stock) {
		this.unit = unit;
		this.stock = stock;
	}

	public Trade() {

	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getStock() {
		return stock;
	}

	public void setStock(String stock) {
		this.stock = stock;
	}

}
