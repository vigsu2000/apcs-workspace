import java.awt.Color;

import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Bug;
import info.gridworld.actor.Jumper;
import info.gridworld.grid.Location;

public class JumperRunner {
	
	public static void main (String Args[]){
		ActorWorld world = new ActorWorld();
		Jumper j = new Jumper(); 
		world.add(new Location(5,5), j);
		world.add(new Location(3, 5), new Bug(Color.GREEN));
		world.show();
	}

}
