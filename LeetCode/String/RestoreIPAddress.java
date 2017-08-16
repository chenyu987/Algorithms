// Restore IP Address
// Given a string containing only digits, restore it by returning all possible valid IP address combinations.

// For example: Given "25525511135",

// return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)
// 四分法
// 复杂度
// 时间 O(N^2) 空间 O(1)

// 思路
// 用三个点将字符串分成四段，验证每一段是否是有效的。我们只要控制这三个分割点就行了，注意约束条件有两个，一个是一段字符串不超过3个字母，另一个是控制好每段字符串最远结束的位置，比如第一个字符串最多延伸到倒数第4个字母。

// 注意
// 使用Integer.valueOf()时要确保所得到数不会超界。

// 代码



public class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<String>();
        int len = s.length();
        for(int i = 1; i<4 && i<len-2; i++){
            for(int j = i+1; j<i+4 && j<len-1; j++){
                for(int k = j+1; k<j+4 && k<len; k++){
                    String s1 = s.substring(0,i), s2 = s.substring(i,j), s3 = s.substring(j,k), s4 = s.substring(k,len);
                    if(isValid(s1) && isValid(s2) && isValid(s3) && isValid(s4)){
                        res.add(s1+"."+s2+"."+s3+"."+s4);
                    }
                }
            }
        }
        return res;
    }
    public boolean isValid(String s){
        if(s.length()>3 || s.length()==0 || (s.charAt(0)=='0' && s.length()>1) || Integer.parseInt(s)>255)
            return false;
        return true;
    }
}


// From Zhe when meeting
// Given a string containing only digits, restore it by returning all possible valid IP address combinations.

// For example:
// Given "25525511135",

// return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)


1   200 13   4
___.___.___.___
0-255 


public List<String> restoreIP(String s) {
  List<Stirng> res = new ArrayList<>();
  if (s == null || s.length() == 0) return res;
  helper(res, s, "", 4);
  resturn res;
}

private helper(List<String> res, String s, String tmp, int part) {
  if (s == null || s.length() > part * 3 || s.length() < part) {
    return;
  }
  if (s.length() == 0 && part == 0) {
    res.add(tmp);
    return;
  }
  
  for (int i = 1; i <= 3 && i <= s.length(); i++) {
    String curStr = s.substring(0, i);
    String resStr = s.substring(i);
    if (isValid(curStr)) {
      String sb = new StringBuilder(tmp);
      sb.append(curStr);
      if (part > 1) {
        sb.append('.');
      }
    }
    helper(res, resStr, sb.toString(), part-1);
  }
}

private boolean isValid(String str) {
  if (str.charAt(0) == '0') {
    return str.equals("0");
  } else {
    int tmp = Integer.parseInt(str);
    return (tmp > 0 && tmp <= 255);
  }
}