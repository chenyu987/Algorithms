public int lengOfLastWord(String s) {
  String[] sArray = s.trm().split(" +");
  String lastWord = sArray[sArray.length - 1];
  return lastWord.length();
}
while (s.charAt(idx) != ' ')
idx--;
end = idx;

idx--
start = idx;


Length of Last Word
Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.

If the last word does not exist, return 0.

Note: A word is defined as a character sequence consists of non-space characters only.

For example, Given s = "Hello World", return 5
API法
复杂度
时间 O(N) 空间 O(N)

思路
简单的使用API。先trim再split再用length。

代码
public class Solution {
    public int lengthOfLastWord(String s) {
        return s.trim().split(" +")[s.trim().split(" +").length - 1].length();
    }
}
双指针法
复杂度
时间 O(N) 空间 O(1)

思路
从后往前看字符串，跳过所有空格后，记下该结束位置，再到下一个空格，再记录一个开始位置，则长度就是结束位置减去开始位置。在跳过空格的循环后，要判断是否已经超界，如果超界则返回0

代码
public class Solution {
    public int lengthOfLastWord(String s) {
        int idx = s.length() - 1;
        // 跳过末尾的空格
        while(idx >= 0){
            if(s.charAt(idx) != ' ') break;
            idx--;
        }
        // 记录结束位置
        int end = idx;
        // 如果已经超界返回0
        if(idx < 0) return 0;
        // 找到开始位置
        while(idx >= 0){
            if(s.charAt(idx) == ' ') break;
            idx--;
        }
        return end - idx;
    }
}