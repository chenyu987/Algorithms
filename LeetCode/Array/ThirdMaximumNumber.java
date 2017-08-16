/*
Third Maximum Number
Given a non-empty array of integers, return the third maximum number in this array. If it does not exist, return the maximum number. The time complexity must be in O(n).

Example 1:
Input: [3, 2, 1]

Output: 1

Explanation: The third maximum is 1.
Example 2:
Input: [1, 2]

Output: 2

Explanation: The third maximum does not exist, so the maximum (2) is returned instead.
Example 3:
Input: [2, 2, 3, 1]

Output: 1

Explanation: Note that the third maximum here means the third maximum distinct number.
Both numbers with value 2 are both considered as second maximum.
*/

public class Solution {
    public int thirdMax(int[] nums) {
       PriorityQueue<Integer> pq = new PriorityQueue<>();
       Set<Integer> set = new HashSet<>();
       for(int n : nums) {
           if(set.add(n)) {
               pq.offer(n);
               if(pq.size() > 3 ) pq.poll();
           }
       }
       if(pq.size() == 2) pq.poll();
       return pq.peek();
    }
}

// use TreeSet (里面从小到大排而且不重复)
public int thirdMax (int[] nums) {
  TreeSet<Integer> set = new TreeSet<>();
  for (int num : nums) {
    set.add(num);
  }
  int[] res = new int[set.size()];
  int idx = 0;
  for (int num : set) {
    res[idx] = num;
    idx++;
  }
  if (set.size() < 3) return res[set.size() - 1];
  return res[set.size() - 3];
}

// use three Pointers
public int thirdMax(int[] nums) {
  int first = nums[0];
  int second = nums[0];
  int third = nums[0];
  for (int i = 0; i < nums.length; i++) {
    if (nums[i] > first) {
      third = second;
      second = first;
      first = nums[i];
    } else if (nums[i] != first && (nums[i] > second || second == first)) {
      third = second;
      second = nums[i];
    } else if ((nums[i] != first && nums[i] != second) && (nums[i] > third || third == second || third == first)) {
      third = nums[i];
    }
  }
  if (first > second && second > third) return third;
  else return first;
}
