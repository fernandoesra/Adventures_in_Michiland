package com.mygdx.tiles;

import com.mygdx.pruebafergdx.IPlayerAction;
import com.mygdx.pruebafergdx.Player;
import com.mygdx.utils.AleatoricName;

public class Cave implements IPlayerAction{
	String name;
	double money;
	
	public Cave() {
		AleatoricName newName = new AleatoricName();
		money = (Math.random() * 101 + 1);
		name = newName.toString();
	}
	
	public double getMoney() {
		return money;
	}
	
	public String discoverCave() {
		return ""
				+ "#####################################\r\n"
				+ "#    YOU DISCOVERED A NEW CAVE!     #\r\n"
				+ "#####################################\r\n"
				+ "  Cave of "+name+"\r\n"
				+ "  Loot:\r\n"
				+ "     Money: "+(Math.floor(money*100.0d) / 100.0d)+" Michidolares\r\n"
				+ "#####################################";
	}
	
	public String toString() {
		return "You have already discovered the cave of "+name;
	}

	@Override
	public void executeAction(Player player) {
		
	}

}
