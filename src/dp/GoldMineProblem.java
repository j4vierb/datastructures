package dp;

/**
 * Class that solve the gold mine problem you can verify the 
 * answers here: https://www.geeksforgeeks.org/gold-mine-problem/
 * 
 * @author j4vierb
 */
public class GoldMineProblem {
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
	 * This method calculates the maximum amount of gold that
	 * the miner can collect.
	 * 
	 * Let dp[i][j] the maximum amount of gold that the miner can
	 * collect in m[i][j]. The following cases are to first column,
	 * first row, last row and general case respectively.
	 * 
	 * dp[i][j] = m[i][j] if j = 0 and 0 <= i < n
	 * dp[i][j] = m[i][j] + max(dp[i][j-1], dp[i+1][j-1]) if i =0 and 0 <= j < m ¿-1?
	 * dp[i][j] = m[i][j] + max(dp[i][], dp[i-1][j-1]) if i = n - 1 and 0 <= j < 
	 * 
	 * @param m Matrix of N * M size
	 * @return The maximum amount of gold that the miner can collect
	 */
	public int goldMineAlgorithm(int [][]m) {
		int N = m.length;
		int M = m[0].length;
		
		int [][]dp = new int[N][M];
		
		int max = Integer.MIN_VALUE;
		
		for(int j = 0; j < M; j++) {
			for(int i = 0; i < N; i++) {
				if(j == 0 && 0 <= i && i < N)
					dp[i][j] = m[i][j];
				else if(i == 0 && 0 <= j && j < M)
					dp[i][j] = m[i][j] + Math.max(dp[i][j-1], dp[i+1][j-1]);
				else if(i == N - 1 && 0 <= j && j < M)
					dp[i][j] = m[i][j] + Math.max(dp[i][j-1], dp[i-1][j-1]);
				else
					dp[i][j] = m[i][j] + Math.max(dp[i][j-1], Math.max(dp[i-1][j-1], dp[i+1][j-1]));
				
				if(dp[i][j] > max)
					max = dp[i][j];
			}
		}

		return max;
	}
	
	/**
	 * Driver code
	 */
	public static void main(String []args) {
		GoldMineProblem run = new GoldMineProblem();
		
		int [][]mat = {
				{1, 3, 1, 5},
				{2, 2, 4, 1},
				{5, 0, 2, 3},
				{0, 6, 1, 2}
		};
		
		int [][]mat2 = {
				{10, 33, 13, 15},
				{22, 21, 04, 1},
				{5, 0, 2, 3},
				{0, 6, 14, 2}
		};
		
		int res = run.goldMineAlgorithm(mat);
		System.out.println("The maximum amount of gold in the mine is " + res);
		
		int res2 = run.goldMineAlgorithm(mat2);
		System.out.println("The maximum amount of gold in the mine is " + res2);
	}
}
