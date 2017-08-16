
// concatenation
// n. 串联，连结

// From Segment Fault
// Substring with Concatenation of All Words
// You are given a string, s, and a list of words, words, that are all of the same length. Find all starting indices of substring(s) in s that is a concatenation of each word in words exactly once and without any intervening characters.

// For example, given: s: "barfoothefoobarman" words: ["foo", "bar"]

// You should return the indices: [0,9].

// (order does not matter).
// 哈希表计数法
// 复杂度
// 时间 O(NK) 空间 O(M)

// 思路
// 由于数组中所有单词的长度都是一样的，我们可以像Longest Substring with At Most Two Distinct Characters中一样，把每个词当作一个字母来看待，但是要遍历K次，K是单词的长度，因为我们要分别统计从下标0开头，从下标1开头。。。直到下标K-1开头的字符串。举例来说foobarfoo，给定数组是[foo, bar]，那我们要对foo|bar|foo搜索一次，对oob|arf|oo搜索一次，对oba|rfo|o搜索一次，我们不用再对bar|foo搜索，因为其已经包含在第一种里面了。每次搜索中，我们通过哈希表维护一个窗口，比如foo|bar|foo中，我们先拿出foo。如果foo都不在数组中，那说明根本不能拼进去，则哈希表全部清零，从下一个词开始重新匹配。但是foo是在数组中的，所以给当前搜索的哈希表计数器加上1，如果发现当前搜索中foo出现的次数已经比给定数组中foo出现的次数多了，我们就要把上一次出现foo之前的所有词都从窗口中去掉，如果没有更多，则看下一个词bar，不过在这之前，我们还要看看窗口中有多少个词了，如果词的个数等于数组中词的个数，说明我们找到了一个结果。

// 注意
// 先判断输入是否为空，为空直接返回空结果
// 代码

public class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new LinkedList<Integer>();
        if(words == null || words.length == 0 || s == null || s.equals("")) return res;
        HashMap<String, Integer> freq = new HashMap<String, Integer>();
        // 统计数组中每个词出现的次数，放入哈希表中待用
        for(String word : words){
            freq.put(word, freq.containsKey(word) ? freq.get(word) + 1 : 1);
        }
        // 得到每个词的长度
        int len = words[0].length();
        // 错开位来统计
        for(int i = 0; i < len; i++){
            // 建一个新的哈希表，记录本轮搜索中窗口内单词出现次数
            HashMap<String, Integer> currFreq = new HashMap<String, Integer>();
            // start是窗口的开始，count表明窗口内有多少词
            int start = i, count = 0;
            for(int j = i; j <= s.length() - len; j += len){
                String sub = s.substring(j, j + len);
                // 看下一个词是否是给定数组中的
                if(freq.containsKey(sub)){
                    // 窗口中单词出现次数加1
                    currFreq.put(sub, currFreq.containsKey(sub) ? currFreq.get(sub) + 1 : 1);
                    count++;
                    // 如果该单词出现次数已经超过给定数组中的次数了，说明多来了一个该单词，所以要把窗口中该单词上次出现的位置及之前所有单词给去掉
                    while(currFreq.get(sub) > freq.get(sub)){
                        String leftMost = s.substring(start, start + len);
                        currFreq.put(leftMost, currFreq.get(leftMost) - 1);
                        start = start + len;
                        count--;
                    }
                    // 如果窗口内单词数和总单词数一样，则找到结果
                    if(count == words.length){
                        String leftMost = s.substring(start, start + len);
                        currFreq.put(leftMost, currFreq.get(leftMost) - 1);
                        res.add(start);
                        start = start + len;
                        count--;
                    }
                // 如果截出来的单词都不在数组中，前功尽弃，重新开始
                } else {
                    currFreq.clear();
                    start = j + len;
                    count = 0;
                }
            }
        }
        return res;
    }
}



// From LiuZhe
/**
* You are given a string, s, and a list of words, words, that are all of the same length. Find all starting indices of substring(s) in s that is a concatenation of each word in words exactly once and without any intervening characters.
* 
* For example, given:
* s: "barfoodbarthefoobarman"
* words: ["foo", "bar"]
* 
* You should return the indices: [0,9].
* (order does not matter).
*/

/*
复杂度
时间：O(n) 空间O(n)
思路：双指针(滑动窗口)
维护一个窗口 窗口里面是字典里出现的词 同max length of substring套路一样 只不过这里是去匹配一个字符串
*/

public class SubstringWithConcatenationOfAllWords {
  public List<Integer> findSubstring(String s, String[] words) {
    List<Integer> res = new ArrayList<Integer>();
		if (s == null || s.length() == 0 || words == null || words.length == 0) return res;
		Map<String, Integer> map = new HashMap<String, Integer>();
		for (int i = 0; i < words.length; i++) {
			if (map.containsKey(words[i]) {
				map.put(words[i], map.get(words[i])+1);
			} else {
				map.put(words[i], 1);
			}
		}
		int wordLen = words[0].length();
		for (int i = 0; i < wordLen; i++) {
			Map<String, Integer> curMap = new HashMap<String, Integer>();
			int cnt = 0; //窗口中的单词数
			int left = i; //窗口左指针
			for (int j = i; j <= s.length() - wordLen; j += wordLen) {
				String str = s.substring(j, j+wordLen);
				if (map.containKey(str)) {
					if (curMap.containsKey(str)) {
						curMap.put(str, curMap.get(str)+1);
					} else {
						curMap.put(str, 1);
					}
					cnt++; //增加窗口内单词数
					while (curMap.get(str) > map.get(str)) {
						String tmp = s.substring(left, left+wordLen);
						curMap.put(tmp, curMap.get(tmp)-1);
						left += wordLen;
						cnt--;
					}
					if (cnt == words.length) {
						res.add(left);
						String tmp = s.substring(left, left+wordLen);
						curMap.put(tmp, curMap.get(tmp)-1);
						left += wordLen;
						cnt--;
					}
				} else { // search miss 
					cnt = 0;
					curMap.clear();
					left = j + wordLen;
				}
			}
		}
		return res;
  }
}