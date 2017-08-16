/**
* Given an array of integers, every element appears twice except for one. Find that single one.
* 
* Note:
* Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
*/

public int singleNumber(int[] nums) {
  int[] digits = new int[32];
  for (int i = 0; i < 32; i++) {
    for (int j = 0; j < nums.length; j++) {
      digits[i] += (nums[j] >> i) & 1;
    }
  }
  int single = 0;
  for (int i = 0; i < 32; i++) {
    single += (digits[i] % 2) << i; 
  }
  return signle;
}