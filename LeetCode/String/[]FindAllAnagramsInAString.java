//  438 Find All Anagrams in a String 
 
 /**
* Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.
* 
* Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.
* 
* The order of output does not matter.
* 
* Example 1:
* 
* Input:
* s: "cbaebabacd" p: "abc"
* 
* Output:
* [0, 6]
* 
* Explanation:
* The substring with start index = 0 is "cba", which is an anagram of "abc".
* The substring with start index = 6 is "bac", which is an anagram of "abc".
* Example 2:
* 
* Input:
* s: "abab" p: "ab"
* 
* Output:
* [0, 1, 2]
* 
* Explanation:
* The substring with start index = 0 is "ab", which is an anagram of "ab".
* The substring with start index = 1 is "ba", which is an anagram of "ab".
* The substring with start index = 2 is "ab", which is an anagram of "ab".
*/

// hash1 = [1: string1, 2: string2]
// hash2 = [1: string1, 2: string2]


// hash1 == hash2 ???

// refer to minumum window Substring
//   do we have hash == hash ?
   
// * Input:
// * s: "c c a b b a b a c d" p: "abce"  
//               l 
//                 r
            
//             hash [ a: 0
//                   b: 0
//                   c: 0
//                   e: 1]
  
// r - l + 1 == p.length  
  
//   phash = [a: 1
//             b: 1
//             c: 1]
  
public List allAnagrams(String s, String p) {
  HashMap<Character, Integer> map = new HashMap<Character, Integer>();
  char[] pArray = p.toCharArray();
  for (char c: pArray) {
    if (!map.containsKey(c)) {
      map.put(c, 1);
    else {
      map.put(c, map.get(c) + 1);
    }
  }
  char[] sArray = s.toCharArray();
  int slength = sArray.length;
  int left = 0;
  int right= 0;
  ArrayList<Integer> result = new ArrayList<Integer>();
  while (right < slength) {
    char r = sArray[right];
    char l = sArray[left];
    if (map.containsKey(r)) {
      if (map.get(r) > 0) {
        map.put(r, map.get(r) - 1);
        if (right - left  + 1== p.length()) {
          result.add(left);
          map.put(l, map.get(l) + 1);
          left++;
        }
        right++;
      }
      else {
        while (l != r) {
          map.put(l, map.get(l)+1);
          left++;
          l = sArray[left];
        }
        left++;
        right++;
      }
    } else {
      while (l != r) {
        map.put(l.map(get(l) + 1);
        left++;
        l = sArray[left];
      }
      left++;
      right++;
    }
  }
  return result;
}

// from leetcode

public List<Integer> findAnagrams(String s, String p) {
    List<Integer> list = new ArrayList<>();
    if (s == null || s.length() == 0 || p == null || p.length() == 0) return list;
    int[] hash = new int[256]; //character hash
    //record each character in p to hash
    for (char c : p.toCharArray()) {
        hash[c]++;
    }
    //two points, initialize count to p's length
    int left = 0, right = 0, count = p.length();
    while (right < s.length()) {
        //move right everytime, if the character exists in p's hash, decrease the count
        //current hash value >= 1 means the character is existing in p
        if (hash[s.charAt(right++)]-- >= 1) count--; 
        
        //when the count is down to 0, means we found the right anagram
        //then add window's left to result list
        if (count == 0) list.add(left);
    
        //if we find the window's size equals to p, then we have to move left (narrow the window) to find the new match window
        //++ to reset the hash because we kicked out the left
        //only increase the count if the character is in p
        //the count >= 0 indicate it was original in the hash, cuz it won't go below 0
        if (right - left == p.length() && hash[s.charAt(left++)]++ >= 0) count++;
    }
    return list;
}