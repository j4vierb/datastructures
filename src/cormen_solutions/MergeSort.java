package cormen_solutions;

/**
 * This class implements in two methods the algorithm of
 * Merge Sort. One method is used to do the Merge subroutine
 * and the other one realizes the divide and conquer steps.
 * 
 * @author j4vierb
 */
public class MergeSort {
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
	
	public void merge() {}
	
	public void mergeSortAlgorithm() {}
	
	/**
	 * The driver code, the array is initialized in this
	 * method
	 */
	public static void main(String []args) throws Exception {
		MergeSort run = new MergeSort();
		int []arr = {
			376, 89, 18, 42, 26, 82, 73, 87, 68, 47, 11,
			69, 90, 2, 51, 99, 26, 64, 11, 66, 29, 18, 46,
			64, 11, 17, 27, 81, 87, 29, 39, 58, 33, 15, 38, 
			97, 20, 38, 14, 82, 58, 58, 37, 70, 42, 38, 88,
			13, 70, 14, 30, 50, 78, 64, 27, 29, 35, 57, 75
		};
		
		System.out.println("The array to be sorted is: " + run.printArray(arr));
		
		System.out.println("The ordered array is: " + run.printArray(arr));
	}
}
