Search in Rotated Sorted Array II
/**
* Follow up for "Search in Rotated Sorted Array":
* What if duplicates are allowed?
* 
* Would this affect the run-time complexity? How and why?
* Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
* 
* (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
* 
* Write a function to determine if a given target is in the array.
* 
* The array may contain duplicates.
*/


1 2 3 1 1 1
1 1 1 2 1 1 1 1 1 1

target = 2;

public boolean search (int[] A, int target) {
  if (A== null || A.length == 0) {
    return - 1;
  }
  int start = 0;
  int end = A.length - 1;
  int mid;
  
  while (start + 1 < end) {
    mid = start + (end - start) / 2;
    if (A[mid]  == target) {
      return true;
    }
    if (A[start] < A[mid]) {
      if (A[start] <= target && target <= A[mid]) {
         end = mid;
      } else {
        start = mid
      }
    else if (A[start] > A[mid]) {
      if (A[mid] <= target && target <= A[end]) {
        start = mid;
      } else {
        end = mid;    
    //the difference 
    } else {
      start += 1;
    }
  }
  if (A[start] == target || A[end] == target) {
    return true;
  }
  return false;
}