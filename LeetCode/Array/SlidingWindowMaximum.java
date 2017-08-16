 
/*  
239 Sliding Window Maximum
Sliding Window Maximum
Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position.

For example, Given nums = [1,3,-1,-3,5,3,6,7], and k = 3.

Window position                Max
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7 
 
 
 
Window position                Max     dequeue
---------------               -----
[1  3  -1] -3  5  3  6  7       3     [3, -1]
 1 [3  -1  -3] 5  3  6  7       3     [3, -1, -3]
 1  3 [-1  -3  5] 3  6  7       5     [5]
 1  3  -1 [-3  5  3] 6  7       5     
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7 


Therefore, return the max sliding window as [3,3,5,5,6,7].

Note: You may assume k is always valid, ie: 1 ≤ k ≤ input array's size for non-empty array.

Follow up: Could you solve it in linear time?

Hint:

How about using a data structure such as deque (double-ended queue)? The queue size need not be the same as the window’s size. Remove redundant elements and the queue should store only elements that need to be considered.
*/
public int[] maxWindowMaximum(int[] nums. int k) {
  int[] max = new int[nums.length - k + 1];
  if (nums == null || nums.length == 0 || k == 0) {
    return max;
  }
  PriorityQueue<Integer> pq = new PriorityQueue<Integer>(new Comparator<Integer>() {
    public int compare(int i1, int i2) {
      return i2 - i1;
    }
  });
  for (int i = 0; i <nums.length; i++) {
    if (i >= k) {
      pq.remove(nums[i - k];
    }
    pq.offer(nums[i]);
    if (pq.size() == k) {
      max[i - k + 1] = pq.peek();
    }
  }
  return max;
}

// exercise
public int[] maximumWindow(int[] nums, int k) {
  int[] max = new int[nums.length - k + 1];
  if (nums == null || nums.length == 0) {
    return null;
  }
  PriorityQueue<Integer> pq = new PriorityQueue<Integer> (new Comparator<Integer>() {
    public int compare(int i1, int i2) {
      return i2 - i1;
    }
  });
  for (int i = 0; i < nums.length; i++) {
    if (i >= k) {
      pq.remove(nums[i - k]);
    }
    pq.offer(nums[i]);
    if (i >= k - 1) {
      max[i - k + 1] = pq.peek();
    }
  }
  return max;
}

/*
Dequeue. A double-ended queue or deque(pronounced "deck") is a generalization of a stack and a queue that supports inserting and removing items from either the front or theback of the data structure
*/

java 官方文档 关于双向队列接口
https://docs.oracle.com/javase/7/docs/api/java/util/Deque.html
       
tail 
        3  2  1  0  
                     head
 



public int[] maxWindowMaximum(int[] nums. int k) {
  int[] max = new int[nums.length - k + 1];
  if (nums == null || nums.length == 0 || k == 0) {
    return max;
  }
  Deque<Integer> deque = new LinkedList<Integer>();
  for (int i = 0; i < nums.length; i++) {
//   该移除的就移除，无论大小，因为本轮它不该在window里
//  为什么不可以dequeue里存数组里的值？ 因为这样就不能做这一步了，如果拿size能判断？不能啊。每次都poll？也不能啊
    if (!deque.isEmpty() && deque.peek() == i - k) deque.poll();
//     deque里面是下标 而不是值
    while (!deque.isEmpty() && nums[deque.peekLast() < nums[i]) {
      deque.removeLast();
    }
    deque.offerLast(i);
    if (i - k + 1 >= 0) {
      max[i - k + 1] = nums[deque.peek()];
    }
  return max;
}
