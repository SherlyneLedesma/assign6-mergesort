package mergesort;
import java.util.Arrays;

public class MergeSort {

	public static void main(String[] args) {
		int[] array1 = {11,43,87,27,54,8,32,71,44,12};
		
		showArray(array1);
		mergeSort(array1);
		showArray(array1);
		
		
	}
	
	public static void showArray(int[] theArray) {
		int index;
		
		System.out.printf("[");
		for(index=0;index<theArray.length;index++) {
			if(index!=0) {
				System.out.printf(", ");
			}
			System.out.printf("%d",theArray[index]);
		}
		System.out.printf("]\n");
	}
	

	
	private static void mergeSort(int[] theArray, int left, int right) {
		//**************************************************************
		//*  Recursive Merge Sort                                      *
		//*------------------------------------------------------------*
		//*  1. Divide or partition the array section into 2 halves.   *
		//*  2. Create a subArray for each partition (half)            *
		//*  3. Merge the two subArrays to create one sorted array     *
		//*  4. Replace the original array section with the merged     *
		//*     array.                                                 *
		//**************************************************************
		if(left < right) {
			int mid = (left + right)/2;
			mergeSort(theArray, left, mid);
			mergeSort(theArray, mid+1, right);
			
			merge(theArray, left, right);
			
		}

	}
	
	public static int[] merge(int [] arr, int left, int right) {
		if(left<right) {
			int mid = (left + right)/2;
			int[] n1 = Arrays.copyOfRange(arr, left, mid+1);
			int[] n2 = Arrays.copyOfRange(arr, mid+1, right+1);
			int i = 0;
			int j = 0;
			int k = left;
			
			while(i< n1.length && j < n2.length) {
				if(n1[i] <= n2[j]) {
					arr[k] = n1[i];
					i++;
				}else {
					arr[k] = n2[j];
					j++;
				}
				k++;
			}
			while(i< n1.length) {
				arr[k] = n1[i];
				i++;
				k++;
			}
			while(j< n2.length) {
				arr[k] = n2[j];
				j++;
				k++;
			}
 		}
		return arr;
		
	}
	
	public static void mergeSort(int[] array) {
		//**********************************************
		//*  Class Wrapper for the recursive mergeSort *
		//**********************************************
		mergeSort(array,0,array.length-1);
	}
}
