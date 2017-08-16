/*
* Given an input string, reverse the string word by word.
* 
* For example,
* Given s = "the sky is blue",
* return "blue is sky the".
*/

Clarification:
What constitutes a word?
A sequence of non-space characters constitutes a word.
Could the input string contain leading or trailing spaces?
Yes. However, your reversed string should not contain leading or trailing spaces.
How about multiple spaces between two words?
Reduce them to a single space in the reversed string.

      i l 
the     sky

sb: sky_  


public class Solution {
    public char[] reverseWords(char[] s) {
        if (s == null || s.length() == 0) return s;
        int left = 0;
        int right = s.length - 1;
        
        while (left  < right && (s[left] == ' ' || s[right] == ' ')) {
          if (s[left] == ' ') left++;
          if (s[right] == ' ') right--;
        }
        if (left == right) return s;
    
        int insertPos = 0;
        int lastChar = s.length() - 1;
    
        StringBuilder sb = new StringBuilder();
        for (int i = right; i >=left; i--) {
            if (s[i] != ' ') {
              sb.insert(insertPos, s.charAt(i));
              lastChar = i;
            } else if (s.charAt(i) == ' ' && lastChar - i == 1) {
                sb.insert(sb.length(), ' ');
                insertPos = sb.length();
            }  
        }
        return sb.toString();
    } 
     
}   