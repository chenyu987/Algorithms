/**
* Follow up for N-Queens problem.
* 
* Now, instead outputting board configurations, return the total number of distinct solutions.
*/

/*
复杂度：
时间： NP 指数级 空间O(n)
思路：
跟N-Queens算法是完全一样的，只是把输出从原来的结果集变为返回结果数量而已
*/


// what I wrote on meeting coding pad

public int totalQueensII(int n) {
  List<Integer> result = new ArrayList<Integer>();
  if (n <= 0) return result;
  helper(0, n, new ArrayList<Integer>(), result);
  return result;
}

private void helper(int row, int n, List<Integer> tmp, ArrayList<Integer> result) {
  if (row == n) {
    if (isValid(tmp)) {
      result.set(0, result.get(0) + 1);
    }
    return;
  } 
  else {
    for (int j = 0; j < n; j++) {
      tmp.add(j);
      if (isValid(tmp)) {
        helper(row + 1, n, tmp, result);
      }
      tmp.remove(tmp.size() - 1);
    }
  }
} 

private boolean isValid(List<Integer> tmp) {
  int row = tmp.size() - 1;
  int col = tmp.get(row);
  for (int i = 0; i <= row - 1; i++) {
    int otherRow = i;
    int otherCol = tmp.get(i);
    if (otherCol == col) return false;
    if (Math.abs(otherCol-col) == Math.abs(otherRow-row)) return false;
  }
  return true;
}