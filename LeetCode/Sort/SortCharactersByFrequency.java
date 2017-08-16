/*
Given a string, sort it in decreasing order based on the frequency of characters.

Example 1:

Input:
"tree"

Output:
"eert"

Explanation:
'e' appears twice while 'r' and 't' both appear once.
So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
Example 2:

Input:
"cccaaa"

Output:
"cccaaa"

Explanation:
Both 'c' and 'a' appear three times, so "aaaccc" is also a valid answer.
Note that "cacaca" is incorrect, as the same characters must be together.
Example 3:

Input:
"Aabb"

Output:
"bbAa"

Explanation:
"bbaA" is also a valid answer, but "Aabb" is incorrect.
Note that 'A' and 'a' are treated as two different characters.

*/



// From Meeting


public String sortCharacters(String s) {
  HashMap<Character, Integer> map = new HashMap<Character, Integer>();
  char[] sArray = s.toCharArray();
  int max = 0;
  for (char c: sArray) {
    if (!map.containsKey) {
      map.put(c, 1);
    } else {
      map.put(c, map.get(c) + 1);
    }
    max = Math.max(max, map.get(c));
  }
  StringBuilder result = new StringBuilder();
  for (int i = max; i >= 1; i--) {
    for (Character c: map.keySet()) {
      if (map.get(c) == i) {
        for (int j= 0; j < i; j++) {
          result.append(c);
        }
      }
    }
  }
  return result.toString();
}

// bucket sort
public String sortCharacters(String s) {
  HashMap<Character, Integer> map = new HashMap<Character, Integer>();
  char[] sArray = s.toCharArray();
  int max = 0;
  for (char c: sArray) {
    if (!map.containsKey) {
      map.put(c, 1);
    } else {
      map.put(c, map.get(c) + 1);
    }
    max = Math.max(max, map.get(c));
  }
  
  List<Character>[] bukit = new List[max+1];
  for (char c : map.keySet()) {
    int curFreq = map.get(c);
    if (bukit[curFreq] == null) {
      bukit[curFreq] = new ArrayList<Character>();
    }
    bukit[curFreq].add(c);
  }

  StringBuilder sb = new StringBuilder();
  for (int freq = bukit.length - 1; freq > 0; freq--) {
    if (bukit[freq] == null) continue;
    for (char c : bukit[freq]) {
      for (int j = 0; j < freq; j++) {
        sb.append(c);      
      }
    }
  }
  return sb.toString();
}


// Use Priority Queue
public class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>(
            new Comparator<Map.Entry<Character, Integer>>() {
                @Override
                public int compare(Map.Entry<Character, Integer> a, Map.Entry<Character, Integer> b) {
                    return b.getValue() - a.getValue();
                }
            }
        );
        pq.addAll(map.entrySet());
        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            Map.Entry e = pq.poll();
            for (int i = 0; i < (int)e.getValue(); i++) {
                sb.append(e.getKey());
            }
        }
        return sb.toString();
    }
}

// From Leetcode

public String frequencySort(String s) {
    if (s == null) {
        return null;
    }
    Map<Character, Integer> map = new HashMap();
    char[] charArray = s.toCharArray();
    int max = 0;
    for (Character c : charArray) {
        if (!map.containsKey(c)) {
            map.put(c, 0);
        }
        map.put(c, map.get(c) + 1);
        max = Math.max(max, map.get(c));
    }

    List<Character>[] array = buildArray(map, max);

    return buildString(array);
}

private List<Character>[] buildArray(Map<Character, Integer> map, int maxCount) {
    List<Character>[] array = new List[maxCount + 1];
    for (Character c : map.keySet()) {
        int count = map.get(c);
        if (array[count] == null) {
            array[count] = new ArrayList();
        }
        array[count].add(c);
    }
    return array;
}

private String buildString(List<Character>[] array) {
    StringBuilder sb = new StringBuilder();
    for (int i = array.length - 1; i > 0; i--) {
        List<Character> list = array[i];
        if (list != null) {
            for (Character c : list) {
                for (int j = 0; j < i; j++) {
                    sb.append(c);
                }
            }
        }
    }
    return sb.toString();
}