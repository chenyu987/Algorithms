Best Time to Buy and Sell Stock III
Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete at most two transactions.

Note: You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
双向动态规划
复杂度
时间 O(N) 空间 O(N)

思路
最简单的方法就是对每一个时间点，将其所有两边的数组都执行一次Best Time to Buy and Sell Stock I的解法，但这会带来O(N^2)的时间复杂度。实际上当计算prices[0]到prices[i]的最大收益时，我们已经计算过prices[0]到prices[i-1]的最大收益了，prices[0]到prices[i]的最大收益应该是当前卖出能获得的最大收益和prices[0]到prices[i-1]的最大收益中，二者较大的那个。我们可以利用这个之前计算的结果降低时间复杂度（不过代价是额外空间），所以需要把prices[0]到prices[i]的最大收益存在left[i]数组中。具体解法和I是一样的，也是维护一个前半段最小值。

分别得出以i点为分割点，左半段最大收益的数组left，和右半段最大收益的数组right后，我们就可以遍历一遍这两个数组，找出最大的left+right组合。实际上，该解法就是将I的解法双向各执行一遍并记录结果。

代码
public class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length == 0) return 0;
        int[] left = new int[prices.length];
        int[] right = new int[prices.length];
        int leftMin = prices[0];
        int rightMax = prices[prices.length-1];
        int sum = 0;
        //计算左半段最大收益
        for(int i = 1 ; i < prices.length; i++){
            leftMin = Math.min(prices[i], leftMin);
            left[i] = Math.max(prices[i] - leftMin, left[i-1]);
        }
        //计算右半段最大收益
        for(int i = prices.length - 2 ; i >= 0; i--){
            rightMax = Math.max(prices[i], rightMax);
            right[i] = Math.max(rightMax - prices[i], right[i+1]);
        }
        //找出两次交易最大收益组合
        for(int i = 0 ; i < prices.length; i++){
            if((left[i]+right[i])>sum) sum = left[i]+right[i];
        }
        return sum;
    }
}