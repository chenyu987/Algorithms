/*
Maximal Rectangle
Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing all ones and return its area.
动态规划 + 栈
复杂度
时间 O(NM) 空间 O(M)

思路
这题的解法基于上题。要求最大的矩形，实际上可以将矩阵的每一行，转化为上一题的直方图，而直方图的每个竖条的数字，就是该行对应坐标正上方，向上方向有多少个连续的1。要转化为直方图，方法是每一行的数值都累加上一行计算出来的数值，而第一行的数值就是本身。如果原始矩阵中遇到0，则累加中断，重新置0。

0 0 1 1 0 -> 0 0 1 1 0
0 0 1 1 0 -> 0 0 2 2 0
1 1 0 0 0 -> 1 1 0 0 0
1 1 1 0 0 -> 2 2 1 0 0

*/

public class Solution {
    public int maximalRectangle(char[][] matrix) {
        int max = 0;
        if(matrix.length == 0) return 0;
        int[][] dp = new int[matrix.length][matrix[0].length];
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                // 如果是第一行就是自身，如果遇到0则停止累加
                dp[i][j] =  i == 0 ? matrix[i][j] - '0' : matrix[i][j] == '1' ? dp[i-1][j] + matrix[i][j] - '0' : 0;
            }
        }
        for(int i = 0; i < dp.length; i++){
            //找每行的最大矩形
            int tmp = findRowMax(i, dp);
            max = Math.max(max, tmp);
        }
        return max;
    }
    
    private int findRowMax(int row, int[][] matrix){
        if(matrix[row].length== 0) return 0;
        Stack<Integer> stk = new Stack<Integer>();
        int i = 1, max = matrix[row][0];
        stk.push(0);
        while(i < matrix[row].length || (i == matrix[row].length && !stk.isEmpty())){
            if(i != matrix[row].length && ( stk.isEmpty() || matrix[row][i] >= matrix[row][stk.peek()] )){
                stk.push(i);
                i++;
            } else {
                int top = matrix[row][stk.pop()];
                int currMax = !stk.isEmpty() ? top * (i - stk.peek() - 1) : top * i;
                max = Math.max(currMax, max);
            }
        }
        return max;
    }
}

// Wrote in the meeting, combined with Zhe's as helper function

public int maximalRectangle(char[][] matrix) {
  int max = 0;
  if (matrix == null || matrix.length == 0) return 0;
  int[][] dp = new int[matrix.length][matrix.length[0]);
  for (int i = 0; i < matrix.length; i++) {
    for (int j = 0; j < matrix[0].length; i++) {
      dp[i][j] = i == 0? matrix[i][j] - '0' : matrix[j][j] == '1' ? dp[i - 1][j] + matrix[i][j] - '0' : 0;
    }
  }
  for (int i = 0; i <dp.length; i++) {
    int tmp = findRowMax(i, dp);
    max = Math.max(max, tmp);
  }
  return max;
}

private int findRowMax(int row, int[][] dp) {
  if (matrix == null || matrix.length == 0) return 0;
  Stack<Integer> stack = new Stack<Integer>();
  int[] heights = dp[row];
  int maxArea = 0;
  int curArea = 0;
  for (int i = 0; i < heights.length; i++) {
    while (!stack.isEmpty() && heights[i] <= heights[stack.peek()]) {
      int idx = stack.pop();
      int height = heights[idx];
      int width = stack.isEmpty() ? i : (i-1-stack.peek());  
      curArea = height*width;
      maxArea = Math.max(maxArea, curArea);
    }
  }
  while (!stack.isEmpty()) {
    int idx = stack.pop();
    int height = heights[idx];
    int width = stack.isEmpty() ? heights.length : (heights.length-1-stack.peek());
    curArea = height*width;
    maxArea = Math.max(maxArea, curArea);
  }
  return maxArea;
}
