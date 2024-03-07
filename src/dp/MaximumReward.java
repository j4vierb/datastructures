package dp;

public class MaximumReward {
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
	 * This class implements the following recurrence relation
	 * 
	 * ❎ wrong
	 * dp[i] = a[i] if 0 <= i < 2
	 * dp[i] = max(a[i] + dp[i-2], dp[i-1]) if 1 < i < n
	 * 
	 * ✅ good
	 * dp[i] = a[i] if i = 0
	 * dp[i] = max(a[0], a[1]) if i = 1
	 * dp[i] = max(a[i] + dp[i-2], dp[i-1]) if 1 < i < n
	 * 
	 * @param a The array with the rewards in the i-th position
	 * @return The maximum number of rewards that Luisa can collect
	 */
	public int maximumReward(int []a) {
		int N = a.length;
		int []dp = new int[N];
		
		dp[0] = a[0];
		dp[1] = a[1]; // Math.max(a[0], a[1]);
		
		for(int i = 2; i < N; i++) {
			dp[i] = Math.max(dp[N-1], dp[N-2] + a[i]);
		}
		
		return dp[N - 1];
	}
	
	/**
	 * Driver code
	 */
	public static void main(String []args) {
		MaximumReward run = new MaximumReward();
		
		int[] rewards = {2, 1, 3, 4, 1, 1, 2, 2, 3};
		System.out.println("The maximum reward of " + run.printArray(rewards) + " is " + run.maximumReward(rewards));
	}
}
