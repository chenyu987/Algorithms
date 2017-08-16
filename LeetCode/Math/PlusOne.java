
// Plus One
// Given a non-negative integer represented as a non-empty array of digits, plus one to the integer.
// You may assume the integer do not contain any leading zero, except the number 0 itself.
// The digits are stored such that the most significant digit is at the head of the list.

[1 , 2 , 3, 4] ==> [1 , 2 ,3 ,5]
[1 , 2 , 3 ,4]
            i

[1, 9 , 9 , 9] ==> [2, 0 , 0 , 0]
 

==> [1, 0, 0 ,0]
     i


[9, 9 ..... 9]

==>

[0,0, 0 , 0..0]
public int[] plusOne(int[] digits) {
  int i = digits.length - 1;
  while (i >= 0) {
    if (digits[i] != 9) {
      digits[i] += 1;
      return digits;
    } 
    else {
      digits[i] = 0;
    }
    i--;
  }
  if (i < 0) {
   int[] result = new int[digits.length + 1];
   result[0] = 1;
   return result;
  }
  else {
    digits[i] += 1;
    return digits;
  }
}

进位法：

public class Solution {
    public int[] plusOne(int[] digits) {
        int carry = 1;
        for (int i = digits.length-1; i >= 0; i--) {
            int cur = digits[i] + carry;
            carry = cur / 10;
            digits[i] = cur % 10;
            if (carry == 0) break;
        }
        if (carry == 1) {
            int[] res = new int[digits.length+1];
            res[0] = 1;
            return res;
        }
        return digits;
    }
}


public class Solution {
    public int[] plusOne(int[] digits) {
        int carry = 1;
        for (int i = digits.length-1; i >= 0; i--) {
            int sum = digits[i] + carry;
            carry = sum / 10;
            digits[i] = sum % 10;
            if (carry == 0) break;
        }
        if (carry == 1) {
            int[] res = new int[digits.length+1];
            res[0] = 1;
            return res;
        }
        return digits;
    }
}
