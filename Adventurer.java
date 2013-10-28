
 //Description: Class file for adventurer who is a character that implements methods declared in caveworker interface


public class Adventurer extends Character{
	private String desc;
	/**
	 * Construct an adventurer at this initial location. 
	 * You should make a call the parent constructor here. 
	 * @param initLoc
	 */
	public Adventurer(Cave initLoc) {
		super(initLoc);
		this.desc = new String();
              
	}
	/**
	 * Attempt to modify the cave at the given location. 
	 * Adventurers modify a cave by marking it. 
	 * Also Adventurers are immune to being teleported 
	 */
	@Override
	public boolean modifyCave(Cave loc) {
		if (loc.isTeleport()){
			loc.setMarked(true);
			desc += "Adventurer marks teleport";
			return true;
		}
		else return false;
	}
	/**
	 * Override of the move method from the Character class. 
	 * This method checks to see if the Adventurer can actually move to this new location. 
	 * If so, it should make a call to the move method in the super class (which actually performs the move). 
	 * If not, simply return false. Take special note that this method should return true whether or not this 
	 * is a good move for the Adventurer (i.e. even if it's a pit, it's a legal move. Just one that happens to result in an untimely death). 
	 * @return boolean true if legal move, else false
	 */
	public boolean move(Cave to){
		if (to.isBlocked()||to.isOccupied()){ // if it is a illegal move then return false
			return false;
		}else{ // else, just move there
			super.move(to);
			return true;
		}

	}
	/**
	 * @return The name of this adventurer. 
	 */
	@Override
	public String getName() {
		return "Adventurer";
	}
	/**
	 * @return A String describing what modification was made by this Adventurer to a teleporter cave. 
	 */
	@Override
	public String describeModification() {
		if (!desc.isEmpty()){
			return desc;
		}
		else{
			return null ; 
		}
	}
}
