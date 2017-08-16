
/**
* Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, add spaces in s to construct a sentence where each word is a valid dictionary word. You may assume the dictionary does not contain duplicate words.
* 
* Return all such possible sentences.
* 
* For example, given
* s = "catsanddog",
* dict = ["cat", "cats", "and", "sand", "dog"].
* 
* A solution is ["cats and dog", "cat sand dog"].
*/

res[i]: length of i can be formed or not.

res[i] = res[i - j] & res[j] for any j;

public class WordBreakII {
  public List<String> wordBreak(String s, List<String> wordDict) {
    List<String> res = new ArrayList<>();
    Map<Integer, List<String>> memo = new HashMap<>();
    memo.put(0, new ArrayList<String>());
    memo.get(0).add("");
    
    for (i = 1; i <= s.length(); i++) {
        for (String str : wordDict) {
            int j = i - str.length();
            if (j>=0 && s.substring(j, i).equals(str) && memo.containsKey(j)) {
                if (!memo.containsKey(i)) {
                    memo.put(i, new ArrayList<String>());
                }
                memo.get(i).add(str);
            }
        }
    }
    
    if (!memo.containsKey(s.length())) {
        return res;
    }
    
    restore (res, s.length(), "", memo);
    return res;
  }
  
  private void restore(List<String> res, int length, String curStr, Map<Integer, List<String>> memo) {
    if (length == 0) {
        res.add(curStr);
        return;
    } 
    for (String str : memo.get(length)) {
        int j = length - str.length();
        if (j >= 0 && memo.containsKey(j)) {
            String tmp = str + (curStr.equals("") ? "" : " " + curStr);
            restore(res, j, tmp, memo);
        }
    }
  }
  
}