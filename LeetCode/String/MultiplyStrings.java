// Multiply Strings
// Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2.

// Note:

// The length of both num1 and num2 is < 110.
// Both num1 and num2 contains only digits 0-9.
// Both num1 and num2 does not contain any leading zero.
// You must not use any built-in BigInteger library or convert the inputs to integer directly.


public class Solution {
    public String multiplyString(String num1, String num2) {
        if (num1 == "0" || num2 == "0") return "0";
        String str1 = StringBuilder(num1).reverse().toString();
        String str2 = StringBuilder(num2).reverse().toString();
        int[] res = new int[str1.length() + str2.length()];
        for (int i = 0; i < str1.length(); i++) {
            for (int j = 0; j <str2.length(); j ++){
                res[i + j] += (str1.charAt(i) - '0') * (str2.charAt(j) - '0')
            }
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < res.length; i++) {
            int mod = res[i] % 10;
            int carry = res[i] / 10;
            // important
            if (i < res.length - 1) { 
                res[i + 1] += carry;
            }
            result.insert(0, mod);
        }
        // remove 0 in the front
        while (result.charAt(0) == '0') {
            result.deletecharAt(0);
        }
        return result.toString();
    }
}