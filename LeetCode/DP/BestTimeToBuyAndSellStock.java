/*
Best Time to Buy and Sell Stock I
Say you have an array for which the ith element is the price of a given stock on day i.

If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.
*/

/*
双指针法
复杂度
时间 O(N) 空间 O(1)

思路
根据买卖股票的特性，我们必须先低价买，再高价卖，这个找最大收益的过程实际上是找到目前为之的最低价。在遍历价格数组时，根据这个动态更新的最低价和当前的价格可以算出当前卖股票最大能赚多少钱。

代码

*/

// v1
public class Solution {
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE, res = 0;
        for(int i = 0 ; i < prices.length; i++){
            if(prices[i]<min) min = prices[i];
            if((prices[i]-min)>res) res = prices[i] - min;
        }
        return res;
    }
}

// v2 from Zhe

public int maxProfit(int[] prices) {
  if (prices == null || prices.length == 0) return 0;
  int localMax = 0;
  int globalMax = 0;
  int minPirce = prices[0];
  for (int i = 1; i < prices.length; i++) {
    if (prices[i] < minPrice) {
      minPrice = prices[i];
    } else {
      localMax = prices[i] - minPrice;
      globalMax = Math.max(localMax, globalMax);
    }
  }
  return globalMax;
}