Happy Number
Write an algorithm to determine if a number is "happy".

A happy number is a number defined by the following process: Starting with any positive integer, replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.

Example: 19 is a happy number

1^2 + 9^2 = 82
8^2 + 2^2 = 68
6^2 + 8^2 = 100
1^2 + 0^2 + 0^2 = 1
集合法
复杂度
时间 待定 空间 待定

思路
根据快乐数的计算方法，我们很难在有限步骤内确定一个数是否是快乐数，但使用排除法的话，我们可以尝试确定一个数不是快乐数。根据题意，当计算出现无限循环的时候就不是快乐数。出现无限循环的说明产生了相同的结果，而判断相同结果只要用Set就行了。

代码
public class Solution {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<Integer>();
        // 当n一直不happy得时候
        while(n!=1){
            int sum = 0;
            // while里的运算把这个数从各位到最高位平方后相加
            while(n>0){
                sum += (n % 10) * (n % 10);
                n = n / 10;
            }
            // 如果set里有代表有环，直接返回错，这里不可能在加入1时返回错，因为第一次加进去的时候已经跳出while循环
            if(set.contains(sum)){
                return false;
            // 没有那么把它加进set
            } else {
                set.add(sum);
            }
            n = sum;
        }
        return true;
    }
}
后续 Follow Up
Q: 可不可以不用HashTable或者HashSet解决这题？A: 可以，参考Linked List Cycle，我们可以记录下每轮产生的结果，同时用快慢指针遍历，一旦快慢指针相与便说明有环。