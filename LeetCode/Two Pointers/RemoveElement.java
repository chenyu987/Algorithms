// Given an array and a value, remove all instances of that value in place and return the new length
// The order of elements can be changed. It doesn't matter what you leave beyongd the new length

// 典型的数组里快慢指针问题，解决的精髓在于如果找到快指针动，慢指针不动记录当前要被换掉的位置，等块指针移动到legit的点时对慢指针所在点动手，然后快慢指针++
public class Solution {
    public int removeElement(int[] nums, int val) {
        int fast = 0;
        int slow = 0;
        while (fast < nums.length) {
            if (nums[fast] == val) {
                fast++;
            } else {
                nums[slow] = nums[fast]
                fast++;
                slow++;
            }
        }
        return slow;
    }
}