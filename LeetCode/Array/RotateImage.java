/**
* You are given an n x n 2D matrix representing an image.
* 
* Rotate the image by 90 degrees (clockwise).
* 
* Follow up:
* Could you do this in-place?
*/

/*
solution 1
复杂度
时间O(n^2) 空间O(1)
思路：转置镜像法
step 1: transpose the matrix: matrix[i][j] <-> matrix[j][i](转置)
step 2: flip each row of transposed matrix(镜像)
*/

[
[1, 2, 3]
[4, 5, 6]
[7, 8, 9]
]
=>
[
[7, 4, 1]
[8, 5, 2]
[9, 6, 3]
]



public class RotateImage {
	public void rotate(int[][] matrix) {
		if (matrix == null || matrix.length == 0) {
			return;
		}
		int rowNum = matrix.length;
		int colNum = rowNum;
		// transpose the matrix
		for (int i = 0; i < rowNum; i++) {
			for (int j = i + 1; j < colNum; j++) {
				swap(i, j, matrix);
			}
		}
		// flip each row of transposed matrix
		for (int i = 0; i < rowNum; i++) {
			for (int j = 0; j < (colNum >> 1); j++) {
				flip(i, j, matrix);
			}
		}
	}
	
	private void swap(int i, int j, int[][] matrix) {
		int tmp = matrix[i][j];
		matrix[i][j] = matrix[j][i];
		matrix[j][i] = tmp;
	}
	
	private void flip(int i, int j, int[][] matrix) {
		int colNum = matrix[0].length;
		int tmp = matrix[i][j];
		matrix[i][j] = matrix[i][colNum-j-1];
		matrix[i][colNum-j-1] = tmp;
	}
} 

// exercise
public void rotate(int[][] matrix) {
	if (matrix == null || matrix.length == 0) {
		return;
	}
	for(int i = 0; i < matrix.length; i++) {
		for (int j = i; j < matrix[0].length; j++) {
			swap(matrix, i, j);
		}
	}
	for (int i = 0; i < matrix.length; i++) {
		flip(matrix[i]);
	}
}

private void swap(int[][] matrix, int i, int j) {
	int tmp = matrix[i][j];
	matrix[i][j] = matrix[j][i];
	matrix[j][i] = tmp;
}

private void flip(int[] row) {
	for (i = 0; i < row.length / 2; i++) {
		int tmp = row[i]; 
		row[i] = row[row.length - i - 1];
		row[row.length - i - 1] = tmp;
	}
}
