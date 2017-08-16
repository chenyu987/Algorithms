Roman to Integer
Given a roman numeral, convert it to an integer.
The answer is guaranteed to be within the range from 1 to 3999.

Symbol   Value
I        1
V        5
X        10
L        50
C        100
D        500
M        1,000

Roman to Integer:

建立HashMap，存入Roman的数值对应关系。然后从String s从前向后遍历每个字符，找到map对应的值累加，if遇到前一位值小于后一位值的情况，减去前一位值的2倍（if外面多加了一次，减2倍减回来）。

Solution

Roman to Integer

public class Solution {
    public int romanToInt(String s) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        map.put('M', 1000);
        map.put('D', 500);
        map.put('C', 100);
        map.put('L', 50);
        map.put('X', 10);
        map.put('V', 5);
        map.put('I', 1);
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            res += map.get(s.charAt(i));
            if (i > 0 && map.get(s.charAt(i-1)) < map.get(s.charAt(i))) 
                res -= 2 * map.get(s.charAt(i-1));
        }
        return res;
    }
}