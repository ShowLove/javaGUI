

 //Description: This class stores information about the board. It contains a 2D array of the board, made up of individual Cave spots.  

import java.util.Random;

public class Board {
	
	private Cave[][] caveArray ;  // gameboard instance, 2d array
	private Integer row ;   // Hold onto these values for future ref
	private Integer col ; // Hold onto these values for future ref 
	
	/**
	 * Constructor 
	 * @param rows
	 * @param cols
	 */
	public Board(int rows, int cols) {
				
		caveArray =  new Cave[rows][cols]; // Holy crap, you can make an multidimensional array of whatever!
		
		
		this.row = rows ; 
		this.col = cols;
		
		Random rand = new Random();
		int random ; 
		// for every row
		for ( int i = 0  ; i < rows ; i++){
			// for every column
			for ( int j = 0 ; j < cols ; j++){
				// generate a random number between 0 include and 100 exclusive.
				Cave cave = new Cave(i,j);
				
				//System.out.println("Row: "+i+" Column: "+j);
				random = rand.nextInt(100);
				// five percent means 5/100 so if random is a number less than five percent
				if ( random < 10 ){ // generate a teleport T
					cave.makeTeleport() ;
					random = rand.nextInt(100);
				}
				// 20 percent blocked
				else if( random >= 10 && random <  30 ){ // generate obstacle 'X'					
					cave.makeBlocked();
					random = rand.nextInt(100);
				} 
				// 20 percent pit
				else if( random >= 30 && random <  50 ){ 
					//generate pit
					cave.makePit();
					random = rand.nextInt(100);
				} 
				// else 50 percent open
				else { // fill with empty
					cave.makeOpen();
					random = rand.nextInt(100);
				}
				// for first box and last box
				if ((i == 0 && j == 0) || (i==rows-1 && j == cols-1) ){
					cave.makeOpen();
					if (i == 0 && j == 0 ){
						cave.setOccupied(true);
					}
				}
				caveArray[i][j] = cave ; // put into array 
			}
		}
	}
	/**
	 * Get the cave at location (r,c). 
	 * 
	 * @param r
	 * @param c
	 * @return The Cave stored at this location, or null if this spot is not on the board.
	 */
	public Cave getCave(int r,int c){
		if (ok(r, c)){ // Check if r and c are valid
			return caveArray[r][c] ; 
		}
		else {
			return null ; 
		}
	}
	/**
	 * Check if this location is inside the bounds of the board. 
	 * @param r
	 * @param c
	 * @return Returns true if this spot is within the bounds of the defined board, false otherwise.
	 */
	public boolean ok(int r,int c){
		if (r < row && c < col && r > -1 && c > -1){
			//System.out.println("Rows In ok: "+r+" Columns: "+c);
			return true; 
		}
		else{
			return false;
		}
	}
	/**
	 * Get a random unoccupied, open location from the current state of the game board.
	 * Guaranteed not to return the location of the treasure.
	 * @return a random unoccupied and open Cave object 
	 */
	public Cave getUnoccupiedOpenLocation(){
		 Random rand = new Random();
		 int r = rand.nextInt(this.row) ;  
		 int c = rand.nextInt(this.col) ;
		 boolean leave = false; 
		 while (!leave){
			 c = rand.nextInt(col) ; 
			 r = rand.nextInt(row) ;
			 if (caveArray[r][c].isOpen() && !caveArray[r][c].isOccupied() && (caveArray[r][c].getCol() != this.col-1) && (caveArray[r][c].getRow() != this.row-1)){ 
				 break; 
			 }
		 }
		 return caveArray[r][c]; 
	}
}