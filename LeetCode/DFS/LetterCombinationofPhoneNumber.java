public class Solution {
    private String[] Keys = ["", "" , "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"];
    
    public List<String> letterCombination (String digits) {
        List<String> result = new LinkedList<String>();
        if (digits == null || digits.length() == 0) return result;
        StringBuilder tmp = new StringBuilder();
        dfs(tmp, 0, digits, result);
        return result;
        
    private void dfs(StringBuilder tmp, int offset, String digits, List<String> result) {
        if (offset >= digits.length()) {
            result.add(tmp);
            return;
        }
                                                        
        String s = Keys[digits.charAt(offset) - '0'];
        for (int i = 0; i < s.length(); i++) {
            tmp.append(s.charAt(i));
            dfs(tmp, offset + 1, digits, result);
            tmp.deleteCharAt(tmp.length() - 1);
        }
    }
}

// exercise
public List<String> letterCombo(String digits) {
    String[] keys = ;
    List<String> result = new LinkedList<String>();
    if (digits == null || digits.length == 0) {
        return result;
    }
    dfs(digits, 0, new StringBuilder(), result);
    return result;
} 

private void dfs(String digits, Integer offset, StringBuilder tmp, List<String> result) {
    if (offset == digits.length()) {
        result.add(tmp);
        return;
    }
    String s = Keys[digits.charAt(offset) - '0'];
    for (int i = 0; i < s.length(); i++) {
        tmp.append(s.charAt(i));
        dfs(digits, offset + 1, tmp, result);
        tmp.deleteCharAt(tmp.length() - 1);
    }
}