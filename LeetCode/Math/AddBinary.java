// Add Binary
/*
Given two binary strings, return their sum (also a binary string).

For example,
a = "11"
b = "1"
Return "100".
*/


public String addBinary(String a, String b) {
  if (a.length() < b.length())
    String tmp = a;
    a = b;
    b = tmp;
  }
  int alength = a.length();
  int blength = b.length();
  int carry = 0;
  StringBuilder result = new StringBuilder();
  while (blength > 0) {
    int sum = (int)(a.charAt(alength) - '0') + (int)(b.charAt(blength - '0') + carry;
    carry = sum / 2;
    alength--;
    blength--;
    result.insert(0, String.valueOf(sum % 2));
  }
  while (alength > 0) {
    int sum = (int)(a.charAt(alength) - '0') + carry;
    carry = sum / 2;
    alength --;
    result.insert(0, String.valueOf(sum % 2));
  }
  if (carry == 1) {
    result.insert(0, '1');
  }
  return result.toString();
  
}