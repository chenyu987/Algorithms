/*
Majority Element II
Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times. The algorithm should run in linear time and in O(1) space.
投票法
复杂度
时间 O(N) 空间 O(1)

思路
上一题中，超过一半的数只可能有一个，所以我们只要投票出一个数就行了。而这题中，超过n/3的数最多可能有两个，所以我们要记录出现最多的两个数。
同样的两个candidate和对应的两个counter，如果遍历时，某个候选数和到当前数相等，则给相应计数器加1。
如果两个计数器都不为0，则两个计数器都被抵消掉1。如果某个计数器为0了，则将当前数替换相应的候选数，并将计数器初始化为1。
最后我们还要遍历一遍数组，确定这两个出现最多的数，是否都是众数。

代码
*/
public class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<Integer>();
        if(nums.length == 0) return res;
        int c1 = 1, c2 = 0, n1 = nums[0], n2 = 0;
        for(int i = 1; i < nums.length; i++){
            // 如果和某个候选数相等，将其计数器加1
            if(nums[i] == n1){
                c1++;
            } else if(nums[i] == n2){
                c2++;
            // 如果都不相等，而且计数器都不为0，则计数器都减1
            } else if(c1 != 0 && c2 != 0){
                c1--;
                c2--;
            // 如果某个计数器为0，则更新相应的候选数
            } else {
                if(c1 == 0){
                    n1 = nums[i];
                    c1 = 1;
                } else {
                    n2 = nums[i];
                    c2 = 1;
                }
            }
        }
        c1 = 0;
        c2 = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == n1) c1++;
            else if(nums[i] == n2) c2++;
        }
        if(c1 > nums.length / 3) res.add(n1);
        if(c2 > nums.length / 3) res.add(n2);
        return res;
    }
}