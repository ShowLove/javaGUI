// Description: Abstract Class to store information about a general game character. 
// 				Implements the CaveWorker interface declares methods operations a character can or can't perform on a cave, 
// 				depending on the type of character.



public abstract class Character extends Object implements CaveWorker { 
	/*
	 *  Extends <class> - A method and field copier
	 *  	Class inheritance - inheritance of public methods and public fields from superclass. Mainly for code reuse.
	 *  	
	 *  Implements <Interface>
	 *  	Interface inheritance - classes that inherit interfaces provide definitions for the methods declared in interface def
	 */
	
        private int rope;
    
	// The Cave that this character is occupying.	
	protected Cave location;
	
	// Construct a character at initLoc
	public Character(Cave initLoc){
		this.location = initLoc ; 
		this.location.makeOpen();
		this.location.setOccupied(true);
                
                this.rope = 1;
	}
	
	/**
	 * Get the Cave this character is occupying. 
	 * @return
	 */
	public Cave getLocation(){
		return this.location;
	}
	/**
	 * Move this character from his/her current location to the new location. Marks the old spot as unoccupied
	 * and the new spot as occupied. Assumes that new location can be moved to by this character. 
	 * @param to
	 * @return
	 */
	public boolean move (Cave to){
		// Set Current location to unoccupied
		this.location.setOccupied(false);
		
		// Set Next Location to Current location and mark occupied
		this.location = to ; 
		this.location.setOccupied(true);
		return true; 
	}
	/**
	 * Abstract method to get the name of this character. Any non-abstract class must implement this method. 
	 * @return Name 
	 */
	public abstract String getName(); 
	// When an abstract class is subclassed, the subclass provides implementation (definition) of all abstract methods from its 
	// subclass. If it doesn't, the subclass must also be declared abstract too.  	
        
        
        public boolean useRope(){
            if(rope == 1){
                return true;
            }
            
            else{
                return false;
                }
        }
        
        public void setRope(int r){
            rope = r;
        }
        
        public int getRope(){
            return rope;
        }
        
        
	
}