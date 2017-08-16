// Spiral Matrix II
Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.

For example, Given n = 3,

You should return the following matrix:

[
 [ 1, 2, 3 ],
 [ 8, 9, 4 ],
 [ 7, 6, 5 ]
]



public int[][] spiralMatrixII(int n) {
  int[][]result = new int[n][n];
  int left = 0;
  int right = n - 1;
  int top = 0;
  int bottom = n - 1;
  int num = 1;
  while (left < right && top < bottom) {
    for (int i = left; i < right; i++) {
      result[left][i] = num++; 
    }
    for (int i = top; i < bottom; i++) {
      result[i][top] = num++;
    }
    for (int i = right; i > left; i--) {
      result[right][i] = num++;
    }
    for (int i = bottom; i > top; i--) {
      result[i][bottom] = num++;
    }
    top++;
    left++;
    right--;
    bottom--;
  }
  if (n % 2 == 1) {
    result[n/2][n/2] = num;
  }
  return result;
}