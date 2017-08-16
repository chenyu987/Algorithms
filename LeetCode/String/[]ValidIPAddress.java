/*        
Write a function to check whether an input string is a valid IPv4 address or IPv6 address or neither.

IPv4 addresses are canonically represented in dot-decimal notation, which consists of four decimal numbers, each ranging from 0 to 255, separated by dots ("."), e.g.,172.16.254.1;

Besides, leading zeros in the IPv4 is invalid. For example, the address 172.16.254.01 is invalid.

IPv6 addresses are represented as eight groups of four hexadecimal digits, each group representing 16 bits. The groups are separated by colons (":"). For example, the address 2001:0db8:85a3:0000:0000:8a2e:0370:7334 is a valid one. Also, we could omit some leading zeros among four hexadecimal digits and some low-case characters in the address to upper-case ones, so 2001:db8:85a3:0:0:8A2E:0370:7334 is also a valid IPv6 address(Omit leading zeros and using upper cases).

However, we don't replace a consecutive group of zero value with a single empty group using two consecutive colons (::) to pursue simplicity. For example, 2001:0db8:85a3::8A2E:0370:7334 is an invalid IPv6 address.

Besides, extra leading zeros in the IPv6 is also invalid. For example, the address 02001:0db8:85a3:0000:0000:8a2e:0370:7334 is invalid.

Note: You may assume there is no extra space or special characters in the input string.

Example 1:
Input: "172.16.254.1"

Output: "IPv4"

Explanation: This is a valid IPv4 address, return "IPv4".
Example 2:
Input: "2001:0db8:85a3:0:0:8A2E:0370:7334"

Output: "IPv6"

Explanation: This is a valid IPv6 address, return "IPv6".
Example 3:
Input: "256.256.256.256"

Output: "Neither"

Explanation: This is neither a IPv4 address nor a IPv6 address.        
*/

public String validIPaddress(String IP) {
  if (IP == null || IS.isEmpty()) return "Neither";
  if (IP.contains(":")) {
    return (isV6(IP) ? "IPv6" : Neither);
  } else {
    return (isV4(IP) ? "IPv4" : Neither);
  }
}

private boolean isV6(String ip) {
  int dotCnt = 0;
  for (int i = 0; i < ip.length(); i++) {
    if (ip.charAt(i) == ':') {
      dotCnt++;
    }
  }
  if (dotCnt != 7) return false;
  String[] seg = ip.split(":");
  if (seg.length != 8) return false;
  for (String str : seg) {
    if (str.isEmpty()) return false;
    if (str.length() > 4) return false;
    for (int i = 0; i < str.length(); i++) {
      char c = str.charAt(i);
      if (!((c >= '0' && c <= '9') || (c >= 'a' && c <= 'f') || (c >= 'A' && c <= 'F'))) return false;
    }
  }
  return true;
}

private boolean isV4(String ip) {
  int dotCnt = 0;
  for (int i = 0; i < ip.length(); i++) {
    if (ip.charAt(i) == '.') {
      dotCnt++;
    }
  }
  if (dotCnt != 3) return false;
  String[] seg = ip.split("\\.");
  if (seg.length != 4) return false;
  for (String str : seg) {
    if (str.isEmpty()) return false;
    int val = Integer.parseInt(str);
    if ((val + "").equals(str) == false) return false;
    if (val > 255 || val < 0) return false;
    if (str.charAt(0) == '0' && (val != 0 || str.length != 1)) return false;
  }
  return true;       
}        
        