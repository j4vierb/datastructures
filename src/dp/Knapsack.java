package dp;

/**
 * This class implements in one method the solution
 * to Knapsack 0-1 problem. The 0-1 says that we can
 * add the i element one time (1) or not (0).
 * 
 * **note**: This problem can be statement like as a problem
 * of optimization:
 * 
 * maximize the value of items
 * subject to the (sum of weights of the items) less
 * or equal than W.
 * 
 * @author j4vierb
 */
public class Knapsack {
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
	 * The following code implements the next recursion
	 * 
	 * Sea m[i,w] el valor máximo que podemos obtener
	 * con peso menor o igual que w para los primeros
	 * i elementos.
	 * 
	 * m[0, w] = 0. Como no hay elementos antes del 
	 * elemento 0 el valor máximo con peso menor o
	 * igual que w es 0. (caso base 1)
	 * 
	 * m[i, w] = m[i-1, w] si w_i > w. En este caso si 
	 * el nuevo item excede la capacidad de la mochila
	 * se debe ignorar. (caso base 2)
	 * 
	 * m[i, w] = max(m[i-1, w], m[i-1, w - w_i] + v_i)
	 * si w_i <= W. Si el peso actual es menor o igual que
	 * la capacidad de la mochila debo elegir el máximo beneficio
	 * entre agregarlo o no agregarlo. En el caso de que
	 * se agregue a la mochila obtenemos cierto valor
	 * utilizando los i - 1 elementos, entonces también
	 * se puede añadir el i-ésimo termino. Antes de añadir
	 * el i-ésimo elemento el peso es j - w_i, si se añade
	 * este elemento el peso es de j - w_i + w_i = j. 
	 * Por esto mismo se mantiene que el peso actual es
	 * igual al peso limite. Por lo que el elemento
	 * m[i - 1, w - w_i] + v_i. (caso general)
	 */
	public int[] knapsackAlgorithm() { 
		return new int[3];
	}
	
	/**
	 * The driver code, the variables are initialiazed
	 * in this method
	 */
    public static void main(String []args) {
    	Knapsack run = new Knapsack();
    	
    	int []weight = {4, 5, 1};
    	int []profit = {1, 2, 3};
    	int W = 4;
    	int N = 3;
    	
    	System.out.println("El número de elementos es: " + N);
    	System.out.println("La capacidad máxima de la mochila es: " + W);
    	System.out.println("El peso para cada i-ésimo elemento es: " + run.printArray(weight));
    	System.out.println("El beneficio para cada i-ésimo elemento es: " + run.printArray(profit));
    	
    	int []solution = run.knapsackAlgorithm();
    	System.out.println("La solución es: " + run.printArray(solution));
    }
}
