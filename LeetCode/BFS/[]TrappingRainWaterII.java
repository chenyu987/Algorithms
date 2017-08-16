/**
* the volume of water it is able to trap after raining.
* 
* Note:
* Both m and n are less than 110. The height of each unit cell is greater than 0 and is less than 20,000.
* 
* Example:
* 
* Given the following 3x6 height map:
* [
*   [1,4,3,5,3,2],
*   [3,2,1,1,2,4],
*   [2,3,3,5,3,1]
* ]
* 
* Return 4.
*/
  
heap + bfs

public int trapWaterII(int[][] heightMap) {
  if (heightMap == null || heightMap.length == 0) return 0;
  
  // helper class 
  class Cell {
    private int x;
    private int y;
    private int h;
    
    public Cell(int x, int y, int h) {
      this.x = x;
      this.y = y;
      this.h = h;
    }
  }  
    
  int row = heightMap.length;
   int col = heightMap[0].length;
    
  PriorityQueue pq = new PriorityQueue<Cell>(new Comparator<Cell>() {
    public int compare (Cell cell1, Cell cell2) {
      return cell1.h - cell2.h;
    }
  }); 
  boolean[][] visited = new boolean[row][col];
  for (int i = 0; i < row; i++) {
    visited[i][0] = true;
    visited[i][col-1] = true;
    pq.offer(new Cell(i, 0, heightMap[i][0]));
    pq.offer(new Cell(i, col-1, heightMap[i][col-1]));
  }
  
  for (int j = 0; j < col; j++) {
    visited[0][j] = true;
    visited[row-1][j] = true;
    pq.offer(new Cell(0, j, heightMap[0][j]));
    pq.offer(new Cell(row-1, j, heightMap[row-1][j]));
  }  
  
  int[] dx = {-1, 1, 0, 0};
  int[] dy = {0, 0, 1, -1};
  int sum = 0;
  int maxH = Integer.MIN_VALUE;
  while (!pq.isEmpty()) {
    Cell cell = pq.poll();
    maxH = Math.max(maxH, cell.h);
    for (i = 0; i < 4; i++) {
      int curX = cell.x + dx[i];
      int curY = cell.y + dy[i];
      if (curX >= 0 && curY >= 0 && curX < row && curY < col && !visited[curX][curY]) {
        visited[curX][curY] = true;
        if (heightMap[curX][curY] < maxH) {
          sum += maxH - heightMap[curX][curY];
        }
        pq.offer(new Cell(curX, curY, heightMap[curX][curY]));
      }
    }
  }
  return sum;  
}