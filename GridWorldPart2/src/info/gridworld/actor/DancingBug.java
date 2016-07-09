package info.gridworld.actor;

/**
 * A <code>BoxBug</code> traces out a square "box" of a given size. <br />
 * The implementation of this class is testable on the AP CS A and AB exams.
 */
public class DancingBug extends Bug
{
    private int turnsMade;
    private int[] turns;

    /**
     * Constructs a box bug that traces a square of a given side length
     * @param length the side length
     */
    public DancingBug(int[] turns)
    {
        this.turns = turns;
        turnsMade = 0;
    }

    public void act() {
    	for(int i = 0; i < turns[turnsMade]; i++){
    		turn();
    	}
    	turnsMade++;
    	if(turnsMade >= turns.length)
    		turnsMade = 0;
    	super.act(); 
    }
}
