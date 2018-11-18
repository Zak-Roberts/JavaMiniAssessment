package com.cognizant.Examples;

import java.text.DecimalFormat;
import java.util.ArrayList;
//import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Swamp {		

	static ArrayList <Integer> monsterEncounters = new ArrayList <Integer>();
	static ArrayList <Integer> treasures = new ArrayList <Integer>();
	static Person person = new Person();
	Compass compass = new Compass();
	static Treasure treasure1 = new Treasure(5,5);
	static Treasure treasure2 = new Treasure(2,3);
	static Treasure treasure3 = new Treasure(7,6);
	Monster monster1 = new Monster(3,4);
	Monster monster2 = new Monster(8,9);
	Monster monster3 = new Monster(5,7);
	SwampExit exit = new SwampExit(10,10);

	static boolean treasure1NotFound = true;		
	static boolean treasure2NotFound = true;
	static boolean treasure3NotFound = true;
	
	public void intro() {
		
//		int max = 20; 
//		int min = 0; 
//		Random rand = new Random(); 
//		int rand1 = min + rand.nextInt(max); 
//		int rand2 = min + rand.nextInt(max); 
		
		System.out.println("You find yourself in a grey murky swamp, filled with strange noises..." );
		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("You appear to be alone, but for how long? You need to find the treasures to escape, but beware of the monsters you may encounter along the way...");
		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("You check your pockets, and find an unusual-looking old compass. This, along with your health points are all you have.. \n");
		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		
		while((person.getX() != exit.getX() || person.getY() != exit.getY()) || Treasure.treasureCollect() < 3) {
			String input = inputMethod();
			switch(input) {
			case "NORTH":
			case "N":
				System.out.println(person.goNorth());
				break;
			case "EAST":
			case "E":
				System.out.println(person.goEast());
				break;
			case "SOUTH":
			case "S":
				System.out.println(person.goSouth());
				break;
			case "WEST":
			case "W":
				System.out.println(person.goWest());
				break;
			case "HP":
				System.out.println("You have " + person.healthPoints() + " health points");
				break;
			case "COMPASS":
				DecimalFormat df = new DecimalFormat("##.##");
				if (treasures.size() < 3) {
					System.out.println("Your compass says you are " + df.format(compass.minTreasureDistance()) + "m away from a treasure, but you're also " + df.format(compass.distance2(person, monster1)) + "m away from a monster!");
				}
				else if (treasures.size() == 3){
					System.out.println("Your compass says you are " + df.format(compass.minTreasureDistance()) + "m away from the exit, but you're also " + df.format(compass.distance2(person, monster1)) + "m away from a monster!");

				}
//				System.out.println("You are " + df.format(compass.distance(person, treasure2)) + "m away from another treasure");
				break;
			case "TREASURE":
				System.out.println("You have collected " + Treasure.treasureCollect() + " treasures out of 3");
				break;
			default:
				System.out.println("That input isn't recognised, please try again.");
			}
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
//			if((person.getX() == treasure1.getX() && person.getY() == treasure1.getY()) || (person.getX() == treasure2.getX() && person.getY() == treasure2.getY()) || (person.getX() == treasure3.getX() && person.getY() == treasure3.getY())) {
//				treasures.add(1);
//				System.out.println("You found a treasure!");
//				try {
//					TimeUnit.SECONDS.sleep(2);
//				} catch (InterruptedException e) {
//					e.printStackTrace();
//				}
//				if(treasures.size() == 1) {
//					System.out.println("Only 2 more left to find before you can escape");
//					try {
//						TimeUnit.SECONDS.sleep(2);
//					} catch (InterruptedException e) {
//						e.printStackTrace();
//					}
//				}
//				else if (treasures.size() == 2) {
//					System.out.println("Only 1 more left to find before you can escape");
//					try {
//						TimeUnit.SECONDS.sleep(2);
//					} catch (InterruptedException e) {
//						e.printStackTrace();
//					}
//				}
//				else if (treasures.size() == 3) {
//					System.out.println("You found the last piece of treasure! Now to find the exit...");
//					try {
//						TimeUnit.SECONDS.sleep(2);
//					} catch (InterruptedException e) {
//						e.printStackTrace();
//					}
//				}
//			}
			
			if (person.getX() == exit.getX() && person.getY() == exit.getY() && Treasure.treasureCollect() < 3) {
				System.out.println("You have found the swamp exit, but still need to find " + (3 -Treasure.treasureCollect()) + " more treasure before you can leave!");
				try {
					TimeUnit.SECONDS.sleep(2);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
			if(treasure1NotFound && person.getX() == treasure1.getX() && person.getY() == treasure1.getY()){
				treasure1NotFound = false;
				treasures.add(1);
				System.out.println("You found a treasure!");
				try {
					TimeUnit.SECONDS.sleep(2);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				if(treasures.size() == 1) {
					System.out.println("Only 2 more left to find before you can escape");
					try {
						TimeUnit.SECONDS.sleep(2);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				else if (treasures.size() == 2) {
					System.out.println("Only 1 more left to find before you can escape");
					try {
						TimeUnit.SECONDS.sleep(2);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				else if (treasures.size() == 3) {
					System.out.println("You found the last piece of treasure! Now to find the exit...");
					try {
						TimeUnit.SECONDS.sleep(2);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
			
			if(treasure2NotFound && person.getX() == treasure2.getX() && person.getY() == treasure2.getY()){
				treasure2NotFound = false;
				treasures.add(1);
				System.out.println("You found a treasure!");
				try {
					TimeUnit.SECONDS.sleep(2);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				if(treasures.size() == 1) {
					System.out.println("Only 2 more left to find before you can escape");
					try {
						TimeUnit.SECONDS.sleep(2);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				else if (treasures.size() == 2) {
					System.out.println("Only 1 more left to find before you can escape");
					try {
						TimeUnit.SECONDS.sleep(2);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				else if (treasures.size() == 3) {
					System.out.println("You found the last piece of treasure! Now to find the exit...");
					try {
						TimeUnit.SECONDS.sleep(2);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
			
			if(treasure3NotFound && person.getX() == treasure3.getX() && person.getY() == treasure3.getY()){
				treasure3NotFound = false;
				treasures.add(1);
				System.out.println("You found a treasure!");
				try {
					TimeUnit.SECONDS.sleep(2);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				if(treasures.size() == 1) {
					System.out.println("Only 2 more left to find before you can escape");
					try {
						TimeUnit.SECONDS.sleep(2);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				else if (treasures.size() == 2) {
					System.out.println("Only 1 more left to find before you can escape");
					try {
						TimeUnit.SECONDS.sleep(2);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				else if (treasures.size() == 3) {
					System.out.println("You found the last piece of treasure! Now to find the exit...");
					try {
						TimeUnit.SECONDS.sleep(2);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
			
			if ((person.getX() == monster1.getX() && person.getY() == monster1.getY()) || (person.getX() == monster2.getX() && person.getY() == monster2.getY()) || (person.getX() == monster3.getX() && person.getY() == monster3.getY())) {
				monsterEncounters.add(1);
				System.out.println("You found a monster! It hit you and you lost 1 health point.");
				try {
					TimeUnit.SECONDS.sleep(2);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				if (person.healthPoints() > 1) {
					System.out.println("You'd better move away from here quickly if you don't want to be hit again!");
				}
				else if(person.healthPoints() == 1) {
					try {
						TimeUnit.SECONDS.sleep(1);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println("You only have 1 health point remaining, you'd better tread carefully...");
				}
				try {
					TimeUnit.SECONDS.sleep(2);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		System.out.println("You found all the treasure and the swamp exit, you win!");
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Congratulations, and thanks for playing!");
	}

	
	public String inputMethod() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("\nWhich direction do you want to go, north, east, south, or west? (use 'compass' to check your compass, 'treasure' to check your treasures and 'hp' to check your health points)");
		String userInput = scanner.nextLine();
		String userInput1 = userInput.toUpperCase(); 
		return userInput1;
	}	
	
}
