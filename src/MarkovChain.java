/**
 * This class represents a Markov chain to produce a matrix of predicted future
 * states
 * 
 * @author Edward Zhang
 *
 */
public class MarkovChain {
	private Vector stateVector;
	private Matrix transitionMatrix;

	/**
	 * Constructor creates Markov chain using state vector and transition matrix.
	 * 
	 * @param sVector
	 * @param tMatrix
	 */
	public MarkovChain(Vector sVector, Matrix tMatrix) {
		stateVector = sVector;
		transitionMatrix = tMatrix;
	}

	/**
	 * Checks if the instance variables are valid for a Markov chain
	 * 
	 * @return True or False
	 */
	public boolean isValid() {
		// Check if the number of columns in the state vector matches the number of rows
		// in the transition matrix
		if (stateVector.getNumCols() != transitionMatrix.getNumRows()) {
			return false;
		}

		// Check if the transition matrix is a square matrix
		if (transitionMatrix.getNumRows() != transitionMatrix.getNumCols()) {
			return false;
		}

		// Check if the sum of values in the state vector is equal to 1
		float stateVectorSum = 0;
		for (int i = 0; i < stateVector.getNumCols(); i++) {
			stateVectorSum += stateVector.getElement(i);
		}
		if (stateVectorSum != 1.0) {
			return false;
		}

		// Check if the sum of values in each row of the transition matrix is equal to 1
		for (int i = 0; i < transitionMatrix.getNumRows(); i++) {
			float rowSum = 0;
			for (int j = 0; j < transitionMatrix.getNumCols(); j++) {
				rowSum += transitionMatrix.getElement(i, j);
			}
			if (rowSum != 1.0) {
				return false;
			}
		}

		return true;
	}

	/**
	 * Computes probability matrix of a Markov chain after a certain number of steps
	 * 
	 * @param numSteps number of times the transition matrix is multiplied by itself
	 * @return resulting Matrix object
	 */
	public Matrix computeProbabilityMatrix(int numSteps) {
		// Returns null if isValid is false
		if (isValid() == false) {
			return null;
		}
		Matrix resultMat = stateVector;
		for (int i = 0; i < numSteps - 1; i++) {
			resultMat = resultMat.multiply(transitionMatrix);
		}

		return resultMat;

	}
}
