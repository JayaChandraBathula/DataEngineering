package com.dataengineering;

public class PharmacyObject implements Comparable<PharmacyObject>{

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

	@Override
	public int compareTo(PharmacyObject o) {
		if(this.cost<o.getCost()) {
			return -1;
		}
		else if(this.cost>o.getCost()){
			return 1;
		}
		else
			return 0;
	}

	public String  toString() {
		return "Medicine Name: "+this.medicine
			   +" Number of subscribers: "+this.getName()
			   +" Cost: "+this.getCost();
	}
}
