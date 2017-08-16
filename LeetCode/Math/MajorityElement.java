Majority Element I
Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.

You may assume that the array is non-empty and the majority element always exist in the array.
哈希表法
复杂度
时间 O(N) 空间 O(N)

思路
在遍历数组的过程中，用一个哈希表记录每个数出现过的次数，如果该次数大于一半，则说明是众数。

排序法
复杂度
时间 O(NlogN) 空间 O(1)

思路
将数组排序，这时候数组最中间的数肯定是众数。

代码
public class Solution {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }
}
位操作法
复杂度
时间 O(N) 空间 O(1)

思路
假设一个数是最多只有32位的二进制数，那么我们从第一位到第32位，对每一位都计算所有数字在这一位上1的个数，如果这一位1的个数大于一半，说明众数的这一位是1，如果小于一半，说明大多数的这一位是0。

投票法
复杂度
时间 O(N) 空间 O(1)

思路
记录一个candidate变量，还有一个counter变量，开始遍历数组。如果新数和candidate一样，那么counter加上1，否则的话，如果counter不是0，则counter减去1，如果counter已经是0，则将candidate更新为这个新的数。因为每一对不一样的数都会互相消去，最后留下来的candidate就是众数。

代码
public class Solution {
    public int majorityElement(int[] nums) {
        int candidate = nums[0], cnt = 0;
        for(int i = 1; i < nums.length; i++){
            if(candidate == nums[i]){
                cnt++;
            } else if(cnt==0){
                candidate = nums[i];
            } else {
                cnt--;
            }
        }
        return candidate;
    }
}