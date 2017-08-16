Best Time to Buy and Sell Stock II
Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times). However, you may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
贪心法
复杂度
时间 O(N) 空间 O(1)

思路
既然能买卖任意次，那最大收益的方法就是尽可能多的低入高抛。只要明天比今天价格高，就应该今天买入明天再卖出。

代码
public class Solution {
    public int maxProfit(int[] prices) {
        int sum = 0;
        for(int i = 1; i < prices.length; i++){
            if(prices[i]>prices[i-1]) sum += prices[i] - prices[i-1];
        }
        return sum;
    }
}