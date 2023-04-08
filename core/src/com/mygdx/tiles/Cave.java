package com.mygdx.tiles;

import com.mygdx.pruebafergdx.IPlayerAction;
import com.mygdx.pruebafergdx.Player;

public class Cave implements IPlayerAction{
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
		return "Name: "+name+" Money: "+(Math.floor(money*100.0d) / 100.0d)+" Michidolares";
	}

	@Override
	public void executeAction(Player player) {
		
	}

}
