package dp;

/**
 * This class implements in a method the algorithm to generate
 * the n-th level of the pascal's triangle
 * 
 * @author j4vierb
 */
public class PascalsTriangle {
	/**
	 * This method prints the content of an array
	 * 
	 * @param arr Array to be printed
	 * @return String with the elements in the array using this format
	 * [1, 2, ..., n]
	 */
	public String printArray(int []arr) {
		String cadena = "[";
		for(int i = 0; i < arr.length; i++)
			cadena += arr[i] + (i == arr.length - 1 ? "" : ", ");
		return cadena + "]";
	}
	
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
		String cadena = "[\n";
		for(int i = 0; i < arr.length; i++) {
			cadena += "[";
			for(int j = 0; j < arr[i].length; j++) {
				cadena += arr[i][j] + (j == arr[i].length - 1 ? "" : ", ");
			}
			cadena += "]\n";
		}
		return cadena + "]";
	}

	/**
	 * This method calculates the n-th level of the pascal's triangle
	 * and returns it using dynamic programming
	 * 
	 * @param n The n-th level to be calculated
	 * @return Array of integers with the n-th level of pascal's triangle
	 */
	public int[] pascalsTriangle(int n) {
		int [][]dp = new int[n][n];

		for(int i = 0; i < n; i++) {
			for(int j = 0; j <= i; j++) {
				if(i == j || j == 0)
					dp[i][j] = 1;
				else if(i > 1 && j > 0 && j < i) {
					dp[i][j] = dp[i-1][j] + dp[i-1][j-1];
				}
			}
		}
		return dp[n-1];
	}

	/**
	 * This method calculates the pascal's triangle
	 * and returns it using dynamic programming
	 * 
	 * @param n The n-th level
	 * @return Array of integers calculated for pascal's triangle
	 */
	public int[][] completePascalsTriangle(int n) {
		int [][]dp = new int[n][];

		for(int i = 0; i < n; i++) {
			dp[i] = new int[i+1];
			for(int j = 0; j <= i; j++) {
				if(i == j || j == 0)
					dp[i][j] = 1;
				else if(i > 1 && j > 0 && j < i) {
					dp[i][j] = dp[i-1][j] + dp[i-1][j-1];
				}
			}
		}
		return dp;
	}

	/**
	 * The driver code, the arguments and the instance of the class
	 * are defined in this method
	 */
	public static void main(String []args) {
		PascalsTriangle run = new PascalsTriangle();
		int n = 9;
		System.out.println("Calculate the " + n + "-th level of Pascal's triangle ");
		int []res = run.pascalsTriangle(n);
		System.out.println("The " + n + "-th level is: " + run.printArray(res));
		
		int [][]ans = run.completePascalsTriangle(n);
		System.out.println("And the complete triangle is: ");
		System.out.println(run.print2DArray(ans));
	}
}
