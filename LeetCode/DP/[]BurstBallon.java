 
/**
* Given n balloons, indexed from 0 to n-1. Each balloon is painted with a number on it represented by array nums. You are asked to burst all the balloons. If the you burst balloon i you will get nums[left] * nums[i] * nums[right] coins. Here left and right are adjacent indices of i. After the burst, the left and right then becomes adjacent.
* 
* Find the maximum coins you can collect by bursting the balloons wisely.
* 
* Note: 
* (1) You may imagine nums[-1] = nums[n] = 1. They are not real therefore you can not burst them.
* (2) 0 ≤ n ≤ 500, 0 ≤ nums[i] ≤ 100
* 
* Example:
* 
* Given [3, 1, 5, 8]
* 
* Return 167
* 
*     nums = [3,1,5,8] --> [3,5,8] -->   [3,8]   -->  [8]  --> []
*    coins =  3*1*5      +  3*5*8    +  1*3*8      + 1*8*1   = 167
*/ 

1 - 4

[1, 2 , 3 ,4]
[2, 1 , 3 ,4]
....               k 
         i            j
* Given [1, 3 , 1, 5, 8, 1]


res[i][j] = Math.max(res[i][k-1] + res[k+1][j] + nums[k] * nums[i-1] * nums[j+1]
res[0][len-1]

// dfs
private int calculateCoins(int[]plan, int[]nums) {
  for 
    
    coints += nums[plan[i]] * num[plan[i] - 1] * nums[plan[i] + 1];
    nums[plan[i]] = null;

  max = math.max(coins, max);
  }
return max;
}

// dp
public int maxCoins(int[] nums) {
  if (nums == null || nums.length == 0) return 0;
  int len = nums.length;
  int[][] res = new int[len][len];
  for (int curLen = 1; curLen <= len; curLen++) {
    for (int i = 0; i+curLen <= len; i++) {
      int j = i + curLen - 1;
      for (int k = i; k <= j; k++) {
        res[i][j] = Math.max(res[i][j], ((i <= k-1) ? res[i][k-1] : 0) + ((k+1 <= j ) ? res[k+1][j] : 0) + nums[k] * ((i-1 >= 0) ? nums[i-1] : 1) * ((j+1 < curLen) ? nums[j+1] : 1));
      }
    }
  }
  return res[0][len-1];
}
