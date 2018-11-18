package com.cognizant.Examples;

import java.util.concurrent.TimeUnit;

public class Person {

	private int x;
	private int y;
	
	Person(){
		this.setX(0);
		this.setY(0);
	}
	
	public String goNorth() {
		setY(getY() + 1);
		return "You moved north";
	}
	
	public String goSouth() {
		setY(getY() - 1);
		return "You moved south";
	}
	
	public String goWest() {
		setX(getX() - 1);
		return "You moved west";
	}
	
	public String goEast() {
		setX(getX() + 1);
		return "You moved east";
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
	
	public int healthPoints() {
		int healthPoints = 3;
		
		for(int i = 0; i<Swamp.monsterEncounters.size(); i++) {
			healthPoints -= 1;
		}

		if(healthPoints == 0) {			
			System.out.println("\nYou lost all your health points, game over!" );
			try {
				TimeUnit.SECONDS.sleep(2);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Bad luck, thanks for playing!");
			System.exit(healthPoints);
		}
		
		return healthPoints;
	}
}
