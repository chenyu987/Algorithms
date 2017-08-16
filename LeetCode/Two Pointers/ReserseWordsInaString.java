// Given an input string, reverse the string word by word.

// For example,
// Given s = "the sky is blue",
// return "blue is sky the".


// Solution One:
// Time: O(n)
// Space: O(n)

public class Solution {
    public String reverse(String s) {
        String[] words = s.trim().split(" +");
        StringBuilder result = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            result.append(words);
            if (i != 0) result.append(" ");
        }
        return result.toString();
    }
}

// Solution Two:
// When the input is char[], we can decrease the space complexity to 0(1)
// Time: O(n)
// Space: O(1)

public class Solution {
    public void reverse(char[] s) {
        reserseWords(s, 0, s.length - 1);
        int start = 0;
        for (int i = 0; i < s.length - 1; i++) {
            if (s[i] == ' ') {
                reserseWords(s, start, i - 1);
                start = i + 1;
            }
        }
    }
    public void reserseWords(char[] s, int start, int end) {
        while (start < end) {
            char tmp = s[start];
            s[start] = s[end];
            s[end] = tmp;
            start++;
            end--;
        }
    }
}

// Question: it doesn't have public char[] reverse(char[] s) ?