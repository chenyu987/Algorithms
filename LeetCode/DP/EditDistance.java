/*
edit distance
Given two words word1 and word2, find the minimum number of steps required to convert word1 to word2. (each operation is counted as 1 step.)

You have the following 3 operations permitted on a word:

a) Insert a character
b) Delete a character
c) Replace a character

*/




public int minDis(String s1, String s2) {
  if (s1.length() == 0) return s2.length();
  if (s1.length() == 0) return s1.length();
  int len1 = s1.length();
  int len2 = s2.length();
  // res[i][j]: s1[0, i-1] -> s2[0, j-1] 
  int[][] res = new int[len1+1][len2+1];
  
  for (int i = 1; i <= len1; i++) {
    res[i][0] = i;
  }
  for (int i = 1; i <= len2; i++) {
    res[0][i] = i;
  }
  
  for (int i = 1; i<= len1; i++) {
    for (int j = 1; j <= len2; j++) {
      int ist = res[i][j-1] + 1;
      int del = res[i-1][j] + 1;
      int rep = 0;
      if (s1.charAt(i) == s2.charAt(j)) {
        rep = res[i-1][j-1];
      } else {
        rep = res[i-1][j-1] + 1;
      }
      res[i][j] = Math.min(rep, Math.min(ist, del));
    }
  }
  return res[len1][len2];
}