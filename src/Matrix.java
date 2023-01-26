
public class Matrix {

	private int numRows;
	private int numCols;
	private double [][] data;
	
	public Matrix (int r, int c) {
		numRows = r;
		numCols = c;
	}
	
	public Matrix (int r, int c, double[] linArr) {
		numRows = r;
		numCols = c;
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
		        data[i][j] = linArr[(i+j)%linArr.length];
			}
		}
	}
	
	public void print2D()
    {
        // Loop through all rows
        for (int i = 0; i < data.length; i++)
 
            // Loop through all elements of current row
            for (int j = 0; j < data[i].length; j++)
                System.out.print(data);
    }		
	
	public static void main(String[] args) {
		double linArr [] = {1,2,3,4,5};
		Matrix abc = new Matrix(3, 4, linArr);
		abc.print2D();
	}

}
