package info.gridworld.actor;

import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

/**
 * A <code>BoxBug</code> traces out a square "box" of a given size. <br />
 * The implementation of this class is testable on the AP CS A and AB exams.
 */
public class ChallengeBug extends Bug
{
	private int turns;

    /**
     * Constructs a box bug that traces a square of a given side length
     * @param length the side length
     */
    public ChallengeBug()
    {
    	turns = 0;
    }
    
    public boolean hasToMove() {
    	return (turns == 8);
    }
    
    public boolean wantsToMove() {
    	Grid<Actor> gr = getGrid();
        if (gr == null)
            return false;
        Location loc = getLocation();
        Location next = loc.getAdjacentLocation(getDirection());
        if (!gr.isValid(next))
            return false;
        Actor neighbor = gr.get(next);
        return (neighbor == null);
        // ok to move into empty location or onto flower
        // not ok to move onto any other actor
    }

    public void act() {
    	if(canMove() && (hasToMove() || wantsToMove())) {
    		move();
    		turns = 0;
    	}
    	
    	else {
    		turn();
    		turns++;
    	}
    }
}