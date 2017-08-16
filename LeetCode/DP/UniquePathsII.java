/*
Follow up for "Unique Paths":

Now consider if some obstacles are added to the grids. How many unique paths would there be?

An obstacle and empty space is marked as 1 and 0 respectively in the grid.

For example,
There is one obstacle in the middle of a 3x3 grid as illustrated below.

[
  [0,0,0],
  [0,1,0],
  [0,0,0]
]
*/

public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        for(int i = 0; i < m; i++){
            if(obstacleGrid[i][0] == 1) break;
            dp[i][0] = 1;
        }
        for(int i = 0; i < n; i++){
            if(obstacleGrid[0][i] == 1) break;
            dp[0][i] = 1;
        }
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                dp[i][j] = obstacleGrid[i][j] != 1 ? dp[i-1][j] + dp[i][j-1] : 0;
            }
        }
        return dp[m-1][n-1];
    }
}




dp[i][j] = dp[i - 1][j] + dp[i][j - 1];

__(i-1,j-1)_|_B(i-1, j)__
_C_(i,j-1)_ | A (i,j)
  
  A= B+C
public int uniquePathII(int[][] grid) {
  if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
  int[] res = new int[grid[0].length];
  res[0] = 1;
  for (int i = 0; i < grid.length; i++) {
    for (int j = 0; j< grid[0].length; j++) {
      if (grid[i][j] == 1) {
        res[j] = 0;
      } else {
        res[j] = res[j] + res[j-1]; // A = B + C; 
      }
    }
  }
  return res[gird[0].length-1];
}
