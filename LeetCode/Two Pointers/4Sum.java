/**
* Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.
* 
* Note: The solution set must not contain duplicate quadruplets.
* 
* For example, given array S = [1, 0, -1, 0, -2, 2], and targe-t = 0.
* 
* A solution set is:
* [
*   [-1,  0, 0, 1],
*   [-2, -1, 1, 2],
*   [-2,  0, 0, 2]
* ]
*/

/*
solution 1
复杂度
时间O(n^3) 空间O(1)
思路：N指针 N=4 
3sum的扩展 外层再加一个循环->做N次3Sum 
*/

public class 4Sum {
	public List<List<Integer>> fourSum(int[] num, int target) {
	  List<List<Integer>> res = new ArrayList<List<Integer>>();
		if (num == null || num.length <= 3) return res;
		Arrays.sort(num);
		for (int i = num.length - 1; i > 2; i--) {
			if (i == num.length - 1 || num[i] != num[i+1]) {
				List<List<Integer>> subRes = threeSum(num, i-1, target-num[i]);
				for (int j = 0; j < subRes.size(); j++) {
					subRes.get(j).add(num[i]);
				}
				res.addAll(subRes);
			}
		}
		return res;
	}
	
	private List<List<Integer>> threeSum(int[] num, int idx, int target) {
	  List<List<Integer>> res = new ArrayList<List<Integer>>();
		if (num == null || num.length <= 2) return res;
		Arrays.sort(num);
		for (int i = idx; i > 1; i--) {
			if (i == idx || num[i] != num[i+1]) {
				List<List<Integer>> subRes = twoSum(num, i-1, target-num[i]);
				for (int j = 0; j < subRes.size(); j++) {
					subRes.get(j).add(num[i]);
				}
				res.addAll(subRes);
			}
		}
		return res;
	}
	
	private List<List<Integer>> twoSum(int[] num, int idx, int target) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		int left = 0;
		int right = idx;
		while (left < right) { 
			if (num[left] + num[right] == target) {
				List<Integer> subRes = new ArrayList<Integer>();
				subRes.add(num[left]);
				subRes.add(num[right]);
				res.add(subRes);
				left++;
				right--;
				while (left < right && num[left] == num[left-1]) {
				  left++;
				}
				while (left < right && num[right] == num[right+1]) {
				  right--;
				}
			} else if (num[left] + num[right] < target) {
				left++;
			} else {
				right--;
			}
		}
		return res;
	}
}