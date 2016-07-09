import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.DancingBug;
import info.gridworld.grid.Location;

import java.awt.Color;

/**
 * This class runs a world that contains box bugs. <br />
 * This class is not tested on the AP CS A and AB exams.
 */
public class DancingBugRunner
{
    public static void main(String[] args)
    {
        ActorWorld world = new ActorWorld();
        DancingBug d = new DancingBug(new int[] {1,2,2,3,3,2,2,1});
        world.add(new Location(5, 5), d);
        world.show();
    }
}