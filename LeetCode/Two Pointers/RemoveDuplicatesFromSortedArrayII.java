/*
Remove Duplicates from Sorted Array II
Follow up for "Remove Duplicates": What if duplicates are allowed at most twice?

For example, Given sorted array nums = [1,1,1,2,2,3],

Your function should return length = 5, with the first five elements of nums being 1, 1, 2, 2 and 3. It doesn't matter what you leave beyond the new length.
*/


public int removeDulis(int[] nums) {
  if (nums == null || nums.length == 0) return 0;
  int idx = 0;
  int cnt = 0;
  for (int i = 0; i < nums.length; i++) {
    if (i > 0 && nums[i] == nums[i-1]) {
      cnt++;
      if (cnt > 2) {
        continue;
      }
    } else {
      cnt = 1;
    }
    nums[idx] = nums[i];
    idx++;
  }
  return idx;
}