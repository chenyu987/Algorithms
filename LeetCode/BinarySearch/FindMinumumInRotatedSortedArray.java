/**
* Follow up for "Find Minimum in Rotated Sorted Array":
* What if duplicates are allowed?
* 
* Would this affect the run-time complexity? How and why?
* Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
*                                
*                                             right
                                left
                                        mid
(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
* 
* Find the minimum element.
* 
* The array may contain duplicates. -> 算法可能退化到线性时间
*/
 5 5 5 5 5 5 
public int findMin(int[] nums) {
  if (nums == null || nums.length == 0) return 0;
  int left = 0;
  int right = nums.length -1;
  int min = nums[0];
  while (left <= right) {
  //  if (left == right) return nums[left];
    int mid = left + (right - left) / 2;
    if (nums[left] < nums[mid]) {
      min = Math.min(nums[left], min);
      left = mid + 1;
    } else if (nums[left] > nums[mid]) {
      min = Math.min(nums[mid], min);
      right = mid - 1;
    } else {
      min = Math.min(nums[left], min);
      left++;
    }
  }
  return min;
}
