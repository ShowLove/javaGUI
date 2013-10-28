//Description: Interface for objects that implement CaveWorker,  

public interface CaveWorker {
	/**
	 * Give a description of the type of modification made
	 * @return
	 */
	public String describeModification();
	/**
	 * Method making modifications to a given cave if this worker can modify this type of cave.
	 * @param loc
	 * @return
	 */
	public boolean modifyCave(Cave loc);
}