// Implement strStr().

// Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
// 暴力法
// 复杂度
// 时间 O(N^2) 空间 O(1)

public class Solution {
    public int strStr(String haystack, String needle) {
        int start = 0;
        for (int i = 0; i < haystack.length() - needle.length(); i++) {
            for (int j = 0; j < needle.length(); j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) break;
                if (j == needle.length() - 1) return i;
            }
        }
        return -1;
    }
}

// KMP
// Time O(M*N)