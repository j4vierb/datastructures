package dp;

class PlaneCoins {
    /**
     * This method prints the content of an 2 dimensional array
     *
     * @param arr Array (matrix) to be printed
     * @return String with the elements in the array using this format
     * [
     * [1, 1, 1, 1]
     * [1, 1, 1, 1]
     * [1, 2, 1, 1]
     * [1, 3, 3, 1]
     * ]
     */
    public String print2DArray(int [][]arr) {
            String cadena = "\n";
            for(int i = 0; i < arr.length; i++) {
                    cadena += "[";
                    for(int j = 0; j < arr[i].length; j++) {
                            cadena += arr[i][j] + (j == arr[i].length - 1 ? "" : ", ");
                    }
                    cadena += "]\n";
            }
            return cadena + "\n";
    }
    
    /**
     * This method implements the following recurrence relation
     * where dp[i][j] is the maximum number of coins that the plane
     * can obtain in the position i,j if the position matrix[i][j] != -1.
     * Let matrix be of size n*m.
     * 
     * dp[i][j] = matrix[i][j] if j = 0 and 0 <= i < n
     * dp[i][j] = -1 if matrix[i][j] = -1
     * dp[i][j] = max(dp[i][j-1], dp[i+1][j-1]) + matrix[i][j] if i = 0 and 0 < j < m
     * dp[i][j] = max(dp[i-1][j-1], dp[i][j-1], dp[i+1][j-1]) + matrix[i][j] if 0 < i < n and 0 < j < m
     * dp[i][j] = max(dp[i-1][j-1], dp[i][j-1]) + matrix[i][j] if i = n - 1 and 0 < j < m
     * 
     * @param matrix
     * @return
     */
    public int planeCoinsAlgorithm(int [][]matrix) {
    	int rows = matrix.length, cols = matrix[0].length;
    	int [][]dp = new int[rows][cols];

		for(int j = 0; j < matrix[0].length; j++) {
		    for(int i = 0; i < matrix.length; i++) {
		    	if(matrix[i][j] != -1) {
		    		if(j == 0) // first column
		    			dp[i][j] = matrix[i][j];
		    		else if(i == 0) { // first row
		    			int max = Math.max(dp[i][j-1], dp[i+1][j-1]) + matrix[i][j];
		    			dp[i][j] = max == -1 ? 0 : max;
		    		} else if(i == rows - 1) { // last row
		    			int max = Math.max(dp[i][j-1], dp[i-1][j-1]) + matrix[i][j];
		    			dp[i][j] = max == -1 ? 0 : max;
		    		} else if(i > 0 && j > 0) { // rows between first and last rows
		    			int max = Math.max(dp[i][j-1], Math.max(dp[i-1][j-1], dp[i+1][j-1])) + matrix[i][j];
		    			dp[i][j] = max == -1 ? 0 : max;
		    		}
		    	} else {
		    		dp[i][j] = -1;
		    	}
		    }
		}

		int findMaximum = 0;
		for(int i = 0; i < matrix.length; i++) {
			if(dp[i][rows] > findMaximum)
				findMaximum = dp[i][rows];
		}

		return findMaximum;
    }
    
	public static void main(String[] args) {
		int [][]matrix = {
		    {-1, -1, -1, -1, 0},
		    {1, 10, 1, -1, 0},
		    {3, -1, 14, -1, 20},
		    {-1, -1, -1, 1, 0}
		};
		
		PlaneCoins run = new PlaneCoins();
		int maximum = run.planeCoinsAlgorithm(matrix);
		System.out.println("The maximum number of coins is: " + maximum);
	}
}
