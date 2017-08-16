// One Edit Distance
// Given two strings S and T, determine if they are both one edit distance apart.



// Solution One
// Divide the problem into three scenarios

public class Solution {
    public boolean oneEditDistance(String s, String t) {
        if (s == null || t == null) return false;
        if (t.length() > s.length()) {
            String tmp = t;
            t = s;
            s = tmp;
        }
        if (t.length() - s.length() > 1) {
            return false;
        }
        if (t.length() == s.length) {
            for (int i = 0; i < t.length; i++) {
                if (t.charAt(i) != s.charAt(i)) {
                    // Question, what is simple substring from i+1 to end wrote:yes
                    // return t.substring(i + 1, t.length() - 1) == s.substring(i + 1, s.length() - 1);
                    return t.substring(i + 1) == s.substring(i + 1);
                }    
            }
        }
        if (t.length() - s.length() == 1) {
            for (int i = 0; i < t.length(); i++) {
                if(t.charAt(i) != s.charAt(i)) {
                    return t.substring(i + 1) == s.substring(i);
                }
            }
        }
        // return false , which is important . this is the circumstance that exactly the same;
        return false; 
    }
}

// Question: ++count comparing to count++