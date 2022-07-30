
public class QuickSort {

	public static void main(String[] args) {
		// quick sort = moves smaller elements to left of a pivot.
    	//			   recursively divide array in 2 partitions

    	//                       run-time complexity = Best case O(n log(n))
    	//				   		                   Average case O(n log(n))
    	//				   		                   Worst case O(n^2) if already sorted
    	
    	//                       space complexity    = O(log(n)) due to recursion
    	
        int[] array = {8, 2, 5, 3, 9, 4, 7, 6, 1};
        
        quickSort(array, 0, array.length - 1);
        
        for(int i : array){
            System.out.print(i + " ");
        }
    }

	private static void quickSort(int[] array, int start, int end) {
		if(start>=end) return;
		int pivot = array[end];
		int i=start-1;
		int j=start;
		
		for(;j<end;j++) {
			if(array[j]<pivot) {
				i++;
				int temp=array[i];
				array[i]=array[j];
				array[j]=temp;
			}
		}
			i++;
			int temp=array[i];
			array[i]=pivot;
			array[end]=temp;
			quickSort(array,start,i-1);
			quickSort(array,i+1,j);
	}
}


