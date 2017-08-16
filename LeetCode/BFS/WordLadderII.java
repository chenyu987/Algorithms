
// Given two words (start and end), and a dictionary, find all shortest transformation sequence(s) from start to end, such that:

// Only one letter can be changed at a time
// Each intermediate word must exist in the dictionary
// For example,

// Given:

// start = "hit"

// end = "cog"

// dict = ["hot","dot","dog","lot","log"]

// Return

//   [
//     ["hit","hot","dot","dog","cog"],
//     ["hit","hot","lot","log","cog"]
//   ]


public class Solution {
    private HashMap<String, Integer> map;
    private void dfs(String word, String end, List<String> sequence, List<List<String>> res){
        if(map.get(word) == map.get(end) && !end.equals(word)) return;
        else if(end.equals(word)){
            List<String> list = new LinkedList<String>(sequence);
            list.add(word);
            Collections.reverse(list);
            res.add(list);
            return;
        }
         
        sequence.add(word);
        for(int i=0; i<word.length(); i++){
            char[] wordArray = word.toCharArray();
            for(char ch = 'a'; ch <= 'z'; ch++){
                if(wordArray[i] == ch) continue;
                wordArray[i] = ch;
                String tmp = new String(wordArray);
                if(map.containsKey(tmp) && map.get(tmp) == (map.get(word) - 1))
                    dfs(tmp, end, sequence, res);
            }
        }
        sequence.remove(word);
    }
    public List<List<String>> findLadders(String start, String end, Set<String> dict) {
        List<List<String>> res = new ArrayList<List<String>>();
        LinkedList<String> queue = new LinkedList<String>();
        map = new HashMap<String, Integer>();
        queue.add(start);
        map.put(start, 1);
        if(start.equals(end)){
            res.add(queue);
            return res;
        }
        while(!queue.isEmpty()){
            String word = queue.poll();
            for(int i=0; i<word.length(); i++){
                char[] wordArray = word.toCharArray();
                for(char j='a'; j<='z'; j++){
                    if(wordArray[i] == j)
                        continue;
                    wordArray[i] = j;
                    String tmp = new String(wordArray);
                    if(tmp.endsWith(end)){
                        map.put(tmp, map.get(word)+1);
                        i = word.length();
                        queue.clear();
                        break;
                    }
                    if(dict.contains(tmp) && !map.containsKey(tmp)){
                        map.put(tmp, map.get(word) + 1);
                        queue.add(tmp);
                    }
                }
            }
        }
        if(map.containsKey(end))
            dfs(end, start, new LinkedList<String>(), res);
        return res;
    }
}

// from SegmentFault
分析
如果要返回所有的结果，问题变复杂了些。因为用BFS相对于DFS的劣势就是不方便存储结果。这种需要返回所有结果的，还是应该从DFS考虑，但是直接应用DFS复杂度会很高，因为这道题我们只要知道结尾就好了，不用继续往下搜。

所以问题就转化成怎样用DFS的同时又可以限制DFS的深度，所以我们可以BFS与DFS结合。先用BFS搜到结尾字符串，然后把中途所有的字符串及其跟起始字符的edit distance存在一个map里。这样的话，我们就可以从结尾字符串开始DFS，只有Map内的字符串才考虑继续DFS，直至搜到起始字符。

注意这里有个小技巧，就是为什么不从起始字符串开始DFS直至搜到结尾字符串，而是反过来。这里可以脑子里想像一个图，如果从起始字符串开始搜，到最后一层的话会有很多无效搜索，因为那层我们只需要找到结尾字符串，那么多无效的搜索到最一层太浪费时间。反之，如果我们从结尾字符串开始DFS, 我们把起始层控制在一个字符串，整个图先越来越宽，然后越来越窄直到起始字符串，而非一直越来越宽直到结尾字符串那层。

public class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, Set<String> wordList) {
        Map<String, Integer> distMap = new HashMap<String, Integer>(); 
        getDistance(beginWord, endWord, wordList, distMap);
        List<List<String>> res = new ArrayList<List<String>>();
        dfs(res, new ArrayList<String>(), distMap, wordList, endWord, beginWord);
        return res;
    }
    
    public void dfs(List<List<String>> res, List<String> cur, Map<String, Integer> distMap, Set<String> wordList, String word, String des) {
        if (word.equals(des)) {
            List<String> list = new ArrayList<String>(cur);
            list.add(des);
            Collections.reverse(list);
            res.add(list);
            return;
        }
        
        cur.add(word);
        for (int i = 0; i < word.length(); i++) {
            char[] chars = word.toCharArray();
            for (char c = 'a'; c <= 'z'; c++) {
                chars[i] = c;
                String nextWord = new String(chars);

                // 不仅字典中含有，两字符串也是要在路径的相邻位置即距离差1
                if (distMap.containsKey(nextWord) && distMap.get(nextWord) == distMap.get(word) - 1) {
                    dfs(res, cur, distMap, wordList, nextWord, des);
                }
            }
        }
        cur.remove(cur.size() - 1);
    }
    
    // 用Word Ladder I的方法把候选字符串及其距离存入map，缩小DFS范围。
    public void getDistance(String beginWord, String endWord, Set<String> wordList, Map<String, Integer> distMap) {
        distMap.put(beginWord, 1);
        Queue<String> q = new LinkedList<String>();
        q.add(beginWord);
        
        while (!q.isEmpty()) {
            String word = q.remove();
            for (int j = 0; j < word.length(); j++) {
                char[] chars = word.toCharArray();
                for (char c = 'a';  c <= 'z'; c++) {
                    chars[j] = c;
                    String nextWord = new String(chars);
                    if (nextWord.equals(endWord)) {
                        distMap.put(nextWord, distMap.get(word) + 1);
                        return;
                    }
                    if (wordList.contains(nextWord) && !distMap.containsKey(nextWord)) {
                        distMap.put(nextWord, distMap.get(word) + 1);
                        q.add(nextWord);
                    }
                }
            }
        }
    }
}