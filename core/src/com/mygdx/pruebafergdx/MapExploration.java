package com.mygdx.pruebafergdx;

import com.mygdx.tiles.Cave;
import com.mygdx.tiles.House;
import com.mygdx.tiles.Man;

public class MapExploration {
	// Atributes
	Object mapExploration[][];
	
	// Constructor
	public MapExploration(int x, int y) {
		mapExploration = new Object[x][y];
	}
	
	// Get and Sett
	public Object getInterior(int x, int y) {
		return mapExploration[x][y];
	}
	
	// Methods
	public void createCave(int x, int y) {
		Cave c1 = new Cave();
		mapExploration[x][y] = c1;
	}
	
	public void createHouse(int x, int y) {
		House h1 = new House();
		mapExploration[x][y] = h1;
	}
	
	public void createMan(int x, int y) {
		Man m1 = new Man();
		mapExploration[x][y] = m1;
	}

}
