package com.cognizant.Examples;

public class Compass {		//distance
	
	double treasure1Distance;
	double treasure2Distance;
	double treasure3Distance;

	public double distance(Person p, Treasure t) {
		return Math.sqrt(((p.getX() - t.getX())*(p.getX() - t.getX())) + ((p.getY() - t.getY())*(p.getY() - t.getY())));
	}
	
	public double minTreasureDistance() {
		double minDistance = 0;
		
		treasure1Distance = distance(Swamp.person, Swamp.treasure1);
		treasure2Distance = distance(Swamp.person, Swamp.treasure2);
		treasure3Distance = distance(Swamp.person, Swamp.treasure3);
		
		if(Swamp.treasure1NotFound && Swamp.treasure2NotFound && Swamp.treasure3NotFound) {
		minDistance = Math.min(treasure1Distance, treasure2Distance);
		minDistance = Math.min(minDistance, treasure3Distance);
		}
		else if (Swamp.treasure1NotFound && Swamp.treasure2NotFound && !Swamp.treasure3NotFound) {
			minDistance = Math.min(treasure1Distance, treasure2Distance);
		}
		else if (!Swamp.treasure1NotFound && Swamp.treasure2NotFound && Swamp.treasure3NotFound) {
			minDistance = Math.min(treasure3Distance, treasure2Distance);
		}
		else if (Swamp.treasure1NotFound && !Swamp.treasure2NotFound && Swamp.treasure3NotFound) {
			minDistance = Math.min(treasure1Distance, treasure3Distance);
		}
		else if (Swamp.treasure1NotFound && !Swamp.treasure2NotFound && !Swamp.treasure3NotFound) {
			minDistance = treasure1Distance;
		}
		else if (!Swamp.treasure1NotFound && Swamp.treasure2NotFound && !Swamp.treasure3NotFound) {
			minDistance = treasure2Distance;
		}
		else if (!Swamp.treasure1NotFound && !Swamp.treasure2NotFound && Swamp.treasure3NotFound) {
			minDistance = treasure3Distance;
		}
		
		return minDistance;
	}
	
	public double distance2(Person p, Monster m) {
		return Math.sqrt(((p.getX() - m.getX())*(p.getX() - m.getX())) + ((p.getY() - m.getY())*(p.getY() - m.getY())));
	}
	
	public double distance3(Person p, SwampExit s) {
		return Math.sqrt(((p.getX() - s.getX())*(p.getX() - s.getX())) + ((p.getY() - s.getY())*(p.getY() - s.getY())));
	}
	
}
