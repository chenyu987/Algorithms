// Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, determine if s can be segmented into a space-separated sequence of one or more dictionary words. You may assume the dictionary does not contain duplicate words.

// For example, given
// s = "leetcode",
// dict = ["leet", "code"].

// Return true because "leetcode" can be segmented as "leet code".


public class Solution {
    public boolean wordBreak(String s, HashSet<String> dict) {
        boolean[] dp = new boolean dp[s.length() + 1];
        // do we have better way?
        Array.fill(dp, false);
        dp[s.length()] = true;
        for (int i = s.length() - 1; i >= 0; i-- ) {
            for (int j = i; j < s.length(); j++) {
                String substring = s.substring(i, j + 1);
                if (wordDict.contains(substring) && dp[j + 1]) {
                    dp[i] = true;
                    // Q:What does this break do?
                    break;
                }
            }
        }
        return dp[0];
    }
}