
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