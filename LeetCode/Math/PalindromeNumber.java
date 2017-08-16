Palindrome Number
Determine whether an integer is a palindrome. Do this without extra space.
反转比较法 Reverse and Compare
复杂度
时间 O(n) 空间 O(1)

思路
回文数有一个特性，就是它反转后值是一样的。所以我们可以先将其反转，然后比较反转数和原数是否相等。该方法的问题在于溢出的判断和处理，我们可以参考反转整数中的几种处理方法。

// certainly we can use integer to string then string.toCharArray. But this need extra space.
代码
public class Solution {
    public boolean isPalindrome(int x) {
        // this place need to be a long in case after reverse it oveflow.
        long reverse = 0, original = x;
        if(x<0){
            return false;
        }
        while(x>0){
            reverse *= 10;
            reverse += x % 10;
            x /= 10;
        }
        return original == reverse;
    }
}
逐位比较法 One By One
复杂度
时间 O(n) 空间 O(1)

思路
反转比较有可能会溢出，但我们遍历每一位的时候其实并不用保存上一位的信息，只要和当前对应位相等就行了。所以我们可以遍历一遍先算出数的长度，再遍历一遍同时对比前后的对应位。

代码
public class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0){
            return false;
        }
        int digits = 1;
        int original = x;
        // 计算当前数的位数，个位数不用计算，已经默认为1
        while(x > 9){
            digits *= 10;
            x /= 10;
        }
        // 逐位比较
        x = original;
        while(x > 0){
            int msd = x / digits;
            int lsd = x % 10;
            if(msd != lsd){
                return false;
            }
            // 去除最高位和最低位
            x -= msd * digits;
            x /= 10;
            digits /= 100;
        }
        return true;
    }
}
后续 Follow Up
Q：在答题之前我需要知道些什么？ A：因为回文的定义原本只适用于字符串，所以我们要先问清楚数字回文是如何定义的。首先，负数是否算回文。其次，在计算回文时，我们应该按十进制算还是其他进制，如二进制。