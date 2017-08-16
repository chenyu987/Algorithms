// Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.

// click to show follow up.

// Follow up: Did you use extra space? A straight forward solution using O(mn) space is probably a bad idea. A simple improvement uses O(m + n) space, but still not the best solution. Could you devise a constant space solution?

public void setZeroes(int[][] matrix) {
  if (matrix.length == 0) return;
  boolean firstRowZero = false; 
  boolean firstColZero = false;
  for (int i = 0; i < matrix.length; i++) {
    for (int j = 0; j < matrix.length; j++) {
      if (i != 0 && j != 0 && matrix[i][j] == 0) {
        matrix[i][0] = 0;
        matrix[0][j] = 0;
      // } else {
      // if (matrix[i][j] == 0)
      } else if (matrix[i][j] == 0) {
        if (i == 0) {
          firstRowZero = true;
        }
        else {
          firstColZero = true;
        }
    }
    for (int i =1; i <matrix.length; i++) {
      for (int j = 1; j < matrix[0].length; j++) {
        if (matrix[0][j] == 0 || matrix[i][0] == 0) {
          matrix[i][j] = 0;
        }
      }
    }
    
    for (int i = 0; i < matrix.length; i++) {
      if (firstColZero == true) {
        matrix[i][0] = 0;
      }
    }
    for (int i = 0; i < matrix[0].length; i++) {
      if (firstRowZero == true) {
        matrix[i][0] = 0;
      }
    }
  }
}