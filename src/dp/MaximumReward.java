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
	 * ❎ wrong: If the length of the array iw 2, then the maximum
	 * reward is the maximum of the two elements in the array
	 * 
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
	public int maximumReward(int []rewards) {
		int N = rewards.length;
		int []dp = new int[N];
		
		dp[0] = rewards[0];
		dp[1] = Math.max(rewards[0], rewards[1]);

		for(int i = 0; i <= N; i++) {
			if(i < 2) {
				dp[i] = rewards[i];
			} else if(i > 1 && i < N)
				dp[i] = Math.max(dp[i-1], dp[i-2] + rewards[i]);
		}
		
		return dp[N-1];
	}
	
	/**
	 * Driver code
	 */
	public static void main(String []args) {
		MaximumReward run = new MaximumReward();

		int[] r0 = {2, 1, 3, 4, 1, 1, 2, 2, 3};
		int[] r1 = {2,16,9,17,19,13,14, 20,18};
		int[] r2 = {10,40,2,23,19,45,60,7,20};
		int[] r3 = {50,10,60,20,45,1};		

		System.out.println(run.maximumReward(r0));
		System.out.println(run.maximumReward(r1));
		System.out.println(run.maximumReward(r2));
		System.out.println(run.maximumReward(r3));
	}
}
