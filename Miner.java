// Description: Class definition for a miner character that implements methods declared in caveworker interface and abstract methods
// 				declared in Character abstract class

public class Miner extends Character{
	private String desc;
	
	public Miner(Cave initloc){
		super(initloc);
		desc = new String();
	}

	/**
	 * Attempt to modify the cave at the given location. Fillers modify a cave by filling in a pit. 
	 * @param loc - The Cave to attempt to modify. 
	 * @return True if the cave was modified (i.e. it was a pit was filled in), false otherwise. 
	 */
	public boolean modifyCave(Cave loc){
		if ( loc.isBlocked() ){
			desc = "Miner Opened Cave"; // Describe the modification
			loc.makeOpen();  // Make the cave open 
			return true ; 
		}else{
			return false ; 
		}
	}
	
	/**
	 * Override of the move method from the Character class. 
	 * This method checks to see if the Filler can actually move to this new location.
	 * If so, it should make a call to the move method in the super class (which actually performs the move). 
	 * If not, simply return false.
	 */
	public boolean move(Cave to){
		if (to.isOccupied()) {	
			return false; 
		}
		else {
			super.move(to);
			return true;
		}
	}
	
	/**
	 * The Name of this filler
	 * @return Name of this filler
	 */
	public String getName(){
		return "Miner";
	}
	/**
	 * @return String representing the modification made
	 */
	@Override
	public String describeModification() { 
		return desc;
	}
	
}