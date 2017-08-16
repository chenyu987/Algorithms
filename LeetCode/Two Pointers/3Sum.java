/*

Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

Note: The solution set must not contain duplicate triplets.

For example, given array S = [-1, 0, 1, 2, -1, -4],

A solution set is:
[
  [-1, 0, 1],
  [-1, -1, 2]
]

*/

// One
public class Solution {
    public List<List<Integer>> threeSum(int[] num) {
    Arrays.sort(num);
    List<List<Integer>> res = new LinkedList<>(); 
    for (int i = 0; i < num.length-2; i++) {
        if (i == 0 || (i > 0 && num[i] != num[i-1])) {
            int lo = i+1, hi = num.length-1, sum = 0 - num[i];
            while (lo < hi) {
                if (num[lo] + num[hi] == sum) {
                    res.add(Arrays.asList(num[i], num[lo], num[hi]));
                    while (lo < hi && num[lo] == num[lo+1]) lo++;
                    while (lo < hi && num[hi] == num[hi-1]) hi--;
                    lo++; hi--;
                } else if (num[lo] + num[hi] < sum) lo++;
                else hi--;
           }
        }
    }
    return res;
}
}

// two
public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums.length < 3) return result;
        Arrays.sort(nums);
        int i = 0;
        while(i < nums.length - 2) {
            if(nums[i] > 0) break;
            int j = i + 1;
            int k = nums.length - 1;
            while(j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if(sum == 0) result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                if(sum <= 0) while(nums[j] == nums[++j] && j < k);
                if(sum >= 0) while(nums[k--] == nums[k] && j < k);
            }
            while(nums[i] == nums[++i] && i < nums.length - 2);
        }
        return result;
    }
}

// segment fault
3Sum
双指针法
复杂度
时间 O(N^2) 空间 O(1)

思路
3Sum其实可以转化成一个2Sum的题，我们先从数组中选一个数，并将目标数减去这个数，得到一个新目标数。然后再在剩下的数中找一对和是这个新目标数的数，其实就转化为2Sum了。为了避免得到重复结果，我们不仅要跳过重复元素，而且要保证2Sum找的范围要是在我们最先选定的那个数之后的。

代码
public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
        for(int i = 0; i < nums.length - 2; i++){
            // 跳过重复元素
            if(i > 0 && nums[i] == nums[i-1]) continue;
            // 计算2Sum
            ArrayList<List<Integer>> curr = twoSum(nums, i, 0 - nums[i]);
            res.addAll(curr);
        }
        return res;
    }
    
    private ArrayList<List<Integer>> twoSum(int[] nums, int i, int target){
        int left = i + 1, right = nums.length - 1;
        ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
        while(left < right){
            if(nums[left] + nums[right] == target){
                ArrayList<Integer> curr = new ArrayList<Integer>();
                curr.add(nums[i]);
                curr.add(nums[left]);
                curr.add(nums[right]);
                res.add(curr);
                do {
                    left++;
                }while(left < nums.length && nums[left] == nums[left-1]);
                do {
                    right--;
                } while(right >= 0 && nums[right] == nums[right+1]);
            } else if (nums[left] + nums[right] > target){
                right--;
            } else {
                left++;
            }
        }
        return res;
    }
}

4Sum
双指针法
复杂度
时间 O(N^3) 空间 O(1)

思路
和3Sum的思路一样，在计算4Sum时我们可以先选一个数，然后在剩下的数中计算3Sum。而计算3Sum则同样是先选一个数，然后再剩下的数中计算2Sum。

代码
public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
        for(int i = 0; i < nums.length - 3; i++){
            if(i > 0 && nums[i] == nums[i-1]) continue;
            List<List<Integer>> curr = threeSum(nums, i, target - nums[i]);
            res.addAll(curr);
        }
        return res;
    }
    
    private List<List<Integer>> threeSum(int[] nums, int i, int target) {
        ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
        for(int j = i + 1; j < nums.length - 2; j++){
            if(j > i + 1 && nums[j] == nums[j-1]) continue;
            List<List<Integer>> curr = twoSum(nums, i, j, target - nums[j]);
            res.addAll(curr);
        }
        return res;
    }
    
    private ArrayList<List<Integer>> twoSum(int[] nums, int i, int j, int target){
        int left = j + 1, right = nums.length - 1;
        ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
        while(left < right){
            if(nums[left] + nums[right] == target){
                ArrayList<Integer> curr = new ArrayList<Integer>();
                curr.add(nums[i]);
                curr.add(nums[j]);
                curr.add(nums[left]);
                curr.add(nums[right]);
                res.add(curr);
                do {
                    left++;
                }while(left < nums.length && nums[left] == nums[left-1]);
                do {
                    right--;
                } while(right >= 0 && nums[right] == nums[right+1]);
            } else if (nums[left] + nums[right] > target){
                right--;
            } else {
                left++;
            }
        }
        return res;
    }
}

3Sum Closet
Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. Return the sum of the three integers. You may assume that each input would have exactly one solution.

For example, given array S = {-1 2 1 -4}, and target = 1.

The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
双指针法
复杂度
时间 O(N^2) 空间 O(1)

思路
和3Sum的解法一样。在3Sum中，我们只有找到和目标完全一样的时候才返回，但在Closet中，我们要记录一个最小的差值，并同时记录下这个最小差值所对应的和。

代码
public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closetSum = 0, minDiff = Integer.MAX_VALUE / 2;
        for(int i = 0; i < nums.length; i++){
            int left = i + 1, right = nums.length - 1;
            while(left < right){
                // 当前组合的和
                int sum = nums[i] + nums[left] + nums[right];
                // 当前组合的和与目标的差值
                int diff = Math.abs(sum - target);
                // 如果差值更小则更新最接近的和
                if(diff < minDiff){
                    closetSum = sum;
                    minDiff = diff;
                }
                // 双指针的移动方法和3Sum一样
                if (sum < target){
                    left++;
                } else if (sum > target){
                    right--;
                } else {
                    return sum;
                }
            }
        }
        return closetSum;
    }
}