import java.util.ArrayList;
import java.util.List;

public class Main {
	public void sort(List<Integer> numbers) {
		int N = numbers.size();
		
		for(int i = 0; i < N; i++) {
			int j = 0;
			while(j < N - 1 - i) {
				if(numbers.get(j) > numbers.get(j+1)) {
					int a = numbers.get(j);
					int b = numbers.get(j+1);
					numbers.set(j, b);
					numbers.set(j+1, a);
				}
				j++;
			}
		}
		
		System.out.println(numbers);
	}
	
	public static void main(String []args) {
	    Main main = new Main();
	    int []a = {11, 20, 1, 8};
	    ArrayList<Integer> list = new ArrayList<Integer>();
	    for(int i = 0; i < a.length; i++) {
	        list.add(a[i]);
	    }
	    System.out.println(list);
	    main.sort(list);
	}

}
