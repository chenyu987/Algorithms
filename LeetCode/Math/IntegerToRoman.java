Problem
Integer to Roman
Given an integer, convert it to a roman numeral.
The number is guaranteed to be within the range from 1 to 3999.

Symbol   Value
I        1
V        5
X        10
L        50
C        100
D        500
M        1,000

Note
Integer to Roman:

建立映射：整数数组num -- 字符串数组roman，这两个数组都要从大到小，为了方便之后对整数n进行从大到小的分解，以便用StringBuilder()从前向后建立Roman数字。

Solution
Integer to Roman

public class Solution {
    public String intToRoman(int n) {
        // Write your code here
        String[] roman = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] num = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (n != 0) {
            if (n >= num[i]) {
                sb.append(roman[i]);
                n -= num[i];
            }
            else i++;
        }
        return sb.toString();
    }
}