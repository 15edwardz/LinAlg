/**
 * This class represents a matrix with specific rows and columns
 * 
 * @author Edward Zhang
 */

public class Matrix {

	// Declaring the private data types
	private int numRows;
	private int numCols;
	private double[][] data;

	/**
	 * Constructor for Matrix class when only row and column are passed
	 * 
	 * @param r rows of matrix
	 * @param c columns of matrix
	 */
	public Matrix(int r, int c) {
		numRows = r;
		numCols = c;
		data = new double[numRows][numCols];
	}

	/**
	 * Constructor for Matrix class when a row, column and array are passed
	 * 
	 * @param r      rows of matrix
	 * @param c      columns of matrix
	 * @param linArr array that contains data for the matrix
	 */
	public Matrix(int r, int c, double[] linArr) {
		numRows = r;
		numCols = c;
		data = new double[numRows][numCols];
		int count = 0;

		// Loops through linArr and fills data
		for (int i = 0; i < numRows; i++) {
			for (int j = 0; j < numCols; j++) {
				if (count < linArr.length) {
					data[i][j] = linArr[count];
					count++;
				}
			}
		}

	}

	/**
	 * Accessor method to get the number of rows in matrix
	 * 
	 * @return number of rows
	 */
	public int getNumRows() {
		return this.numRows;
	}

	/**
	 * Accessor method to get number of columns in matrix
	 * 
	 * @return number of columns
	 */
	public int getNumCols() {
		return this.numCols;
	}

	/**
	 * Accessor method to get contents of 2D array data
	 * 
	 * @return data in 2D array data
	 */
	public double[][] getData() {
		return this.data;
	}

	/**
	 * Accessor method to get specific data from 2D array data
	 * 
	 * @param r row of matrix
	 * @param c column of matrix
	 * @return data at r and c in 2D array data
	 */
	public double getElement(int r, int c) {
		return this.data[r][c];
	}

	/**
	 * Mutator method to set specific element in matrix to new value
	 * 
	 * @param r     row of matrix
	 * @param c     column of matrix
	 * @param value new value that is assigned to the element at r and c
	 */
	public void setElement(int r, int c, double value) {
		data[r][c] = value;
	}

	/**
	 * Transposes the matrix
	 */
	public void transpose() {

		// Create new 2D array to store transposed matrix
		double[][] transposedMatrix = new double[this.numCols][this.numRows];

		// Loops through data and transposes matrix
		for (int i = 0; i < this.numRows; i++) {
			for (int j = 0; j < this.numCols; j++) {
				transposedMatrix[j][i] = this.data[i][j];
			}
		}

		// Sets data as transposed matrix and updates the instance variables to match
		// after transposing
		this.data = transposedMatrix;
		int temp = this.numRows;
		this.numRows = this.numCols;
		this.numCols = temp;

	}

	/**
	 * Multiply matrix by a scalar value
	 * 
	 * @param scalar mulitply matrix using scalar
	 * @return new multiplied matrix object
	 */
	public Matrix multiply(double scalar) {

		// Create new matrix object
		Matrix multData = new Matrix(numRows, numCols);

		// Loops through matrix and multiplies by scalar
		for (int i = 0; i < numRows; i++) {
			for (int j = 0; j < numCols; j++) {
				multData.data[i][j] = data[i][j] * scalar;
			}
		}
		return multData;

	}

	/**
	 * Multiply 2 matrices together
	 * 
	 * @param other other matrix
	 * @return new multiplied matrix object
	 */
	public Matrix multiply(Matrix other) {

		// Create new matrix object
		Matrix multMatData = new Matrix(this.numRows, other.numCols);

		// Checks compatibility between matrices
		if (this.numCols != other.numRows) {
			return null;
		}

		// Multiplies the matrices together if compatible
		for (int i = 0; i < multMatData.numRows; i++) {
			for (int j = 0; j < multMatData.numCols; j++) {
				double counter = 0;

				for (int k = 0; k < this.numCols; k++) {
					counter += this.data[i][k] * other.data[k][j];
				}
				multMatData.data[i][j] = counter;
			}
		}

		return multMatData;
	}

	/**
	 * To string method
	 * 
	 * @return Matrix as a string
	 */
	public String toString() {

		// Checks if matrix is empty or null
		if (data == null || data.length == 0) {
			return "Empty matrix";
		}

		// Formats elements of matrix to string with 8 characters and 3 floating point
		String dataContent = "";
		for (int i = 0; i < data.length; i++) { 
			for (int j = 0; j < data[i].length; j++) { 
				dataContent += String.format("%8.3f", this.data[i][j]);
			}
			dataContent += "\n";
		}
		return dataContent;
	}
}
