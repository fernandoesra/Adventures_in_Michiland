package com.mygdx.pruebafergdx;

public class Inventory {
	double money;
	
	public Inventory() {
		money = 0;
	}
	
	public void addMoney(double money) {
		this.money += money;
	}
	
	public String toString() {
		return "Money: "+money;
	}

}
