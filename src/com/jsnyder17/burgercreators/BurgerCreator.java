package com.jsnyder17.burgercreators;

public class BurgerCreator {
	private String name;
	private int burgersPerSecond;
	private int price;
	
	public BurgerCreator() {
		name = "";
		burgersPerSecond = 0;
		price = 0;
	}
	public BurgerCreator(String name, int burgersPerSecond, int price) {
		this.name = name;
		this.burgersPerSecond = burgersPerSecond;
		this.price = price;
	}
	
	public String getName() {
		return name;
	}
	public int getBurgersPerSecond() {
		return burgersPerSecond;
	}
	public int getPrice() {
		return price;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public void setBurgersPerSecond(int burgersPerSecond) {
		this.burgersPerSecond = burgersPerSecond;
	}
	public void setPrice(int price) {
		this.price = price;
	}
}
