package interviewQuestions.chapter1.arraysAndStrings;

import java.util.Arrays;

public class RotateMatrix {
	
	public void rotateMatrixRight(int[][] matrix) {
		int size = matrix.length;
		
		for(int i = 0; i < size / 2; i++) {
			rotateCornerRight(matrix, i, i, size - i * 2 - 1);
			rotateEdgeRight(matrix, i, i, size - i * 2 - 1);
		}
	}
	
	public void rotateCornerRight(int[][] matrix, int x, int y, int size) {
		int temp = matrix[x][y];
		matrix[x][y] = matrix[x + size][y];
		matrix[x + size][y] = matrix[x + size][y + size];
		matrix[x + size][y + size] = matrix[x][y + size];
		matrix[x][y + size] = temp;
	}
	
	public void rotateEdgeRight(int[][] matrix, int x, int y, int size) {
		for(int j = x + 1; j < y + size; j++) {
			int temp = matrix[x][y + j];
			matrix[x][y + j] = matrix[x + size - j][y];
			matrix[x+size - j][y] = matrix[x+size][y+size-j];
			matrix[x + size][y + size - j] = matrix[x + j][y + size];
			matrix[x+j][y+size] = temp;
		}
		
	}

	public static void main(String[] args) {
		RotateMatrix rm = new RotateMatrix();
		
		int[][] matrix;
		matrix = new int[][] {{1, 2}, {3, 4}};
		System.out.println("==========");
		for(int[] i: matrix) {
			System.out.println(Arrays.toString(i));
		}
		rm.rotateMatrixRight(matrix);
		System.out.println("--- Right Rotation ---");
		for(int[] i: matrix) {
			System.out.println(Arrays.toString(i));
		}
		System.out.println("==========");
		
		matrix = new int[][] {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
		
		for(int[] i: matrix) {
			System.out.println(Arrays.toString(i));
		}
		rm.rotateMatrixRight(matrix);
		System.out.println("--- Right Rotation ---");
		for(int[] i: matrix) {
			System.out.println(Arrays.toString(i));
		}
		System.out.println("==========");
		
		matrix = new int[][] {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
		
		for(int[] i: matrix) {
			System.out.println(Arrays.toString(i));
		}		
		rm.rotateMatrixRight(matrix);
		System.out.println("--- Right Rotation ---");
		for(int[] i: matrix) {
			System.out.println(Arrays.toString(i));
		}
		System.out.println("==========");
	}
	
}
