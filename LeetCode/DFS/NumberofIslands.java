
// Number of Islands
// Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

// Example 1:

// 11110
// 11010
// 11000
// 00000
// Answer: 1

// Example 2:

// 11000
// 11000
// 00100
// 00011
// Answer: 3

public int numIslands(char[][] grid) {
  if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
  int rowNum = grid.length;
  int colNum = gird[0].lengthl 
  boolean[][] visited = new boolean[rowNum][colNum];
  int cnt = 0;
  
  for (int i = 0; i < rowNum; i++) {
    for (int j = 0; j < colNum; j++) {
      if (!visited[i][j] && grid[i][j] == '1') {
        cnt++;
        search(grid, visited, i, j);
      }
    }
  }
  return cnt;
}

private void search(char[][] grid, boolean[][] visited, int row, int col) {
  if (row >= 0 && row < grid.length && col >= 0 && col < grid[0].length && !visited[row][col] && grid[row][col] == '1') {
    visited[row][col] = true;
    search(grid, visited, row+1,col);
    search(grid, visited, row-1,col);
    search(grid, visited, row,col+1);
    search(grid, visited, row,col-1);
  }
}


public class Solution {
    public int numIslands(char[][] grid) {
        int res = 0;
        if(grid.length==0) return res;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j]=='1'){
                    searchIsland(grid, i, j);
                    res++;
                }
            }
        }
        return res;
    }
    
    private void searchIsland(char[][] grid, int i, int j){
        grid[i][j]='0';
        // 搜索该点连通的上下左右
        if(i>0 && grid[i-1][j]=='1') searchIsland(grid, i-1, j);
        if(j>0 && grid[i][j-1]=='1') searchIsland(grid, i, j-1);
        if(i<grid.length-1 && grid[i+1][j]=='1') searchIsland(grid, i+1, j);
        if(j<grid[0].length-1 && grid[i][j+1]=='1') searchIsland(grid, i, j+1);
    }
}

后续 Follow Up
Q:如何找湖的数量呢？湖的定义是某个0，其上下左右都是同一个岛屿的陆地。A:我们可以先用Number of island的方法，把每个岛标记成不同的ID，然后过一遍整个地图的每个点，如果是0的话，就DFS看这块连通水域是否被同一块岛屿包围，如果出现了不同数字的陆地，则不是湖

Q:如何找不同形状的岛屿？ -> 相同config==相同岛

11100
01000
00111
00010   

dfs(, , , , int direction)     

set: (r r r l d)  
