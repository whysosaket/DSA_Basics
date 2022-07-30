
public class LinearSearch {

	public static void main(String[] args) {
		
    	// linear search = Iterate through a collection one element at a time
    	
    	int[] array = {9, 1, 8, 2, 7, 3, 6, 4, 5};
    	
    	int index = linearSearch(array, 5);
    	System.out.println("The Element is at Index "+index);
	}

	private static int linearSearch(int[] array, int target) {
		for(int i=0;i<array.length;i++) {
			if(target==array[i]) return i;
		}
		return -1;
	}

}
