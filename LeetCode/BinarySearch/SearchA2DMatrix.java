/*
Search a 2D Matrix I
Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

Integers in each row are sorted from left to right. The first integer of each row is greater than the last integer of the previous row. For example,

Consider the following matrix:

[
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
Given target = 3, return true.
二分法
复杂度
时间 O(log(MN)) 空间 O(1)

思路
我们可以把二维数组想象成一个一维数组，第一行尾连着第二行头，第二行尾连着第三行头...同样是有个最小值最大值，二分得到中间值，通过对中间值取模可以得到对应二维数组的下标。这样，该题就转化为了一维有序数组二分搜索的题了。

注意
二分搜索的几个边界条件是min<=max，min=mid+1,max=mid-1
代码
*/

public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        if(m == 0) return false;
        int n = matrix[0].length;
        int min = 0, max = m * n - 1;
        while(min <= max){
            int mid = min + (max - min) / 2;
            int row = mid / n;
            int col = mid % n;
            if(matrix[row][col] == target){
                return true;
            } else if (matrix[row][col] < target){
                min = mid + 1;
            } else {
                max = mid - 1;
            }
        }
        return false;
    }
}

// Method II from Zhe


public boolean search2D(int[][] matrix, int target) {
  if (matrix == null || matrix.length == 0) return false;
  int left = 0;
  int right = matrix.length - 1;
  
  //decide which row the target is at
  while (left <= right) {
    int mid = left + (right - left) / 2;
    if (matrix[mid][0] == target) {
      return true;
    } else if (matrix[mid][0] < target) {
      left = mid + 1;
    } else {
      right = mid - 1;
    } 
  }
  int row = right;
  int left = 0;
  int right = matrix[0].length - 1;
  //decide which 
  while (left <= right) {
    int  mid = left + (right - left) / 2;
    if (matrix[row][mid] == target) {
      return true;
    } else if (matrix[row][mid] < target) {
      left = mid + 1;
    } else {
      right = mid - 1;
    }
  }
  return false;
  
}
