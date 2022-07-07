/*
Given an encoded string, return its decoded string.

The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.

You may assume that the input string is always valid; there are no extra white spaces, square brackets are well-formed, etc. Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there will not be input like 3a or 2[4].

The test cases are generated so that the length of the output will never exceed 105.

 

Example 1:

Input: s = "3[a]2[bc]"
Output: "aaabcbc"
Example 2:

Input: s = "3[a2[c]]"
Output: "accaccacc"
Example 3:

Input: s = "2[abc]3[cd]ef"
Output: "abcabccdcdcdef"

*/

class Solution {
    public String decodeString(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i <= s.length() - 1; i++) {
            if (s.charAt(i) != ']') {
                stack.push(s.charAt(i));
            } else {
                StringBuilder sb = new StringBuilder("");
                while (stack.peek() != '[') {
                    sb.insert(0, stack.pop());
                }
                stack.pop();
                int total = 0;
                int k = 1;
                while(!stack.isEmpty() && Character.isDigit(stack.peek())) {
                    total += (stack.pop() - '0') * k;
                    k *= 10;
                }
                while (total > 0) {
                    for (int j = 0; j <= sb.length() - 1; j++) {
                        stack.push(sb.charAt(j));
                    }
                    total--;
                }
            }
        }
        char[] result = new char[stack.size()];
        for (int i = stack.size() - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }
        return String.valueOf(result);
    }
}
