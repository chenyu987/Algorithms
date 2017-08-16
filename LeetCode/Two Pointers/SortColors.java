/*
Sort Colors
Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.

Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
交换法
复杂度
时间 O(N) 空间 O(1)

思路
我们先用两个指针，一个指向已经排好序的0的序列的后一个点，一个指向已经排好序的2的序列的前一个点。这样在一开始，两个指针是指向头和尾的，因为我们还没有开始排序。然后我们遍历数组，当遇到0时，将其和0序列后面一个数交换，然后将0序列的指针向后移。当遇到2时，将其和2序列前面一个数交换，然后将2序列的指针向前移。遇到1时，不做处理。这样，当我们遍历到2序列开头时，实际上我们已经排好序了，因为所有0都被交换到了前面，所有2都被交换到了后面。

代码
*/


public class Solution {
    public void sortColors(int[] nums) {
        int left = 0, right = nums.length - 1;
        int i = 0;
        while(i <= right){
            // 遇到0交换到前面
            if(nums[i] == 0){
                swap(nums, i, left);
                left++;
                // 因为左边必定有序，所以可以直接i++
                i++;
            // 遇到2交换到后面
            } else if(nums[i] == 2){
                swap(nums, i, right);
                right--;
            } else {
            // 遇到1跳过 
                i++;
            }
        }
    }
    
    private void swap(int[] nums, int i1, int i2){
        int tmp = nums[i1];
        nums[i1] = nums[i2];
        nums[i2] = tmp;
    }
}