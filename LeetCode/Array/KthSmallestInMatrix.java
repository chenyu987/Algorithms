// Kth smallest in matrix

Given a n x n matrix where each of the rows and columns are sorted in ascending order, find the kth smallest element in the matrix.

Note that it is the kth smallest element in the sorted order, not the kth distinct element.

Example:

matrix = [
   [ 1,  5,  9999],
   [10, 11, 1333333],
   [12, 13, 15555555]
],
k = 8,

return 13.
[9, 5, 1,]
 
     
       
      
  
  
    
public int kthSmallest(int[][] matrix, int k) {
  if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return -1;
  // using lamda experssion  
  // PriorityQueue<Integer> pq = new PriorityQueue<Integer>(k+1, (a,b) -> b - a); 
  PriorityQueue<Integer> pq = new PriorityQueue<Integer>(k+1, new Coparator<Integer> () {
    public int compare (int a, int b) {
      return b - a;  
    }
  });
  for (int i = 0; i < matrix.length; i++) {
    for (int j = 0; j < matrix[0].length; j++) {
      pq.offer(matrix[i][j]);
      if (pq.size() > k) {
        pq.poll();  
      }
    }
  }
  return pq.poll;
}

[1,2]
[1,3]
 
  
public int ktSmallest(int[][] matrix, int k) {
  int row = matrix.length;
  int col = row;
  int left = matrix[0][0];
  int right = marix[row-1][col-1];
  int[] idx = new int[2];
  
  while (left <= right) {
    int mid = left + (right - left) / 2;
    int num = cnt(matrix, mid, idx);
    if (num == k) {
      return matrix[idx[0]][idx[1]];
    } else if (num < k) {
      left = mid + 1;  
    } else {
      right = mid - 1;    
    }
    idx[0] = 0;
    idx[1] = 0;
  }
  return 0;
}
//   找多少个数不小于target
private int cnt(int[][] matrix, int target, int[] idx) {
  int row = matrix.length;
  int res = 0;
  int i = row - 1;
  int j = 0;
  while (i >= 0 && j < row) {
    if (matrix[i][j] <= target) {
      res += i + 1;  
      j++;
    } else {
      i--;  
    }
    if (j > res[1]) {
      idx[0] = i;
      idx[1] = j - 1;
    }
  }
  return res;
}