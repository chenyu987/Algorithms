/**
* Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.
* 
* For example, given the following triangle
* [
*      [2],
*     [3,4],
*    [6,5,7],
*   [4,1,8,3]
* ]
* The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
* 
* Note:
* Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.
*/

public int minSum(List<List<Integer>> tri) {
  if (tri == null || tri.size() == 0) return 0;
  int row = tri.size();
  int col = row;
  int[][] res = new int[row][col];
  for (int j = 0; j < col; j++) {
    res[row-1][j] = tri.get(row-1).get(j);
  }
  for (int i = row - 2; i >= 0; i++) {
    for (int j = 0; j <= i; j++) {
      res[i][j] = Math.min(res[i+1][j], res[i+1][j+1]) + tri.get(i).get(j); 
    }
  }
  return res[0][0];
}





// 滚动数组优化空间

// res:
 
// 4   1    8   3

// ==>

// 7   6   10   3

int[] res = new int[col];

for (int i = row - 2; i >= 0; i++) {
  for (int j = 0; j <= i; j++) {
    res[j] = Math.min(res[j],res[j+1]) + tri.get(i).get(j);
  }
}
return res[0];