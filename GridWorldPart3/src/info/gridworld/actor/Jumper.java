package info.gridworld.actor;

import java.awt.Color;

import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

public class Jumper extends Bug{

	private int killCount;
	private int stepCount;
	private boolean hasMoodSwings;

	
	/**
	 * Creates a Jumper object without mood swings, a killCount and stepCount set to 0, and the color red
	 */
	public Jumper (){
		super();
		killCount = 0;
		stepCount = 0;
		hasMoodSwings = false;
	}

	/**
	 * Creates a Jumper object with or without mood swings, a killCount and stepCount set to 0, and the color red
	 * @param moodSwings determines whether or not the Jumper has mood swings (true if it does, false if not)
	 */
	public Jumper(boolean moodSwings){
		super();
		killCount = 0;
		stepCount = 0;
		hasMoodSwings = moodSwings;
	}

	/**
	 * Creates a Jumper object with or without mood swings, a killCount and stepCount set to 0, and the specified color
	 * @param c sets the Jumper's color to the specified color
	 * @param moodSwings determines whether or not the Jumper has mood swings (true if it does, false if not)
	 */
	public Jumper(Color c, boolean moodSwings){
		super(c);
		killCount = 0;
		stepCount = 0;
		hasMoodSwings = moodSwings;
	}

	/**
	 * Determines one step of the Jumper
	 * - The jumper takes the place if there is a flower or a rock and removes it from the grid. It adds to the kill count of the jumper, reducing the step count by 10, but steps never less than 0.
	 * - If there is an actor where the Jumper will jump to, it removes the actor from that cell and takes its place, increasing the kill count, and changing the color if it is not a flower or a rock, reducing the step count by 10, but steps never less than 0.
	 * - If the Jumper jumps off the grid, it would jump and re-appear on the opposite side of the grid facing the same direction.
	 * - If two Jumpers encounter each other with identical killCounts, they will remove each other from the grid. Otherwise, the one with the fewer kill counts dies, and the one with the greater number of kills lives on adds to its kill count.
	 * - If the kill count is 50, everything is removed from the grid except for the Jumper and the Jumper is printed out. If the steps field is greater than 500, the jumper removes itself from grid, each kill reduces the step count by 10, but steps cannot be less than 0. If it has a mood swing, there's a 50% chance that it will turn in any random direction specified by the fields of the location class. The other 50% of the time, it would move normally like it doesn't have a mood swing.
	 */
	public void act(){
		if(hasMoodSwings) {
			performMoodSwing();
		}
		Grid<Actor> gr = getGrid();
		Location loc = getLocation();
		Location nextLoc = loc.getAdjacentLocation(getDirection()).getAdjacentLocation(getDirection());
		if(gr.isValid(nextLoc)) {
			Actor obj = gr.get(nextLoc);
			if(obj instanceof Jumper) {
				Jumper j = (Jumper)obj;
				if(killCount == j.getKillCount()) {
					removeSelfFromGrid();
					obj.removeSelfFromGrid();
				}
				else if(killCount < j.getKillCount()) {
					removeSelfFromGrid();
				}
				else if(killCount > j.getKillCount()) {
					setColor(obj.getColor());
					obj.removeSelfFromGrid();
					moveTo(nextLoc);
					killCount++;
					reduceSteps();
				}
			}
			else if(obj instanceof Bug) {
				Bug b = (Bug)obj;
				Color c = b.getColor();
				b.removeSelfFromGrid();
				setColor(c);
				moveTo(nextLoc);
				killCount++;
				reduceSteps();
			}
			else if(obj instanceof Rock || obj instanceof Flower) {
				killCount++;
				reduceSteps();
				moveTo(nextLoc);
			}
			else {
				moveTo(nextLoc);
				stepCount++;
			}
		}
		else {
			int column = getLocation().getCol();
			int row = getLocation().getRow();
			if(getDirection() == Location.WEST) {
				if(column == 0) {
					moveTo(new Location(row, gr.getNumCols()-2));
				}
				else if(column == 1) {
					moveTo(new Location(row, gr.getNumCols()-1));
				}
			}
			else if(getDirection() == Location.EAST) {
				if(column == gr.getNumCols()-1) {
					moveTo(new Location(row, 1));
				}
				else if(column == gr.getNumCols()-2) {
					moveTo(new Location(row, 0));
				}
			}
			else if(getDirection() == Location.NORTH) {
				if(row == 0) {
					moveTo(new Location(gr.getNumRows()-2, column));
				}
				else if(row == 1) {
					moveTo(new Location(gr.getNumRows()-1, column));
				}
			}
			else if(getDirection() == Location.SOUTH) {
				if(row == gr.getNumRows()-1) {
					moveTo(new Location(1, column));
				}
				else if(column == gr.getNumRows()-2) {
					moveTo(new Location(0, column));
				}
			}
			else if(getDirection() == Location.NORTHEAST) {
				try {
					moveTo(new Location(column+1, row-1));
				}
				catch(Exception e) {
					moveTo(new Location(column-1, row+1));
				}
			}
			else if(getDirection() == Location.NORTHWEST) {
				if(column == 0) {
					int x = gr.getNumRows() - row - 2;
					moveTo(new Location(row+x, column+x));
				}
				else if(row == 0) {
					int x = gr.getNumCols() - column - 2;
					moveTo(new Location(row+x, column+x));
				}
				else if(column == 1) {
					int x = gr.getNumRows() - row - 1;
					moveTo(new Location(row+x, column+x));
				}
				else if(row == 1) {
					int x = gr.getNumCols() - column - 1;
					moveTo(new Location(row+x, column+x));
				}
			}
			else if(getDirection() == Location.SOUTHWEST) {
				if(row == gr.getNumRows()-1 ||  column == 0) {
					moveTo(new Location(column+1, row-1));
				}

				else if(row == gr.getNumRows()-2 || column == 1) {
					moveTo(new Location(column-1, row+1));
				}
			}
			else if(getDirection() == Location.SOUTHEAST) {
				if(row == gr.getNumRows()-1) {
					moveTo(new Location(row-column+1, 1));
				}
				else if(column == gr.getNumCols()-1) {
					moveTo(new Location(1, column-row+1));
				}
				else if(row == gr.getNumRows()-2) {
					moveTo(new Location(row-column, 0));
				}
				else if(column == gr.getNumCols()-2) {
					moveTo(new Location(0, column-row));
				}
			}
			stepCount++;
		}
		if(stepCount == 500) {
			removeSelfFromGrid();
		}
		else if(killCount == 50) {
			killEverything();
		}
	}

	/**
	 * Moves the Jumper two spaces in the direction that it is facing
	 */
	public void move(){
		Location loc = getLocation();
		moveTo(loc.getAdjacentLocation(getDirection()).getAdjacentLocation(getDirection()));
	}
	
	/**
	 * Turns the Jumper 45 degrees to the right
	 */
	public void turn(){
		super.turn();
	}

	/**
	 * If the Jumper initially has mood swings it will change to not having mood swings. If the Jumper initially does not have mood swings it will change to having mood swings
	 */
	public void changeMood(){
		if(hasMoodSwings) {
			hasMoodSwings = false;
		}
		else {
			hasMoodSwings = true;
		}
	}

	/**
	 * 
	 * @return the killCount of the Jumper
	 */
	public int getKillCount(){
		return killCount;

	}
	
	/**
	 * Removes all actors from the grid other than itself
	 */
	public void killEverything(){
		Grid<Actor> gr = getGrid();
		int[][] grid = new int[gr.getNumRows()][gr.getNumCols()];
		for(int i = 0; i < grid.length; i++) {
			for(int j = 0; j < grid.length; j++) {
				if(gr.get(new Location(i, j)) != null && i != this.getLocation().getRow() && j != this.getLocation().getCol()) {
					Actor obj = gr.get(new Location(i, j));
					obj.removeSelfFromGrid();
				}
			}
		}
		System.out.println("The Winning Jumper is at the Location " + "("+getLocation().getRow()+", "+getLocation().getCol()+")");
	}

	private void reduceSteps() {
		if(stepCount <= 10) {
			stepCount = 0;
		}
		else {
			stepCount -= 10;
		}
	}
	
	private void performMoodSwing() {
		int randNum = (int)(Math.random()*15);
		if(randNum >= 0) {
			turn();
		}
		if(randNum == 1) {
			turn();
			turn();
		}
		if(randNum == 2) {
			turn();
			turn();
			turn();
		}
		if(randNum == 3) {
			turn();
			turn();
			turn();
			turn();
		}
		if(randNum == 4) {
			turn();
			turn();
			turn();
			turn();
			turn();
		}
		if(randNum == 5) {
			turn();
			turn();
			turn();
			turn();
			turn();
			turn();
		}
		if(randNum == 6) {
			turn();
			turn();
			turn();
			turn();
			turn();
			turn();
			turn();
		}
		else {}
	}

}
