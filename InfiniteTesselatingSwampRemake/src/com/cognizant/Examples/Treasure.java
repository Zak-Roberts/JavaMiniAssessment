package com.cognizant.Examples;

public class Treasure {

	private int x;
	private int y;
	
	Treasure(int x, int y){
		this.setX(x);
		this.setY(y);
	}

	public Treasure() {
		// TODO Auto-generated constructor stub
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	public static int treasureCollect() {
		int treasures = Swamp.treasures.size();
		
		return treasures;
	}
	
}
