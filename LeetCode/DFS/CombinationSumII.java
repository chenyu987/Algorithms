// Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

// Each number in C may only be used once in the combination.

// Note: All numbers (including target) will be positive integers.
// Elements in a combination (a1, a2, … , ak) must be in non-descending
// order. (ie, a1 ≤ a2 ≤ … ≤ ak). The solution set must not contain
// duplicate combinations. For example, given candidate set
// 10,1,2,7,6,1,5 and target 8, A solution set is:

// [1, 7] 
// [1, 2, 5] 
// [2, 6] 
// [1, 1, 6]
// 深度优先搜索
// 复杂度
// 时间 O(N!) 空间 O(N) 递归栈空间

// 思路
// 这题和I的区别在于同一个数只能取一次，比如数组中只有3个1，那结果中也最多只有3个1，而且结果也不能重复。所以我们在递归时首先要把下标加1，这样下轮搜索中就排除了自己。其次，对一个数完成了全部深度优先搜索后，比如对1完成了搜索，那么我们要把后面的1都跳过去。当然，跳过只是针对本轮搜索的，在对第一个1的下一轮的搜索中，我们还是可以加上第二个1。只是我们不能再以第二个1开头了而已。为了能连续跳过重复的数，这里我们必须先排序。

// 代码

public class Solution {
    
    List<List<Integer>> res;
    
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        res = new LinkedList<List<Integer>>();
        List<Integer> tmp = new LinkedList<Integer>();
        Arrays.sort(candidates);
        helper(candidates, target, 0, tmp);
        return res;
    }
    
    private void helper(int[] nums, int target, int index, List<Integer> tmp){
        if(target < 0){
            return;
        } else if(target == 0){
            List<Integer> oneComb = new LinkedList<Integer>(tmp);
            res.add(oneComb);
        } else {
            for(int i = index; i < nums.length; i++){
                tmp.add(nums[i]);
                // 递归时下标加1
                helper(nums, target - nums[i], i+1, tmp);
                tmp.remove(tmp.size() - 1);
                // 跳过本轮剩余的重复元素
                while(i < nums.length - 1 && nums[i] == nums[i + 1]){
                    i++;
                }
            }
        }
    }
}


