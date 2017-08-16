215
Kth Largest Element in an Array

Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.

For example, Given [3,2,1,5,6,4] and k = 2, return 5.

Note: You may assume k is always valid, 1 ≤ k ≤ array's length.

Method1: Sort
Time: O(NlogN) Space: O(1)

public int kthLargestElement(int[] nums, int k) {
  Arrays.sort(nums);
  return nums[nums.length - k];
}

Method2: PriorityQueue
public int kthLargestElement(int[] nums, int k) {
  PriorityQueue<Integer> pq = new PriorityQueue<Integer>(new Comparator<Integer>() { 
    public int compare (int i1, int i2) {
      return i2 - i1;
    }
  });
  for (int i: nums) {
    pq.offer(i);
  }
  for (int i = 0; i < k - 1; i++) {
    pq.poll();
  }
  return pq.peek();
}

Method3: QuickSort
Time: O(n) in average

            
1  2   2   4   4   6  3   9   
       p
           l  
       r   

             l
             r   
[items <=p   p   items >= p]


public int findKLargest(int[] nums, int k) {
  if (nums == null || nums.length == 0) return -1;
  if (nums.length < 2) return nums[0];
  int lo = 0; 
  int hi = nums.length - 1;
  while (lo <= hi) {
    int idx = partition(nums, lo, hi);
    if (idx < nums.length - k) lo = idx + 1;
    else if (idx > nums.length - k) hi = idx - 1;
    else return nums[idx];
  }
  return -1;
}

private int partition(int[] nums, int lo, int hi) {
  int i = lo;
  int j = hi + 1;
  int pivot = nums[lo];
  
  while (true) {
    while (i < hi && nums[++i] < pivot) {
      if (i == hi) break;
    }
    while (nums[--j] > pivot) {
      if (j == lo) break;
    } 
    if (i >= j) break;
    exchange(nums, i, j);
  }
  
  exchange(nums, lo, j);
  return j;
}
