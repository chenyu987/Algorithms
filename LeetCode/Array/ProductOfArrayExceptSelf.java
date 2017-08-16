/**
238 Product of Array Except Self 
  
Given an array of n integers where n > 1, nums, return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].

Solve it without division and in O(n).

For example, given [1,2,3,4], return [24,12,8,6].

Follow up: Could you solve it with constant space complexity? (Note: The output array does not count as extra space for the purpose of space complexity analysis.)


    [1 , 2 ,3 ,4]

res [1, 1  ,1, 1]
==> [1, 1 , 1, 1, 1]
==> [1  1,  4, 1  1]
   [ 1, 12, 4,1, 1]
   [ 24,12, 4, 1 ,1]
  res[i] = res[i+1] * nums[i+1]
  
  int left
  [24, 12, 4 , 1 , 1]
  [24, 12, 
   left = left*nums[i];
  res[i] = res[i] * left
*/


// from what I wrote in the meeting
public productWithOustSelf(int[] nums) {
  int[] res = new int[nums.length];
  res[nums.length - 1] = 1;
  int right = 1;
  for (int i = nums.length - 2; i >= 0; i--) {
    res[i] = res[i + 1] * right;
    right = right * nums[i];
  }
  for (int i = 1; i < nums.length; i++) {
    left = left * nums[i - 1];
    res[i] = res[i] * left;
  }
  return res;
}

// from segment fault
动态规划
复杂度
时间 O(N) 空间 O(N)

思路
分析出自身以外数组乘积的性质，它实际上是自己左边左右数的乘积，乘上自己右边所有数的乘积。所以我们可以用一个数组left[i]来表示第i个数字(nums[i])前面数的乘积，这样left[i] = left[i-1] nums[i-1]。同理，我们可以反向遍历一遍生成另一个数组right[i] = right[i + 1] nums[i+1]。得到这两个数组后，我们再遍历一遍，把每个位置的left[i]乘上right[i]就行了

双向遍历法
复杂度
时间 O(N) 空间 O(1)

思路
实际上，我们可以用结果数组自身来存储left和right数组的信息。首先还是同样的算出每个点左边所有数的乘积，存入数组中。然而在反向算右边所有数的乘积时，我们不再把它单独存入一个数组，而是直接乘到之前的数组中，这样乘完后结果就已经出来了。另外，因为我们不再单独开辟一个数组来存储右边所有数，不能直接根据数组上一个来得知右边所有数乘积，所以我们需要额外一个变量来记录右边所有数的乘积。这里为了清晰对称，遍历左边的时候也加入了一个额外变量来记录。

注意
因为第一位在第一轮从左向右乘的时候乘不到，结果数组中会得到0，所以要先将第一位置为1，即res[0] = 1，其他的不用初始化
因为涉及左右两边的数，所有数组长度为1的时候就直接返回自身就行了
代码
public class Solution {
    public int[] productExceptSelf(int[] nums) {
        if(nums.length <= 1){
            return nums;
        }
        int[] res = new int[nums.length];
        res[0] = 1;
        int left = 1, right = 1;
        // 计算每个点左边的乘积
        for(int i = 1; i < nums.length; i++){
            left = left * nums[i - 1];
            res[i] = left;
        }
        // 计算每个点右边的乘积
        for(int i = nums.length - 2; i >= 0; i--){
            right = right * nums[i + 1];
            res[i] = right * res[i];
        }
        return res;
    }
}