package com.mygdx.pruebafergdx;

// (Math.floor(money*100.0d) / 100.0d)

public class Inventory {
	double money;
	Minimap minimap;
	
	public Inventory(int x, int y) {
		money = 0;
		this.minimap = new Minimap();
	}
	
	public void addMoney(double money) {
		this.money += money;
	}
	
	public void seeMap() {
		minimap.seeMinimap(null);
	}
	
	public String toString() {
		String spaces = "";
		
		if (money < 10) {
			spaces = "    ";
		}
		
		if (money > 10 && money < 100) {
			spaces = "   ";
		}
		
		if (money > 100 && money < 1000) {
			spaces = "  ";
		}
		
		if (money > 1000 && money < 10000) {
			spaces = " ";
		}
		
		String endMoney = (Math.floor(money*100.0d) / 100.0d)+"";
		char endMoneyChar[] = endMoney.toCharArray();
		
		if (endMoneyChar[endMoneyChar.length-2] == '.') {
			spaces += " ";
		}
		
		return ""
				+ "----------------------------\r\n"
				+ "||    ACTUAL INVENTORY    ||\r\n"
				+ "----------------------------\r\n"
				+ "||                        ||\r\n"
				+ "||  Michidolares: "+(Math.floor(money*100.0d) / 100.0d)
				+""
				+spaces+"||\r\n"
				+ "||                        ||\r\n"
				+ "----------------------------";
	}

}
