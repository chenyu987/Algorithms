Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.
               3
      2        2  2     2
  1   1  1   1 1  1  1  1  1
0 0 0 0  0 0 0 0  0  0  0  0


For example, Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.


public class Solution {
    public int trap(int[] A) {
        if (A.length() < 3) return 0;
        int left = 0;
        int right = A.length - 1;
        int sum = 0;
        // Find the first peak position on the left
        while (left < right && A[left] <= A[left + 1]) left++;
        // Find the first peak positon on the right
        while(left < right && A[right] <= A[right-1]) right--;
        // party begin
        while(left < right) {
            int leftVal = A[left];
            int rightVal = A[right];
            // 如果左边峰值较小，先计算左边
            // because we don't need wo worry about the right since the right is taller and the result depend on the shorter one
            if(leftVal < rightVal){
                // ++left is because we want to ++ then compare
                // this is awesome, need to recite
                while(left < right && leftVal >= A[++left]){
                    sum += leftVal - A[left];
                }
            // 如果右边峰值较小，先计算右边
            } else {
                while(left < right && rightVal >= A[--right]){
                    sum += rightVal - A[right];
                }
            }
        }
        return sum;
    }
}
        
    }
}


// exerciese 2:20 pm
public int trpingRainWater(int[] nums) {
    if (nums == null) return null;
    if (nums.length <= 3) return 0;
    int left = 0;
    int right = nums.length - 1;
    int total = 0;
    // when compare don't forget equal sign;
    // important to be left < right in large picture, think about why
    while (left < right && nums[left] <= nums[left + 1]) left++;
    while (left < right && nums[right] <= nums[right - 1]) right--;
    while (left < right) {
        leftVal = nums[left];
        rightVal = nums[right];
        if (leftVal < rightVal) {
            // this place need to add left < right, this could be devastating when interviewing
            // very important to use ++left, if we use if and do it once, it would went wrong, think about why
            while (leftVal >= nums[++left] && left < right) {
                total += leftVal - nums[left];
            }
        } else {
            while (rightVal >= nums[--right] && left < right) {
                total += rightVal - nums[right];
            }
        }
    }
    return total;
    
}