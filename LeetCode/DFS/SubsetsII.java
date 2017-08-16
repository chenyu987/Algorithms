
// Given a collection of integers that might contain duplicates, S, return all possible subsets. Note: Elements in a subset must be in non-descending order. The solution set must not contain duplicate subsets. For example, If S = [1,2,2], a solution is: [ [2], [1], [1,2,2], [2,2], [1,2], [] ]

public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] nums) {
  ArrayList<ArrayList<Integer>> result = new ArrayList<>();
  if (nums == null) {
    return result;
  }
  if (nums.length == 0) {
    result.add(new ArrayList<Integer>());
    return result;
  }
  Arrays.sort(nums);
  helper(nums, 0, new ArrayList<Integer>(), result);
  return result;
}

public void helper(int[] nums, int offset, ArrayList<Integer> tmp, ArrayList<List<Integer>> result) {
  if (offset >= nums.length) return;
  result.add(tmp);
  for (int i= offset; i < nums.length; i++) {
    if (i != offset && nums[i] == nums[i - 1] {
      continue;
    }
    tmp.add(nums[i]);
    helper(nums, i + 1, tmp, result);
    tmp.remove(tmp.size() - 1);
  }
}