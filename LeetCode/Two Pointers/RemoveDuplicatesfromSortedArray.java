// the wrong one

public int removeDuplicates(int[] nums) {
    if (nums == null || nums.length == 0) return 0;
    int slow = 0;
    int fast = 0;
    while (fast < nums.length) {
        if (nums[fast] == nums[fast - 1]) {
            fast++;
        } else {
            nums[slow] = nums[fast];
            fast++;
            slow++;
        }
    }
    slow = slow == 0? 1, slow;
    return slow;
}
// 典型的数组里快慢指针问题，解决的精髓在于如果快指针找到非法点快指针动，慢指针不动记录当前要被换掉的位置，等块指针移动到legit的点时对慢指针所在点动手，然后快慢指针++

// the right one
public class Solution {
    public int removeDuplicates(int[] nums) {
            if (nums == null || nums.length == 0) return 0;
        int slow = 1;
        int fast = 1;
        while (fast < nums.length) {
            if (nums[fast] == nums[fast - 1]) {
                fast++;
            } else {
                nums[slow] = nums[fast];
                fast++;
                slow++;
            }
        }
        return slow;
    }
}