package cormen_solutions;

/**
 * This class implements in a method the algorithm
 * Insertion Sort using a method
 * 
 * @author j4vierb
 */
public class InsertionSort {
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
	 * This method implements the insertion sort algorithm
	 * 
	 * @param arr Array to be sorted
	 * @return int[] array sorted
	 */
	public int[] insertionSortAlgorithm(int[] arr) {
		// considerer that the first 
		// element is already sorted
		for(int i = 1; i < arr.length; i++) {
			int key = arr[i];
			int j = i - 1;
			while(j >= 0 && key < arr[j]) {
				// swaps the element in the position
				// swap(arr[j + 1], arr[j])
				int temp = arr[j + 1];
				arr[j + 1] = arr[j];
				arr[j] = temp;
				
				j = j - 1;
			}
		}
		return arr;
	}

	/**
	 * The driver code, the array is initialized in this
	 * method
	 */
	public static void main(String []args) throws Exception {
		InsertionSort run = new InsertionSort();
		int []arr = {100, 5, 7, 3, 1, 12, 24};
		
		System.out.println("The array to be sorted is: " + run.printArray(arr));
		int[] sol = run.insertionSortAlgorithm(arr);
		System.out.println("The ordered array is: " + run.printArray(sol));
	}
}
