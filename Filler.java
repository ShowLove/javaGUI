
// Description: Class/Object Definition to represent a Filler<-Character<-CaveWorker. The Filler has a special ability to walk into pits 
//  			and fill the pit with sand so that it is safe for other characters to walk into this cave in the future. 

public class Filler extends Character {
	private String desc ;
	public Filler(Cave initLoc) {
		super(initLoc);
		this.desc = new String();
	}
	 
    /**
     * Attempt to modify the cave at the given location. Fillers modify a cave by filling in a pit. 
     * @param loc - The Cave to attempt to modify. 
     * @return True if the cave was modified (i.e. it was a pit was filled in), false otherwise. 
     */
	public boolean modifyCave(Cave loc){
		if ( loc.isPit() ){
			this.desc = "Filler filled the pit!";
			loc.makeOpen();
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
	 * @return Boolean true if moved, else false
	 */
        public boolean move(Cave to){
		if (to.isBlocked()||to.isOccupied()){ // if this 
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
		return "Filler";
	}
	/**
	 * @return A String describing what modification was made by this Filler to a pit. 
	 */
	@Override
	public String describeModification() {
		 return desc;
	}
}