/*
The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR" Write the code that will take a string and make this conversion given a number of rows:

string convert(string text, int nRows);

convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
*/
    ptr
s = p   a   y   p    a   l i  s  h   i  r  i  n  g 

p         i             n
 
a      l  s          i  g

y   a     h      r   
 
p         i     

sb[0]: line 16
sb[1]:line 18
sb[2]: line 22


Solutiion 1: 

public String convert(String s, int numRows) {
  if (s == null || s.length() == 0) return "";
  char[] sList = s.toCharArray();
  int len = s.length();
  StringBuilder[] sb = new StringBuilder[numRows];
  
  for (int = 0; i < numRows; i++) {
    sb[i] = new StringBuilder();
  }
  
  int ptr = 0;
  while (ptr < len) {
    for (int idx = 0; idx < numRows && ptr < len; idx++) {
      sb[idx].append(sList[ptr]);
      ptr++;
    }
    for (int idx = numRows - 2; idx >= 1 && ptr < len; idx--) {
      sb[idx].append(sList[ptr]);
      ptr++;
    }
  }
  
  for (int idx = 1; idx < sb.length; idx++) {
    sb[0].append(sb[idx]);
  }
  return sb[0].toString();
}

Solution 2:
https://kevinclcn.gitbooks.io/leetcodejava/content/006_zigzag_conversion.html
