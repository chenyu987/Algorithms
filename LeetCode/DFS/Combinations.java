/*
Combinations
Given two integers n and k, return all possible ombinations of k numbers out of 1 ... n.

For example, If n = 4 and k = 2, a solution is:

[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]

*/

public List<List<Integer>> combi(int n, int k) {
  List<List<Integer>> res = new ArrayList<List<Integer>>();
  if (n <= 0 || n < k) return res;
  helper(1, n, k, new ArrayList<Integer>(), res);
  return res;
}

private void helper(int start, int n, int k, List<Integer> tmp, List<List<Integer>> res) {
  //临界条件
  if (tmp.size() == k) {
    //*
    res.add(new ArrayList<Integer>(tmp));
    return;
  }
  for (int i = start; i <= n; i++) {
    tmp.add(i);
    helper(i+1, n, k, tmp, res);
    tmp.remove(tmp.size()-1);
  }
}


