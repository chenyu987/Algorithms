/**
* Given a set of distinct integers, nums, return all possible subsets.
* 
* Note: The solution set must not contain duplicate subsets.
* 
* For example,
* If nums = [1,2,3], a solution is:
* 
* [
*   [3],
*   [1],
*   [2],
*   [1,2,3],
*   [1,3],
*   [2,3],
*   [1,2],
*   []
* ]
*/

/*
复杂度
时间： NP 指数级 空间O(n)
思路：回溯法
N皇后模板 循环中递归处理子问题
注意：
这里我们对输入数组排序 只是为了AC leetcode 否则过不了 其实不用排序
*/

public class Subsets {
  public List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> res = new ArrayList<List<Integer>>();
    if (nums == null || nums.length == 0) return res;
    Arrays.sort(nums);
    helper(res, new ArrayList<Integer>(), nums, 0);
    return res;	
  }
	
  private void helper(List<List<Integer>> res, List<Integer> curList, int[] nums, int idx) {
	  if (idx > nums.length) return;
	  res.add(new ArrayList<Integer>(curList));
  	for (int i = idx; i < nums.length; i++) {
	    curList.add(nums[i]);
	    helper(res, curList, nums, i+1);
	    curList.remove(curList.size()-1);
	  }
  }
} 


// wrote at meeting
public List<List<Integer>> subsets(int[] nums) {
  List<List<Integer>> res = new ArrayList<List<Integer>>();
  if (nums == null || nums.length == 0) return res;
  helper(nums, res, 0, new ArrayList<Integer>());
  return res;
}

private void helper(int[] nums, List<List<Integer>> res, int idx, List<Integer> tmp) {
  if (idx == nums.length) return;
  res.add(new ArrayList<Integer>(tmp));
  for(int i = idx; i < nums.length; i++) {
    tmp.add(nums[i]);
    helper(nums, res, i + 1, tmp);
    tmp.remove(tmp.size() - 1);
  }
}

// exercise
public List<List<Integer>> subsets(int[] nums) {
  List<List<Integer>> result = new ArrayList<ArrayList<Integer>>();
  if (nums == null || nums.length == 0) return result;
  helper(nums, 0, new ArrayList<Integer>(), result);
  return result;
}

private void helper(int[] nums, int offset, List<Integer> tmp, List<List<Integer>> result) {
  if (offset == nums.length) return;
  result.add(new ArrayList<Integer>(tmp));
  for (int i = offset, i< nums.length, i++) {
    tmp.add(nums[i]);
    helper(nums, offset + 1, tmp, result);
    tmp.remove(tmp.size() - 1);
  }
}