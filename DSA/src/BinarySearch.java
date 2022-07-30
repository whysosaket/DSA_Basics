
public class BinarySearch {

	public static void main(String[] args) {
		// binary search = Search algorithm that finds the position
		//				   of a target value within a sorted array.
		//				   Half of the array is eliminated during each "step"
		
		int array[] = new int[1000000];
		int target = 777777;
		
		for(int i = 0; i < array.length; i++) {
			array[i] = i;
		}
		
		//int index = Arrays.binarySearch(array, target);
		int index = binarySearch(array, target);

		System.out.println("The element is found at Index: "+index);
	}

	private static int binarySearch(int[] array, int target) {
		int low= 0;
		int high=array.length-1;
		
		
		while(low<=high) {
			int mid=(low+high)/2;

			System.out.println("The Middle Value is: "+array[mid]);
			
			if(array[mid]<target) low=mid+1;
			else if(array[mid]>target) high=mid-1;
			else return mid;
		}
		return -1;
	}

}
