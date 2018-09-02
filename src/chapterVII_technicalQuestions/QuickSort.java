package chapterVII_technicalQuestions;

import java.util.Arrays;

public class QuickSort {
	
	public void sort(int[] array) {
		sortArray(array, 0, array.length-1);
	}
	
	public void sortArray(int[] array, int low, int high) {
		if(low < high) {
			int pivot = partition(array, low, high);
			sortArray(array, low, pivot - 1);
			sortArray(array, pivot + 1, high);
		}
	}
	
	private int partition(int[] array, int low, int high) {
		int pivot = array[high];
		int lessThanPivotIndex = low;
		
		for(int i = low; i < high; i ++) {
			if(array[i] <= pivot) {
				swap(array, lessThanPivotIndex, i);
				lessThanPivotIndex += 1;
			}
		}
				
		swap(array, lessThanPivotIndex, high);
		
		return lessThanPivotIndex;
	}
	
	public void swap(int[] array, int index1, int index2) {
		int temp = array[index1];
		array[index1] = array[index2];
		array[index2] = temp;
	}

	public static void main(String[] args) {
		int[] array = new int[] {1, 34, 43, 5, 34, 234, 543, 32, 13, 1, 35, 90};
		
		QuickSort qs = new QuickSort();
		qs.sort(array);
		
		System.out.println(Arrays.toString(array));
	}

}
