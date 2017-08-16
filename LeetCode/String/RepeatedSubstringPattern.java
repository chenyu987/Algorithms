/*

Given a non-empty string check if it can be constructed by taking a substring of it and appending multiple copies of the substring together. You may assume the given string consists of lowercase English letters only and its length will not exceed 10000.

Example 1:
Input: "abab"

Output: True

Explanation: It's the substring "ab" twice.
Example 2:
Input: "aba"

Output: False
Example 3:
Input: "abcabcabcabc"

Output: True

Explanation: It's the substring "abc" four times. (And the substring "abcabc" twice.)

*/

public boolean repeatedSubstringPattern(String str) {
	int l = str.length();
	for(int i=l/2;i>=1;i--) {
		if(l%i==0) {
			int m = l/i;
			String subS = str.substring(0,i);
			StringBuilder sb = new StringBuilder();
			for(int j=0;j<m;j++) {
				sb.append(subS);
			}
			if(sb.toString().equals(str)) return true;
		}
	}
	return false;
}

// wrote while meeting
public boolean repeatedSubstring(String s) {
  int[] sArray = s.toCharArray();
  for (int i = 2; i <= s.length; i++) {
    if (sArray.length % i != 0) continue;
    int len = sArray.length/i;
    for (int j = len; j < sArray.length - len; j+= len) {
      if (s.substring(j, j + len).equals(s.substring(j - len, j)) continue;
      else break;
    }
    return true;
  }
  return false;
}

// KMP 变形

             i 
"$ a b c a b c"
     j
[0 0 0 0 1 2 3]

next[n] != 0
&&
next[n] % (n - next[n]) == 0
 
public boolean repeatedSubString(String s) {
  int i = 1;
  int j = 0;
  int len = s.length();
  int[] next = new int[len+1];
  while (i < len) {
    if (s.charAt(i) == s.charAt(j)) {
      next[++i] = ++j;
    } else if (j == 0) {
      i++;
    } else {
      j = next[j];
    }
  }
  if (next[len] != 0 && (next[len] % (len - next[len])) == 0) {
    return true;
  } 
  return false;
}
 
 
 