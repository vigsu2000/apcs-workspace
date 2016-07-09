import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Jumper;
import info.gridworld.actor.Rock;
import info.gridworld.grid.Location;

public class JumperBugRunner {

	public static void main(String[] args)
    {
        ActorWorld world = new ActorWorld();
        Jumper b = new Jumper(false);
        b.setDirection(Location.EAST);
        world.add(new Location(5,9), b);
        world.add(new Location(5,5),new Rock());
        world.show();
    }

}
