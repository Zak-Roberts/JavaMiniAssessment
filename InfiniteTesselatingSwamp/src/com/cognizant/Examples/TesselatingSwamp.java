package com.cognizant.Examples;

import java.text.DecimalFormat;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class TesselatingSwamp {

	static TesselatingSwamp swamp = new TesselatingSwamp();
	
	public static void main(String[] args) {
		
		swamp.swampGrid();
		
		System.out.println("You find yourself in a grey, murky swamp, with nothing but what appears to be a compass.");
		try {
			TimeUnit.MILLISECONDS.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println(swamp.findI() + " " + swamp.findJ());
		
		swamp.direction();

	}
		
	String[][] swamp1 = new String [20][20];
	
	public void swampGrid() {
		
		int max = 10;
		int min = 0;
		Random rand = new Random();
		int rand1 = min + rand.nextInt(max);
		int rand2 = min + rand.nextInt(max);
		
		
		for (int i = 0; i<swamp1.length;i++){
			   for (int j = 0; j <swamp1.length;j++){
			      swamp1[i][j] = "-";  // Initialise the cell
			      
			      
			      swamp.addFeature("user", rand1, rand2);
//			      swamp.addFeature("user", 11, 15);
			      swamp.addFeature("note", 12,15);
			      swamp.addFeature("note", 15,12);
			      swamp.addFeature("note", 18, 15);
			      swamp.addFeature("note", 15, 18);
			      swamp.addFeature("treasure", 15,15); //adds treasure to the board
			      
			      System.out.print("[" +swamp1[i][j] + "]"); // Display the content of cell board
			   }
			   System.out.println();  // go to next line
			}		
	}
	
	public void addFeature(String feature, int num1, int num2) {
		
		if (feature.equals("treasure")){
			swamp1[num1][num2] = Features.displayTreasure();
		}
		if(feature.equals("note")) {
			swamp1[num1][num2] = Features.displayNote();
		}
		if(feature.equals("user")) {
			swamp1[num1][num2] = Features.user();
		}
	}
	
//	public void action() {
//		
//		Scanner scanner = new Scanner(System.in);
//		System.out.println("What would you like to do? (move, inspect)");
//		String userInput = scanner.next();
//		
//		if(userInput.equals("move") || userInput.equals("Move")) {
//			swamp.direction();
//		}
//		if(userInput.equals("inspect") || userInput.equals("Inspect")) {
//			swamp.inspect();
//		}
//		else {
//			System.out.println("You can't perform that action");
//		}
//		scanner.close();
//	}
	
//	public void inspect() {
//		
//	}
	
	public String input() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Which direction do you want to go? (north, south, east, or west)");
		String userInput = scanner.nextLine();
		return userInput;
	}
	
	public void direction() {
		
		swamp.findI();
		swamp.findJ();
		
		boolean g = true;
		boolean bool = true;
		
		if (swamp.swamp1 [15][15].contains("You've found the treasure (and the exit), well done!")){
			bool = true;
		}
		else if (swamp.distanceToTreasure() == 0){
			System.out.println("You've found the treasure (and the exit), well done!");
			bool = false;
		}
		while(bool) {	
			while(g) {
					
					String input = swamp.input();
					DecimalFormat df = new DecimalFormat("##.##");
					
					if (input.equals("North") || input.equals("north")) {
						System.out.println("You've moved north");
						swamp.swap(swamp1, swamp.findI(), swamp.findJ(), (swamp.findI() - 1), swamp.findJ());
						System.out.println(swamp.findI() + " " + swamp.findJ());
						System.out.println("You are " + df.format(swamp.distanceToTreasure())  + " from the treasure");
//						g = false;
						continue;
					}
					else if (input.equals("South") ||input.equals("south")) {
						System.out.println("You've moved south");
						swamp.swap(swamp1, swamp.findI(), swamp.findJ(), (swamp.findI() + 1), swamp.findJ());
						System.out.println(swamp.findI() + " " + swamp.findJ());
						System.out.println("You are " + df.format(swamp.distanceToTreasure()) + " from the treasure");
//						g = false;
						continue;
					}
					else if (input.equals("East") || input.equals("east")) {
						System.out.println("You've moved east");
						swamp.swap(swamp1, swamp.findI(), swamp.findJ(), swamp.findI(), (swamp.findJ() + 1));
						System.out.println(swamp.findI() + " " + swamp.findJ());
						System.out.println("You are " + df.format(swamp.distanceToTreasure()) + " from the treasure");
//						g = false;
						continue;
					}
					else if (input.equals("West") || input.equals("west")) {
						System.out.println("You've moved west");
						swamp.swap(swamp1, swamp.findI(), swamp.findJ(), swamp.findI(), (swamp.findJ() - 1));
						System.out.println(swamp.findI() + " " + swamp.findJ());
						System.out.println("You are " + df.format(swamp.distanceToTreasure()) + " from the treasure");
//						g = false;
						continue;
					}
					else {
						System.out.println("You can't move in that direction");
						continue;
					}
				}
		}	

	}
	
    public void swap(Object[][] array, int i1, int j1, int i2, int j2) {
    	Object tempObject = array[i1][j1];
    	array[i1][j1] = array[i2][j2];
    	array[i2][j2] = tempObject;
    }
	 
	 public int findI(){
		 
		String target1 = "user";
	 	for (int i = 0; i < swamp.swamp1.length; i++)
	 		for(int j = 0; j < swamp.swamp1.length; j++) {
	 			if (swamp.swamp1[i][j] == target1) {
	 			return i;}}

	 	return -1;
	 }
	 
	 public int findJ(){
		 
		String target1 = "user";
	 	for (int i = 0; i < swamp.swamp1.length; i++)
	 		for(int j = 0; j < swamp.swamp1.length; j++) {
	 			if (swamp.swamp1[i][j] == target1) {
	 			return j;}}

	 	return -1;
	 }
	 
	 public int findITreasure(){
		 
		String target1 = "treasure";
	 	for (int i = 0; i < swamp.swamp1.length; i++)
	 		for(int j = 0; j < swamp.swamp1.length; j++) {
	 			if (swamp.swamp1[i][j] == target1) {
	 			return i;}}

	 	return -1;
	 }
	 
	 public int findJTreasure(){
		 
		String target1 = "You've found the treasure (and the exit), well done!";
	 	for (int i = 0; i < swamp.swamp1.length; i++)
	 		for(int j = 0; j < swamp.swamp1.length; j++) {
	 			if (swamp.swamp1[i][j] == target1) {
	 			return j;}}

	 	return -1;
	 }
	 
	 public double distanceToTreasure() {
		 
		 int i1 = swamp.findI();
		 int i2 = swamp.findITreasure();
		 int j1 = swamp.findJ();
		 int j2 = swamp.findJTreasure();
		 
		 return Math.sqrt(((i2-i1)*(i2-i1)) + ((j2-j1)*(j2-j1)));
	 }
	 
	 public String foundNote() {
		 if (!(swamp.swamp1[12][15].contains("You are on the right track..."))){
			 return "You are on the right track...";
		 }
		 else if (!(swamp.swamp1[15][12].contains("You are on the right track..."))){
			 return "You are on the right track...";
		 }
		 else if (!(swamp.swamp1[15][18].contains("You are on the right track..."))){
			 return "You are on the right track...";
		 }
		 else if (!(swamp.swamp1[18][15].contains("You are on the right track..."))){
			 return "You are on the right track...";
		 }
		 return "";
	 }
	 
}
