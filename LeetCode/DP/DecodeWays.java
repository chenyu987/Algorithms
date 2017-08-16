/**
A message containing letters from A-Z is being encoded to numbers using the following mapping:

'A' -> 1
'B' -> 2
...
'Z' -> 26
Given an encoded message containing digits, determine the total number of ways to decode it.

For example,
Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).

The number of ways decoding "12" is 2.

*/

// Solution 1 from LeetCode Discussion

public class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        if (n == 0) return 0;
        
        int[] memo = new int[n+1];
        // 这个是初始化为动态转移方程服务的 不存在任何意义
        memo[n]  = 1;
        memo[n-1] = s.charAt(n-1) != '0' ? 1 : 0;
        
        for (int i = n - 2; i >= 0; i--)
            if (s.charAt(i) == '0') continue;
            else memo[i] = (Integer.parseInt(s.substring(i,i+2))<=26) ? memo[i+1]+memo[i+2] : memo[i+1];
        
        return memo[0];
    }
}

// Solution 2 from Zhe

// solution 1:
// 复杂度：
// 时间O(n) 空间O(n)
// res[i]表示前i个字符共有多少解码可能性
// 1.如果第i个字符(s.charAt(i-1))可以被解码 则res[i] = res[i-1]
// 2.如果第i-2和第i-1个字符可以被解码，则res[i] += res[i-1]
// 初始化：
// res[0] = 1
// res[1] = 1 or 0, 需要判断第一个字符是否在‘A’到‘Z'之间
// */

// LeetCode Solution
int[] -> all 0s
boolean -> all false
(i-2, i-1)
             1   3  3  0   6  4  3    2
res        1 1   2  2  0   2  
public class DecodeWays {
  public int numDecodings(String s) {
    if(s == null || s.length() == 0) return 0;
    int[] res = new int[s.length()+1];
    res[0] = 1;
    res[1] = isValid(s.substring(0,1)) ? 1 : 0;	
	for (int i = 2; i <= s.length(); i++) {
	  if (isValid(s.substring(i-1, i))) {
		res[i] += res[i-1];
	  }
	  if (isValid(s.substring(i-2, i))) {
		res[i] += res[i-2];
	  }
	}
	return res[s.length()];
  }
  private boolean isValid(String str) {
	if (str == null || str.length() == 0) return false;
	if (str.charAt(0) == '0') return false;
	int num = Integer.parseInt(str);
	return num >= 1 && num <= 26;
  }
} 


// Solution 3 from Segment fault
// 复杂度
// 时间 O(N) 空间 O(N)

// 思路
// 解码是有规律的，所以我们可以尝试动态规划。假设数组dp[i]表示从头到字符串的第i位，一共有多少种解码方法的话，那么如果字符串的第i-1位和第i位能组成一个10到26的数字，说明我们是在第i-2位的解码方法上继续解码。如果字符串的第i-1位和第i位不能组成有效二位数字，而且第i位不是0的话，说明我们是在第i-1位的解码方法上继续解码。所以，如果两个条件都符合，则dp[i]=dp[i-1]+dp[i-2]，否则dp[i]=dp[i-1]。

// 注意
// 如果出现无法被两位数接纳的0，则无法解码，我们可以在一开始就判断，并将其初始化为0，这样后面的相加永远都是加0

// 代码
public class Solution {
    public int numDecodings(String s) {
        if(s.length() == 0) return s.length();
        int[] dp = new int[s.length() + 1];
        // 初始化第一种解码方式
        dp[0] = 1;
        // 如果第一位是0，则无法解码
        dp[1] = s.charAt(0) == '0' ? 0 : 1;
        for(int i = 2; i <= s.length(); i++){
            // 如果字符串的第i-1位和第i位能组成一个10到26的数字，说明我们可以在第i-2位的解码方法上继续解码
            if(Integer.parseInt(s.substring(i-2, i)) <= 26 && Integer.parseInt(s.substring(i-2, i)) >= 10){
                dp[i] += dp[i - 2];
            }
            // 如果字符串的第i-1位和第i位不能组成有效二位数字，在第i-1位的解码方法上继续解码
            if(Integer.parseInt(s.substring(i-1, i)) != 0){
                dp[i] += dp[i - 1];
            }
        }
        return dp[s.length()];
    }
}

// Wrote when meeting
/**
* A message containing letters from A-Z is being encoded to numbers using the following mapping:
* 
* 'A' -> 1
* 'B' -> 2
* ...
* 'Z' -> 26
* Given an encoded message containing digits, determine the total number of ways to decode it.
* 
* For example,
* Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).
* 
* The number of ways decoding "12" is 2.
*/


12''

1-2''


32345

100
==>0

public int decodeWays(String s) {
  if (s == null || s.length() == 0) return 0;
  int len = s.length();
  int[] dp = new int[s.length + 1];
  dp[len] = 1;
  dp[len - 1] = s.charAt(len - 1) <= '0'? 0: 1;
  for (int i = len - 2; i >= 0; i--) {
    if (s.charAt(i) <= '0') continue;
    else if (Integer.parseInt(s.substring(i, i + 2) <= 26 && Integer.parseInt(s.substring(i, i + 2) >0) {
    dp[i] = dp[i + 1] + dp[i + 2]; 
    } else {
    dp[i] = dp[i + 1];
    }
  }
  return dp[0];
}
   