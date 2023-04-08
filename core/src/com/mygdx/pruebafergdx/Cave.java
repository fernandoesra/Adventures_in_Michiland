package com.mygdx.pruebafergdx;

public class Cave {
	String name;
	double money;
	
	public Cave() {
		money = (Math.random() * 101 + 1);
		name = "Cave of ";
	}
	
	public double getMoney() {
		return money;
	}
	
	public String toString() {
		return "Name: "+name+" Money: "+money;
	}

}
