/**
* You want to build a house on an empty land which reaches all buildings in the shortest amount of distance. You can only move up, down, left and right. You are given a 2D grid of values 0, 1 or 2, where:
* 
* Each 0 marks an empty land which you can pass by freely.
* Each 1 marks a building which you cannot pass through.
* Each 2 marks an obstacle which you cannot pass through.
* For example, given three buildings at (0,0), (0,4), (2,2), and an obstacle at (0,2):
* 
* 1 - 0 - 1 - 0 - 0
* |   |   |   |   |
* 0 - 2 - 0 - 0 - 0
* |   |   |   |   |
* 1 - 0 - 0 - 0 - 0
* The point (1,2) is an ideal empty land to build a house, as the total travel distance of 3+3+1=7 is minimal. So return 7.
* 
* Note:
* There will be at least one building. If it is not possible to build such house according to the above rules, return -1.
*/
// 对每个building的点进行宽搜， 记录每个点到这个building的距离 然后三次得出来的数加起来取最小的
public int shortestDistance(int[][] grid) {
  if (grid == null || grid.length == 0) return -1;
  int row = grid.length;
  int col = grid[0].length;
  
  int[][] dist = new int[row][col];
  int[][] num = new int[row][col];
  int buildNum = 0;
  for (int i = 0; i < row; i++) {
    for (int j = 0; j < col; j++) {
      if (grid[i][j] == 1) {
        buildNum++;
        bfs(grid, i, j, dist, num);
      }
    }
  }
  int minDist = Integer.MAX_VALUE;
  for (int i = 0; i < row; i++) {
    for (int j = 0; j < col; j++) {
      if (grid[i][j] == 0 && dist[i][j] != 0 && num[i][j] == buildNum) {
        minDist = Math.min(minDist, dist[i][j]);  
      }
    }
  }
  if (minDist < Integer.MAX_VALUE) return minDist;
  return -1;
}

private void bfs(int[][] grid, int row, int col, int[][] dist, int[][] num) {
  int row = grid.length;
  int col = grid[0].length;
  
  
  Queue<int[]> queue = new LinkedList<int[]>();
  int[] dx = {-1, 1, 0 , 0};
  int[] dy = {0 , 0, -1, 1};
  boolean[][] visited = new boolean[row][col];
  int level = 0;
  while (!queue.isEmpty()) {
    level++;
    qLen = queue.size();
    for (int i = 0; i < qLen; i++) {
      int[] corr = queue.poll;
      for (int j = 0; j < 4; j++) {
        int x = corr[0] + dx[j];
        int y = corr[1] + dy[j];
        if (x >= 0 && y >=0 && x < row && y < col && !visited[x][y]) {
          visited[x][y] = true;
          queue.offer(new int[]{x, y});
//           num记录这个点是否能hit到所有的1，如果能hit到那么++， 所以最后判断时候 还要满足num[i][j] == buildNum
          if (grid[x][y] == 1) {
            num[x][y]++;  
          }
          dist[x][y] += level;
        }
      }
     
    }
  }
  
}