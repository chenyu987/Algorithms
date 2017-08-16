Gas Station
There are N gas stations along a circular route, where the amount of gas at station i is gas[i].

You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its next station (i+1). You begin the journey with an empty tank at one of the gas stations.

Return the starting gas station's index if you can travel around the circuit once, otherwise return -1.
贪心法
复杂度
时间 O(N) 空间 O(K)

思路
我们把将gas中每个值都减去cost中对应的值，这样gas就成为了开出该加油站到下一个加油站时，该加油站加的油用剩到多少。这样我们用一个tank变量记录汽车每开到一个加油站后油箱里累计剩下多少油，每到一个加油站就更新。这样我们开始遍历gas数组，如果tank是负数，说明开出该加油站后无法到达下一个加油站，这样旅程的起点更新为下一个加油站。因为旅程是环状的我们遍历的加油站数组应为2*gas.length-1，这样能保证我们以最后一个加油站为起点时也能继续验证。

代码



public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        // gas减去cost，得到净油值
        for(int i = 0; i < cost.length; i++){
            gas[i] -= cost[i];
        }
        int tank = 0, res = -1;
        for(int i = 0; i < gas.length * 2 - 1; i++){
            int idx = i % gas.length;
            // 更新油箱
            tank += gas[idx];
            // 如果油箱为负，说明走不到下一个加油站
            if(tank < 0){
                res = idx + 1;
                tank = 0;
            }
        }
        // 如果起点在最后一个加油站之后，说明无解
        return res >= gas.length ? -1 : res;
    }
}

// from Zhe meeting
     left        right
idx:  0     1      2       
gas:  3     2    10000    
cost: 1    300     2

public int canTravel(int[] gas, int[] cost) {
  if (gas == null || gas.length == 0) return 0;
  int start = 0;
  int sum = 0;
  int total = 0;
  for (int i = 0; i < gas.length; i++) {
    int residual = gas[i] - cost[i];
    if (sum < 0) {
      start = i;
      sum = residual;
    } else {
      sum += residual;
    }
    total += residual;
  }
  if (total >= 0) {
    return start;
  }
  return -1;
}
