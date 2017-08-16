**
* Given an array of strings, group anagrams together.
* 
* For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"], 
* Return:
* 
* [
*   ["ate", "eat","tea"],
*   ["nat","tan"],
*   ["bat"]
* ]
* Note: All inputs will be in lower-case.
*/


public List<List<String>> groupAnagrams(String[] strs) {
  List<List<String>> res = new ArrayList<List<String>>();
  if (strs == null || strs.length == 0) return res;
  Map<String, List<String>> map = new HashMap<String, List<String>>();
  
  for (int i = 0; i < strs.length; i++) {
    char[] sList = strs[i].toCharArray();
    Arrays.sort(sList);
    String sortedStr = new String(sList);
    if (!map.containsKey(sortedStr)) {
      map.put(sortedStr, new ArrayList<String>());
    }
    map.get(sortedStr).add(strs[i]);
  }
  
  for (String key : map.keySet()) {
    res.add(map.get(key));      
  }
  return res;
}
