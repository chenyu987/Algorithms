242 Valid Anagram

Valid Anagram
Given two strings s and t, write a function to determine if t is an anagram of s.

For example, s = "anagram", t = "nagaram", return true. s = "rat", t = "car", return false.

Note: You may assume the string contains only lowercase alphabets.

// Method 1: Sort
// Time: O(nlogn) O(n)

public boolean validAnagram(String s, String t) {
  char[] sArray = s.toCharArray();
  char[] tArray = t.toCharArray();
  Arrays.sort(sArray);
  Arrays.sort(tArray);
  return sArray.toString().equals(tArray.toString());
}

// Method 2: Hash
// Time: O(n)  Space:O(n)
public boolean validAnagram(String s, String t) {
  HashMap<Character, Integer> map = new HashMap<Character, Integer>();
  char[] sArray = s.toCharArray();
  char[] tArray = t.toCharArray();
  for (char c: sArray) {
    if (map.containsKey(c)) {
      map.put(c, map.get(c) + 1);
    } else {
      map.put(c, 1);
    }
  }
  for (char c: tArray) {
    if (map.containsKey(c)) {
      map.put(c, map.get(c) - 1);
    } else {
      return false
    }
  }
  for (char c: map.keySet()) {
    if (map.get(c) != 0) return false;
  }
  return true;
}
