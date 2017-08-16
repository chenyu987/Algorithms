/**
* Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
* 
* For example,
* Given the following matrix:
* 
* [
*  [ 1, 2, 3 ],
*  [ 4, 5, 6 ],
*  [ 7, 8, 9 ]
* ]
* You should return [1,2,3,6,9,8,7,4,5].
*/

// From Zhe
/*
复杂度
时间:O(nm)  空间O(1)
思路：顺序展开 
维护四个变量 row, col, x, y
按照"右 下 左 上"的顺序展开原矩阵 每经过一圈展开 更新四个变量:x和y各加1，row和col各减2
如果只剩下一行或者一列 直接把该行/列加入结果集 
*/

public class SpiralMatrix {
	public List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> res = new ArrayList<Integer>();
	  if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return res;
    int row = matrix.length;
    int col = matrix[0].length;
    int x = 0; 
    int y = 0;

    while (row > 0 && col > 0) {
			// if one row/col left, just add items into List res
      if (row == 1) {
			  for (int j = 0; j < col; j++) {
					res.add(matrix[x][y++]);
				}
				break;
			}
      if (col == 1) {
				for (int i = 0; i < row; i++) {
					res.add(matrix[x++][y]);
				}
			  break;  
			}
      // below process is a circle 
      // from top to right
      for (int i = 0; i < col - 1; i++) {
				res.add(matrix[x][y++]);
			}
      // from right to down 
      for (int i = 0; i < row - 1; i++) {
				res.add(matrix[x++][y]);
			}
      // from down to left 
      for (int i = 0; i < col - 1; i++) {
				res.add(matrix[x][y--]);
			}
      // from left to top
      for (int i = 0; i < row - 1; i++) {
				res.add(matrix[x--][y]);
			}
      x++;
      y++;
      row -= 2;
      col -= 2;	 		
		}
    return res;		
	}
}
// From Segment Fault
顺序添加法
复杂度
时间 O(NM) 空间 O(1)

思路
首先考虑最简单的情况，如图我们先找最外面这圈X，这种情况下我们是第一行找前4个，最后一列找前4个，最后一行找后4个，第一列找后4个，这里我们可以发现，第一行和最后一行，第一列和最后一列都是有对应关系的。即对i行，其对应行是m - i - 1，对于第j列，其对应的最后一列是n - j - 1。

XXXXX
XOOOX
XOOOX
XOOOX
XXXXX
然后进入到里面那一圈，同样的顺序没什么问题，然而关键在于下图这么两种情况，一圈已经没有四条边了，所以我们要单独处理，只加那唯一的一行或一列。另外，根据下图我们可以发现，圈数是宽和高中较小的那个，加1再除以2。

OOOOO  OOO
OXXXO  OXO
OOOOO  OXO
       OXO
       OOO
代码
public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new LinkedList<Integer>();
        if(matrix.length == 0) return res;
        int m = matrix.length, n = matrix[0].length;
        // 计算圈数
        int lvl = (Math.min(m, n) + 1) / 2;
        for(int i = 0; i < lvl; i++){
            // 计算相对应的该圈最后一行
            int lastRow = m - i - 1;
            // 计算相对应的该圈最后一列
            int lastCol = n - i - 1;
            // 如果该圈第一行就是最后一行，说明只剩下一行
            if(i == lastRow){
                for(int j = i; j <= lastCol; j++){
                    res.add(matrix[i][j]);
                }
            // 如果该圈第一列就是最后一列，说明只剩下一列
            } else if(i == lastCol){
                for(int j = i; j <= lastRow; j++){
                    res.add(matrix[j][i]);
                }
            } else {
                // 第一行
                for(int j = i; j < lastCol; j++){
                    res.add(matrix[i][j]);
                }
                // 最后一列
                for(int j = i; j < lastRow; j++){
                    res.add(matrix[j][lastCol]);
                }
                // 最后一行
                for(int j = lastCol; j > i; j--){
                    res.add(matrix[lastRow][j]);
                }
                // 第一列
                for(int j = lastRow; j > i; j--){
                    res.add(matrix[j][i]);
                }
            }
        }
        return res;
    }
}