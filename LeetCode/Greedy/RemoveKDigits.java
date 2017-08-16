// 402. Remove K Digits
// 题目链接：https://leetcode.com/problems...

// 根据题目的描述，移掉k个数字然后得到最小值，肯定是greedy。那么greedy的feature是什么呢？
// 看例子，首先是1432219，k = 3，不去掉1的原因是后面接的是4，当前这一步，看到下一个数比自己大的时候移掉是不划算的，因为移掉这个数之后最高位变成4，是不如保留1小的。所以可以看出规律实际上是从msb开始只要发现比之前有比当前位大的数字，那肯定要移掉之前的数字，这样当前最高位的数字就变小了。后面的3和2需要移掉也是同理。用个Stack来保存之前递增的数字。
// 再看1223，k = 1， 从左往右扫一遍发现没有出现nums[i-1] > nums[i]的情况，所以第一次扫的时候删了0个，这时候就从最大值开始移。
// 注意10200这个例子，去掉1之后，最高位是0，也得去掉。

public class Solution {
    public String removeKdigits(String num, int k) {
        StringBuilder sb = new StringBuilder();
        int n = num.length();
        char[] stack = new char[n];
        int count = 0;
        // remove the digit that larger than digit after it
        for(int i = 0; i < n; i++) {
            while(count != 0 && k > 0 && num.charAt(i) < stack[count-1]) {
                count--;
                k--;
            }
            stack[count++] = num.charAt(i);
        }
        // remove 0 at the beginning
        int start = 0;
        while(start < count && stack[start] == '0') start++;
        
        // remove from lsb
        return start >= count - k ? "0" : new String(stack, start, count - start - k);
    }
}