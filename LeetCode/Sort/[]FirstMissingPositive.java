// First Missing Positive
// Given an unsorted integer array, find the first missing positive integer.

// For example, Given [1,2,0] return 3, and [3,4,-1,1] return 2.

// Your algorithm should run in O(n) time and uses constant space.



nums : 1 13 3 -4 5 6 -7
idx:   0 1  2  3 4 5  6
         i

public int firstMissingPositive(int[] nums) {
  if (nums == null || nums.length == 0) {
    return 1;
  }
  int len = nums.length;
  for (int i = 0; i < len; i++) {                          
    if (nums[i] > 0 && nums[i] < len && nums[i] != nums[nums[i]-1]) {
      int tmp = nums[nums[i]-1];
      nums[nums[i]-1] = nums[i];
      nums[i] = tmp;
      i--;
    }                   
  }
  
  for (int i = 0; i < len; i++) { 
    if (nums[i] != i+1) {
      return i+1;
    }
  }
  
  return len+1;
}


// 映射法
// 复杂度
// 时间 O(N) 空间 O(1)

// 思路
// 核心思想就是遍历数组时，将每个元素，和以该元素为下标的元素进行置换，比如第一个元素是3，就将它置换到下标为3的地方，而原本下标为3的地方的元素就换到第一个来。如果换来的元素也是在正确的位置就检查下一个元素，否则继续交换，直到：

// 待交换的两个数是一样的
// 当前位置的元素没有对应的目的地（比如负数，或者超界元素）
// 注意
// 数组是从0开始的，而正数是从1开始的，为了简化映射关系，把数组里所有元素都减了1，最后返回答案时再加1即可。
// 如果最后还没找到，就说明缺失的是最后一个数n
// 代码

public class Solution {
    public int firstMissingPositive(int[] nums) {
        //减1预处理数组，简化映射关系
        for(int i = 0; i < nums.length; i++){
            nums[i]--;
        }
        for(int i = 0; i < nums.length;i++){
            while(nums[i]!=i && nums[i] >=0 && nums[i]<nums.length && nums[i]!=nums[nums[i]]){
                int tmp = nums[i];
                nums[i] = nums[nums[i]];
                nums[tmp] = tmp; 
            }
        }
        //找出第一个不在对应位置的数
        for(int i = 0; i < nums.length; i++){
            if(nums[i]!=i) return i+1;
        }
        //都没找到说明是最后一个数
        return nums.length+1;
    }
}