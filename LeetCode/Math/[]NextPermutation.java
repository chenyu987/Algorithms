// Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

// If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).

// The replacement must be in-place, do not allocate extra memory.

// Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
// 1,2,3 → 1,3,2
// 3,2,1 → 1,2,3
// 1,1,5 → 1,5,1


// 升序倒置法
// 复杂度
// 时间 O(N) 空间 O(1)

// 思路
// 首先我们来思考下，什么是next permutation
// 比如124651这个序列，我们如果只想它变大一点点，应该尽可能的不去增加高位。因为增加高位会带来更大的增益。所以对于一个长为n的序列，我们增加第n位的前提是，前n-1位已经达到了最大排列方法。所以我们从后往前看：

// 1
// 51
// 651
// 前面三位已经是各自最大的情况，不可能再变大，而到万位的时候4651，可以将4移到后面来来增大。但是问题在于，把谁移到4的位置。因为是找下一个数，所以我们要找一个比4小却尽可能大的数，所以找到5。把5换到4的位置后，后三位仍然是个降序的排列。然而这时候，因为已经将万位增大了，我们要将前三位尽可能的变小，做成一个以5开头最小的序列，而这个序列应该是升序的，所以我们直接把后三位倒置一下，就从降序变成升序了。

// 注意
// 找第一个下降点的循环和着第一个比下降点稍大的数的循环，其判断条件都要包含=
// 代码

public class Solution {
    public void nextPermutation(int[] nums) {
        if(nums.length <= 1){
            return;
        }
        int i = nums.length - 2;
        // 找到第一个下降点，我们要把这个下降点的值增加一点点
        // 对于511这种情况，要把前面两个1都跳过，所以要包含等于
        while(i >= 0 && nums[i] >= nums[i + 1]){
            i--;
        }
        // 如果这个下降点还在数组内，我们找到一个比它稍微大一点的数替换
        // 如果在之外，说明整个数组是降序的，是全局最大了
        if(i >= 0){
            int j = nums.length - 1;
            // 对于151，这种情况，要把最后面那个1跳过，所以要包含等于
            while(j > i && nums[j] <= nums[i]){
                j--;
            }
            swap(nums, i, j);
        }
        // 将下降点之前的部分倒序构成一个最小序列
        reverse(nums, i + 1, nums.length - 1);
    }
    
    private void swap(int[] nums, int i, int j){
        int tmp = nums[j];
        nums[j] = nums[i];
        nums[i] = tmp;
    }
    
    private void reverse(int[] nums, int left, int right){
        while(left < right){
            swap(nums, left, right);
            left++;
            right--;
        }
    }
}


// From Zhe Liu
/*
复杂度
时间O(n) 空间O(1)
思路：找规律
从右往左扫，找到第一个满足：nums[i-1] < nums[i]条件的，再找到从右到左第一个比nums[i-1]大的数，把它们swap，再把所有i-1之后的数字swap即可。
边界条件：1. i = nums.length - 1，这时候i-1之后只有一个值, 2. 数组一直递减，这时候i变成0，没有nums[i-1] to swap，只需要swap从0到nums.length - 1的所有数。
*/

public class NextPermutation {
	public void nextPermutation(int[] nums) {
		if (nums == null || nums.length == 0) return;
    int idx = nums.length - 1;
    while (idx > 0) {
		  if (nums[idx-1] < nums[idx]) break;
			idx--;
		}		
		if (idx > 0) {
		  int ptr = nums.length - 1;
      while (ptr >= 0) {
				if (nums[ptr] > nums[idx-1]) break;
				ptr--;
			}
      swap(nums, idx-1, ptr);
		}
		
		int right = nums.length - 1;
		while (idx < right) {
			swap(nums, idx, right);
			idx++;
			right--;
		}
	}
	
	private void swap(int[] nums, int i, int j) {
		int tmp = nums[i];
	  nums[i] = nums[j];
		nums[j] = tmp;
	}
}
 