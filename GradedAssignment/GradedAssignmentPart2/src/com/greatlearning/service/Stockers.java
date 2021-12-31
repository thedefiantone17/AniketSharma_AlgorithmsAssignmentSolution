package com.greatlearning.service;

public class Stockers {
	private double price;
	private boolean rise;

	public Stockers(double price, boolean rise) {
		this.price = price;
		this.rise = rise;
	}

	public double getPrice() {
		return this.price;
	}
	
	public boolean getRise() {
		return this.rise;
	}
}
