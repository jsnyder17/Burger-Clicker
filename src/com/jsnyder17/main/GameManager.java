package com.jsnyder17.main;

import java.util.ArrayList;

import com.jsnyder17.burgercreators.BurgerCreator;
import com.jsnyder17.other.Pair;

public class GameManager {
	private int burgers;
	private int money;
	private ArrayList<BurgerCreator> burgerCreators;
	private ArrayList<Pair<String, Integer>> status;
	
	
	public GameManager() {
		burgers = 0;
		money = 0;
		burgerCreators = new ArrayList<BurgerCreator>();
		status = new ArrayList<Pair<String, Integer>>();
	}
	
	public int getBurgers() {
		return burgers;
	}
	public int getMoney() {
		return money;
	}
	public ArrayList<BurgerCreator> getBurgerCreators() {
		return burgerCreators;
	}
	public ArrayList<Pair<String, Integer>> getStatus() {
		return status;
	}
	
	public void setBurgers(int burgers) {
		this.burgers = burgers;
	}
	public void addBurgerCreator(BurgerCreator burgerCreator) {
		burgerCreators.add(burgerCreator);
		status.add(new Pair<String, Integer>(burgerCreator.getName(), burgerCreator.getBurgersPerSecond()));
	}
	
	public void incBurgers(int amount) {
		burgers += amount;
	}
	public void incMoney(int amount) {
		money += amount;
	}
	
	public String getStatusString() {
		String statusString = "";
		
		for (Pair<String, Integer> p : status) {
			statusString += p.getLeft() + ": " + p.getRight() + " burgers per second. \n";
		}
		
		return statusString;
	}
}
