
347
Top K Frequent Elements

Given a non-empty array of integers, return the k most frequent elements.

For example,
Given [1,1,1,2,2,3] and k = 2, return [1,2].
Note: 
You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
Your algorithm's time complexity must be better than O(n log n), where n is the array's size.


public List<Integer> topKFrequentElments(int[] nums, int k) {
  HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
  int max = Integer.MIN_VALUE;
  for (int i: nums) {
    if (map.containsKey(i)) {
      map.put(i, map.get(i) + 1);
    } else {
      map.put(i, 1);
    }
    max = Math.max(max, map.get(i));
  }
  List<Integer>[] bucket = new List[max + 1];
  for (int j: map.keySet()) {
    int curFreq = map.get(j);
    if (bucket[curFreq] == null) {
      bucket[curFreq] = new ArrayList<Integer>();
    }
    bucket[curFreq].add(j);
  }
  List<Integer> result = new ArrayList<Integer>();
  for (int i = max; i > 0; i--) {
    if (bucket[i] == null) continue;
    for (int a: bucket[i]) {
      result.add(a);
      if (result.size() == k) break;
    }
  }
  return result;
}
 