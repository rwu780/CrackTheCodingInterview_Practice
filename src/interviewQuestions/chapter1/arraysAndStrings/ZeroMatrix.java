package interviewQuestions.chapter1.arraysAndStrings;

import java.util.Arrays;

public class ZeroMatrix {
	
	
	public void convert(int[][] matrix) {
		int row_size = matrix.length;
		int col_size = matrix[0].length;
		
		for(int i = 0; i < row_size; i++) {
			boolean zeroExists = false;
			
			for(int j = 0; j < col_size; j++) {
				if(matrix[i][j] == 0) {
					zeroExists = true;
				}
			}
			
			if (zeroExists) {
				matrix[i] = new int[col_size];
			}
		}
	}
	

	public static void main(String[] args) {
		ZeroMatrix zm = new ZeroMatrix();
		
		int[][] matrix;
		matrix = new int[][] {{1, 0}, {3, 4}};
		System.out.println("==========");
		for(int[] i: matrix) {
			System.out.println(Arrays.toString(i));
		}
		System.out.println("--- After ---");
		zm.convert(matrix);
		System.out.println("--- Right Rotation ---");
		for(int[] i: matrix) {
			System.out.println(Arrays.toString(i));
		}
		System.out.println("==========");
		
		matrix = new int[][] {{1, 2, 3}, {4, 5, 0}, {7, 8, 9}};
		
		for(int[] i: matrix) {
			System.out.println(Arrays.toString(i));
		}
		for(int[] i: matrix) {
			System.out.println(Arrays.toString(i));
		}
		System.out.println("==========");
		
		matrix = new int[][] {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
		
		for(int[] i: matrix) {
			System.out.println(Arrays.toString(i));
		}		
		for(int[] i: matrix) {
			System.out.println(Arrays.toString(i));
		}
		System.out.println("==========");
	}


}
