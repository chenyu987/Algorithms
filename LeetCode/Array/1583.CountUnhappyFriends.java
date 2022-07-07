
/*
You are given a list of preferences for n friends, where n is always even.

For each person i, preferences[i] contains a list of friends sorted in the order of preference. In other words, a friend earlier in the list is more preferred than a friend later in the list. Friends in each list are denoted by integers from 0 to n-1.

All the friends are divided into pairs. The pairings are given in a list pairs, where pairs[i] = [xi, yi] denotes xi is paired with yi and yi is paired with xi.

However, this pairing may cause some of the friends to be unhappy. A friend x is unhappy if x is paired with y and there exists a friend u who is paired with v but:

x prefers u over y, and
u prefers x over v.
Return the number of unhappy friends.

 

Example 1:

Input: n = 4, preferences = [[1, 2, 3], [3, 2, 0], [3, 1, 0], [1, 2, 0]], pairs = [[0, 1], [2, 3]]
Output: 2
Explanation:
Friend 1 is unhappy because:
- 1 is paired with 0 but prefers 3 over 0, and
- 3 prefers 1 over 2.
Friend 3 is unhappy because:
- 3 is paired with 2 but prefers 1 over 2, and
- 1 prefers 3 over 0.
Friends 0 and 2 are happy.
Example 2:

Input: n = 2, preferences = [[1], [0]], pairs = [[1, 0]]
Output: 0
Explanation: Both friends 0 and 1 are happy.
Example 3:

Input: n = 4, preferences = [[1, 3, 2], [2, 3, 0], [1, 3, 0], [0, 2, 1]], pairs = [[1, 3], [0, 2]]
Output: 4
  
 */

class Solution {
    public int unhappyFriends(int n, int[][] preferences, int[][] pairs) {
        // Store each person's pairing at first. (quickly check in next step) 
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < pairs.length; i++) {
            map.put(pairs[i][0], pairs[i][1]);
            map.put(pairs[i][1], pairs[i][0]);
        }
        
        int unhappy = 0;
        // traverse from the first person
        for (int i = 0; i < n; i++) {
            
            // find x who this person paired with and what's this person's preference
            int pairedWith = map.get(i);
            int[] preferedList = preferences[i];
            
            // if we find x is this person's first choice, then we know this person is happy.
            if (preferedList[0] == pairedWith) {
                continue;
            } else {
                //if we find x is not this person's first choice, we should check the people who have a better priority than x.
                for (int j = 0; j < preferedList.length; j++) {
                    if (preferedList[j] == pairedWith) break;
                    
                    // find the better choice for x and who this better choice paired.
                    int betterChoice = preferedList[j];
                    int betterChoicePaired = map.get(betterChoice);
                    
                    // compare the priority between this better choice paired person and the person i.
                    int btcPairedIndex = 0;
                    int iIndex = 0;
                    for (int k = 0; k < preferences[betterChoice].length; k++) {
                        if (preferences[betterChoice][k] == betterChoicePaired) {
                            btcPairedIndex = k;
                        }
                        if (preferences[betterChoice][k] == i) {
                            iIndex = k;
                        }
                    }
                    
                    // if we find person i has high priority than this better choice paired, this person i is unhappy and continue with the next person.
                    if (iIndex < btcPairedIndex) {
                        unhappy += 1;
                        break;
                    }
                }
            }
            
        }
        return unhappy;
    }
}
