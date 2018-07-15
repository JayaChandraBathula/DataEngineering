package com.dataengineering;

public class PharmacyObject {

	private String name;
	private String medicine;
	private double cost;

	public PharmacyObject(String name, String medicine, double cost) {
		this.name = name;
		this.medicine = medicine;
		this.cost = cost;
	}

	public String getName() {
		return name;
	}

	public String getMedicine() {
		return medicine;
	}

	public double getCost() {
		return cost;
	}


}
