package chapterVII_technicalQuestions;

import java.util.Arrays;

public class MergeSort {

	public static void main(String[] args) {
		int[] array = new int[] {1, 34, 43, 5, 34, 234, 543, 32, 13, 1, 35, 90};
		
		MergeSort ms = new MergeSort();
		ms.sort(array);
		
		System.out.println(Arrays.toString(array));
	}

	public void sort(int[] array) {
		sortArray(array, 0, array.length - 1);
	}

	private void sortArray(int[] array, int start, int end) {
		
		if(start == end) {
			return;
		}
		
		if(start < end) {
			int middle = (start + end) / 2;
			
			sortArray(array, start, middle);
			sortArray(array, middle + 1, end);
			
			mergeArray(array, start, middle, end);
		}
	}

	private void mergeArray(int[] array, int start, int middle, int end) {
		int[] newArray = new int[end - start + 1];
		
		int leftArrayIndex = start;
		int rightArrayIndex = middle + 1;
		
		for(int i = start; i <= end; i++) {
			int value = Integer.MAX_VALUE;
			if(rightArrayIndex > end) {
				value = array[leftArrayIndex];
				leftArrayIndex++;
			}
			else if(leftArrayIndex > middle) {
				value = array[rightArrayIndex];
				rightArrayIndex++;
			}
			else if(array[leftArrayIndex] <= array[rightArrayIndex]) {
				value = array[leftArrayIndex];
				leftArrayIndex ++;
			}
			else if(array[rightArrayIndex] < array[leftArrayIndex]) {
				value = array[rightArrayIndex];
				rightArrayIndex ++;
			}
			newArray[i - start] = value;
		}
		
		for(int i = start; i <= end; i++) {
			array[i] = newArray[i - start];
		}
	}
}
