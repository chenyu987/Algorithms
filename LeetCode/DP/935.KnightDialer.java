/*

The chess knight has a unique movement, it may move two squares vertically and one square horizontally, or two squares horizontally and one square vertically (with both forming the shape of an L). The possible movements of chess knight are shown in this diagaram:

A chess knight can move as indicated in the chess diagram below:

We have a chess knight and a phone pad as shown below, the knight can only stand on a numeric cell (i.e. blue cell).


Given an integer n, return how many distinct phone numbers of length n we can dial.

You are allowed to place the knight on any numeric cell initially and then you should perform n - 1 jumps to dial a number of length n. All jumps should be valid knight jumps.

As the answer may be very large, return the answer modulo 109 + 7.

Example 1:

Input: n = 1
Output: 10
Explanation: We need to dial a number of length 1, so placing the knight over any numeric cell of the 10 cells is sufficient.
Example 2:

Input: n = 2
Output: 20
Explanation: All the valid number we can dial are [04, 06, 16, 18, 27, 29, 34, 38, 40, 43, 49, 60, 61, 67, 72, 76, 81, 83, 92, 94]
Example 3:

Input: n = 3131
Output: 136006598
Explanation: Please take care of the mod.

*/

class Solution {
  public int knightDialer(int n) {
    final int kMod = (int) 1e9 + 7;
    final int[][] dirs = {{-2, 1}, {-1, 2}, {1, 2}, {2, 1}, {2, -1}, {1, -2}, {-1, -2}, {-2, -1}};
    // dp[i][j] := # of ways to stand on (i, j)
    int[][] dp = new int[4][3];
    Arrays.stream(dp).forEach(row -> Arrays.fill(row, 1));
    dp[3][0] = dp[3][2] = 0;

    for (int k = 0; k < n - 1; ++k) {
      int[][] newDp = new int[4][3];
      for (int i = 0; i < 4; ++i)
        for (int j = 0; j < 3; ++j) {
          if (isNotNumericCell(i, j))
            continue;
          for (int[] dir : dirs) {
            final int x = i + dir[0];
            final int y = j + dir[1];
            if (x < 0 || x >= 4 || y < 0 || y >= 3)
              continue;
            if (isNotNumericCell(x, y))
              continue;
            newDp[i][j] = (newDp[i][j] + dp[x][y]) % kMod;
          }
        }
      dp = newDp;
    }

    int ans = 0;

    for (int[] row : dp)
      for (final int a : row)
        ans = (ans + a) % kMod;

    return ans;
  }

  private boolean isNotNumericCell(int i, int j) {
    return i == 3 && (j == 0 || j == 2);
  }
}
