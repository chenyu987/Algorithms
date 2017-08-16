// Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).

// For example,
// S = "ADOBECODEBANC"
// T = "ABC"
// Minimum window is "BANC".

// Time O(n)???
// Space O(1) ???

// old version, not recommended for using String repeatively in loop
public class Solution {
    public String minimumWindowSubstring(String S, String T) {
        HashMap<Character, Integer> sMap = new HashMap<Character, Integer>();
        HashMap<Character, Integer> tMap = new HashMap<Character, Integer>();
        int start = 0;
        int end = 1;
        int min = INT_MAX;
        String minString;
        while (end < S.length() + 1) {
            String string = S.substring(start, end);
            if (string.isValid(sMap, tMap)) {
                if (string.length() < min) {
                    min = string.length();
                    minString = string;
                }
                sMap.get(start)--;
                start += 1;
            }
            else {
                end += 1;
                char nextchar = S.charAt(end - 1)
                if (!sMap.containsKey(nextchar)) {
                    sMap.put(nextchar, 0);
                }
                sMap.get(nextchar)++;
                }
            }
        }
        return minString;
    }
    
    public boolean isValid(sMap, tMap) {
        for (char key: tMap.keySet()) {
            if (sMap.containsKey(key) && sMap.get(key) >= tMap.get(key)) continue;
            return false;
        }
        return true;
    }
}

// better version
public class Solution {
    public String minimumWindowSubstring(String S, String T) {
        HashMap<Character, Integer> sMap = new HashMap<Character, Integer>();
        HashMap<Character, Integer> tMap = new HashMap<Character, Integer>();
        int start = 0;
        int end = 1;
        // S = "A  D  O  B  E  C  O  D  E  B A  N  C"
              start
                  end
                  
        int min = INT_MAX;
        String minString;
        String string = S.substring(start, end);
        while (end < S.length() + 1) {
            if (string.isValid(sMap, tMap)) {
                if (string.length() < min) {
                    int minStart = start;
                    int minLen = end - minStart + 1;
                }
                sMap.get(start)--;
                start += 1;
            }
            else {
                end += 1;
                char nextchar = S.charAt(end - 1)
                if (!sMap.containsKey(nextchar)) {
                    sMap.put(nextchar, 0);
                }
                sMap.get(nextchar)++;
                }
            }
        }
        return S.substring(minStart, minLen+minStart);
    }

    public boolean isValid(HashMap<>sMap,HashMap<> tMap) {
        for (char key: tMap.keySet()) {
            if (sMap.containsKey(key) && sMap.get(key) >= tMap.get(key)) continue;
            return false;
        }
        return true;
    }
}
