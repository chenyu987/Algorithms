/*
Distinct Subsequences
Given a string S and a string T, count the number of distinct subsequences of T in S.

A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characterswithout disturbing the relative positions of the remaining characters. (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).

Here is an example: S = "rabbbit", T = "rabbit"

Return 3.

*/
qwer
dfg

ab b
a  b

public int distinctNum(String s, String t) {
  if (s == null || t == null) return 0;
  int lenS = s.length();
  int lenT = t.length();
  if (lenS < lenT) return 0;
  int[][] res = new int[lenS+1][lenT+1];
  for (int i = 0; i <= lenS; i++) {
    res[i][0] = 1;
  }
  for (int i = 1; i <= lenS; i++) {
    for (int j = 1; j <= lenT; j++) {
      if (s.charAt(i-1) != s.charAt(j-1)) {
        res[i][j] = res[i-1][j];
      } else {
        res[i][j] += res[i-1][j-1] + res[i-1][j];   
      }
    }
  }
  return res[lenS][lenT];
}
