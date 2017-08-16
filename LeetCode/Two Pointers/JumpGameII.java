/*Jump Game II
Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Your goal is to reach the last index in the minimum number of jumps.

For example: Given array A = [2,3,1,1,4]

The minimum number of jumps to reach the last index is 2. (Jump 1 step from index 0 to 1, then 3 steps to the last index.)
双指针法
复杂度
时间 O(N) 空间 O(1)

思路
如果要计算最短的步数，就不能贪心每次都找最远距离了，因为有可能一开始跳的远的路径，后面反而更慢。所以我们要探索所有的可能性，这里用快慢指针分出一块当前结点能跳的一块区域，然后再对这块区域遍历，找出这块区域能跳到的下一块区域的上下边界，每块区域都对应一步，直到上界超过终点时为之。

代码
*/
public class Solution {
    public int jump(int[] nums) {
        int high = 0, low = 0, preHigh = 0, step = 0;
        while(high < nums.length - 1){
            step++;
            //记录下当前区域的上界，以便待会更新下一个区域的上界
            preHigh = high;
            for(int i = low; i <= preHigh; i++){
                //更新下一个区域的上界
                high = Math.max(high, i + nums[i]);
            }
            //更新下一个区域的下界
            low = preHigh + 1;
        }
        return step; 
    }
}
后续 Follow Up
Q：如果要求返回最短跳跃路径，如何实现？A：可以使用DFS，并根据一个全局最短步数维护一个全局最短路径，当搜索完所有可能后返回这个全局最短路径。


// Wrote Myself
public int minJump(int[] nums) {
  int left = 0;
  int right = 0;
  int step = 0;
  int curMostRright = 0;
  while (right < nums.length - 1) {
    curMostRight = right;
    //  （ i < curMostRight）  这里需要用一个curMostRight原因是此for循环内right会变化，这样循环外面顺序会乱
    for (int i = left; i < curMostRight; i++) {
      right = Math.max(right, i + nums[i]);
    }
    left = curMostRight + 1;
    step++;
  }
  return step;
}
