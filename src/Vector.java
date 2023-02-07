/**
 * This class represents a vector of 1 row and specific columns
 * 
 * @author Edward Zhang
 *
 */

public class Vector extends Matrix {

	/**
	 * Constructor creates vector of 1 row and c columns
	 * 
	 * @param c columns in matrix
	 */
	public Vector(int c) {
		// Calls Matrix superclass constructor
		super(1, c);
	}

	/**
	 * Constructor creates vector of 1 row, c columns and fills with elements in an
	 * array
	 * 
	 * @param c      columns in vector
	 * @param linArr array of elements
	 */
	public Vector(int c, double[] linArr) {
		// Calls Matrix superclass constructor
		super(1, c, linArr);
	}

	/**
	 * Accessor method to get specific element in vector
	 * 
	 * @param c columns in vector
	 * @return specific element in vector
	 */
	public double getElement(int c) {
		return this.getData()[0][c];
	}
}
