/*
You are given a string s and an integer k, a k duplicate removal consists of choosing k adjacent and equal letters from s and removing them, causing the left and the right side of the deleted substring to concatenate together.

We repeatedly make k duplicate removals on s until we no longer can.

Return the final string after all such duplicate removals have been made. It is guaranteed that the answer is unique.

 

Example 1:

Input: s = "abcd", k = 2
Output: "abcd"
Explanation: There's nothing to delete.
Example 2:

Input: s = "deeedbbcccbdaa", k = 3
Output: "aa"
Explanation: 
First delete "eee" and "ccc", get "ddbbbdaa"
Then delete "bbb", get "dddaa"
Finally delete "ddd", get "aa"
Example 3:

Input: s = "pbbcggttciiippooaais", k = 2
Output: "ps"

*/

// class Solution {

//     class Pair {
//         int freq;
//         char char;
//         public Pair(int freq, Character char) {
//             this.freq = freq;
//             this.char = char;
//         }
//     }
    
//     public String removeDuplicates(String s, int k) {
//         Stack<Pair> stack = new Stack<Pair>();
//         for (int i = 0; i < s.length(); i++) {
//             char c = s.chartAt(i);
//             if (stack.isEmpty() || stack.peek().char != c) {
//                 stack.push(new Pair(1, c));
//             } else {
//                 Pair cur = stack.pop();
//                 if (cur.freq + 1 == k) {
//                     continue;
//                 } else {
//                     cur.freq += 1;
//                     stack.push(cur);
//                 }
//             }
//         }
//         StringBuilder result = new StringBuilder();
//         while (!stack.isEmpty()) {
//             Pair p = stack.pop();
//             for (int i = 0; i < p.freq; i++) {
//                 result.append(p.char);
//             }
//         }
//         return result.reverse().toString();
//     }
        
// }

class Solution {

    class Pair {
        int freq;
        char ch;
        public Pair(int freq, Character ch) {
            this.freq = freq;
            this.ch = ch;
        }
    }
    
    public String removeDuplicates(String s, int k) {
        Stack<Pair> stack = new Stack<Pair>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (stack.isEmpty() || stack.peek().ch != c) {
                stack.push(new Pair(1, c));
            } else {
                Pair cur = stack.pop();
                if (cur.freq + 1 == k) {
                    continue;
                } else {
                    cur.freq += 1;
                    stack.push(cur);
                }
            }
        }
        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            Pair p = stack.pop();
            for (int i = 0; i < p.freq; i++) {
                result.append(p.ch);
            }
        }
        return result.reverse().toString();
    }
        
}
