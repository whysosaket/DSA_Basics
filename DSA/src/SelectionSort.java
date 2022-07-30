
public class SelectionSort {

	public static void main(String[] args) {
		// selection sort = search through an array and keep track of the minimum value during 
		//			         each iteration. At the end of each iteration, we swap values.
		
		//				 Quadratic time O(n^2)
		//				 small data set = okay
		//				 large data set = BAD
		
		int array[] = {8, 7, 9, 2, 3, 1, 5, 4, 6};
		
		selectionSort(array);
		
		for(int i : array) {
			System.out.print(i+" ");
		}	

	}

	private static void selectionSort(int[] array) {
		for(int i=0;i<array.length;i++) {
			
			int min=i;
			
			for(int j=i+1;j<array.length;j++) {
				if(array[j]<array[min]) min=j;
			}
			
			int temp=array[min];
			array[min]=array[i];
			array[i]=temp;
		}
		
	}

}
