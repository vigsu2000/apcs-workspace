/* 
 * AP(r) Computer Science GridWorld Case Study:
 * Copyright(c) 2005-2006 Cay S. Horstmann (http://horstmann.com)
 *
 * This code is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation.
 *
 * This code is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * @author Cay Horstmann
 * @author Chris Nevison
 * @author Barbara Cloud Wells
 */

import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.BoxBug;
import info.gridworld.actor.CircleBug;
import info.gridworld.actor.DancingBug;
import info.gridworld.actor.SpiralBug;
import info.gridworld.actor.ZBug;
import info.gridworld.grid.Location;

import java.awt.Color;

/**
 * This class runs a world that contains box bugs. <br />
 * This class is not tested on the AP CS A and AB exams.
 */
public class BoxBugRunner
{
    public static void main(String[] args)
    {
        ActorWorld world = new ActorWorld();
        BoxBug alice = new BoxBug(6);
        alice.setColor(Color.ORANGE);
        BoxBug d = new BoxBug(2);
        ZBug b = new ZBug(3);
        CircleBug c = new CircleBug(4);
        SpiralBug s = new SpiralBug(3);
        world.add(new Location(5, 5), d);
        world.add(new Location(5, 3), b);
        world.add(new Location(2,2), c);
        world.add(new Location(6,6), s);
        world.show();
    }
}