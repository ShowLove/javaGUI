
 // Description: Class to define a single cave location. Composed of the location of the cave on the grid, whether the cave
 //				is occupied by a character, whether it is marked (teleport spots can be marked), and what type of cave it 
 // 				is (see Cave.CaveType). 

public class Cave {
	public static enum CaveType {
		OPEN,
		TELEPORT,
		PIT,
		BLOCKED;
	}
	// Every cave object knows...
	CaveType cavetype ; // own cavetype
	private Integer row ;   // its own row
	private Integer column ; // its own column
	private boolean occupied ; // if its occupied
	private boolean marked ;   // and if its marked
	
	
 
	// Constructor: Construct an open cave which is unoccupied and unmarked initially. 
	public Cave(int r, int c) {
		this.row = new Integer(r);
		this.column = new Integer(c);
		this.setOccupied(false); // unoccupied 
		this.setMarked(false);  // unmarked			
		cavetype = CaveType.OPEN; // and open
	}
//******************************************************************************************************************************
//  Setters
//******************************************************************************************************************************
	/**
	 * Set whether this cave is occupied. 
	 * @param set Set whether occupied or not
	 */
	public void setOccupied(boolean set){
		this.occupied = set ; 
	}
	/**
	 * Set whether this cave is marked. 
	 * @param set Sets current Cave Marked
	 */
	public void setMarked(boolean set){
		this.marked = set ; 
	}
	
	/** 
	 * Mark this cave as blocked. 
	 */
	public void makeBlocked(){
		this.cavetype = CaveType.BLOCKED;
	}
	
	/**
	 *  Mark this cave as a pit. 
	 */
	public void makePit(){
		this.cavetype = CaveType.PIT;
	}
	/**
	 * Mark this cave as open.
	 * Marks this cave as open 
	 */
	public void makeOpen(){
		this.cavetype = CaveType.OPEN ; 
	}
	// Mark this cave as a teleport. 
	public void makeTeleport(){
		this.cavetype = CaveType.TELEPORT;
	}
//******************************************************************************************************************************
//  Getters
//******************************************************************************************************************************
	/**
	 *  
	 * @return integer representing Row
	 */
	public int getRow(){
		return this.row ; 
	}
	/**
	 * Get the column of this cave. 
	 * @return Integer representing Column
	 */
	public int getCol(){
		return this.column;
	}
	
	/**
	 * Returns whether this cave is occupied 
	 * @return Returns whether occupied or not
	 */
	public boolean isOccupied(){
		return this.occupied;
	}
	/**
	 * Get whether this cave is marked. 
	 * @return Boolean representing if cave is marked
	 */
	public boolean isMarked(){
		return this.marked;
	}	
	/**
	 * Get whether this cave is open. 
	 * @return returns boolean representing if cave is open or not
	 */
	public boolean isOpen(){
		if (this.cavetype.equals(CaveType.OPEN)){ // if this is a cavetype open
			return true ;  // return true
		}
		else return false; // or not
	}
	/**
	 * Get whether this cave is a pit. 
	 * @return boolean representing if 
	 */
	public boolean isPit(){
		if (this.cavetype.equals(CaveType.PIT)){ // if this a cavetype pit
			return true ; // return true
		}
		else return false; // or not
	}
	// Get whether this cave is a teleport. 
	public boolean isTeleport(){
		if (this.cavetype.equals(CaveType.TELEPORT)){ // if this is cavetype teleport
			return true ;  // return true
		}
		else return false; // or not
	}	
	/**
	 * Get whether this cave is blocked. 
	 * @return returns whether cave is blocked
	 */
	public boolean isBlocked(){
		if (this.cavetype.equals(CaveType.BLOCKED)){ // if this is a cavetype blocked
			return true ;  // return true
		}
		else{
			return false; // or not
		}
	}
}
