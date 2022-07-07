
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



public class Solution {
    
    public List<String> res = new LinkedList<String>();
    
    public List<String> wordBreak(String s, Set<String> wordDict) {
        List<String> dp[] = new ArrayList[s.length()+1];
        dp[0] = new ArrayList<String>();
        for(int i = 0; i < s.length(); i++){
            // 只在单词的后一个字母开始寻找，否则跳过
            if(dp[i]==null) continue;
            // 看从当前字母开始能组成哪个在字典里的词
            for(String word : wordDict){
                int len = word.length();
                if(i + len > s.length()) continue;
                String sub = s.substring(i, i+len);
                if(word.equals(sub)){
                    if(dp[i + len] == null){
                        dp[i + len] = new ArrayList<String>();
                    }
                    dp[i + len].add(word);
                }
            }
        }
        // 如果数组末尾不存在单词，说明找不到分解方法
        if(dp[s.length()]!=null) backTrack(dp, s.length(), new ArrayList<String>());
        return res;
    }
    
    private void backTrack(List<String> dp[], int end, ArrayList<String> tmp){
        if(end <= 0){
            String path = tmp.get(tmp.size()-1);
            for(int i = tmp.size() - 2; i >= 0; i--){
                path += " " + tmp.get(i);
            }
            res.add(path);
            return;
        }
        for(String word : dp[end]){
            tmp.add(word);
            backTrack(dp, end - word.length(), tmp);
            tmp.remove(tmp.size()-1);
        }
    }
}
