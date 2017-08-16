// Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

// The same repeated number may be chosen from C unlimited number of times.

// Note: All numbers (including target) will be positive integers. Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak). The solution set must not contain duplicate combinations. For example, given candidate set 2,3,6,7 and target 7, A solution set is:

// [7] 
// [2, 2, 3]



public List<List<Integer>> combinationSum(int[] nums, int target) {
    ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    if (nums == null || nums.length == 0) return result;
    // need to sort to help check duplication
    Arrays.sort(nums);
    dfs(nums, target, 0, result, new ArrayList<Integer>());
    return result;
}

private void dfs(int[] nums, int target, int offset, ArrayList<ArrayList<Integer>> result, ArrayList<Integer> tmp) {
    if (target < 0) {
        return;
    }
    // 临界条件
    else if (target == 0) {
        // have to create a new ArrayList
        result.add(new ArrayList<Integer>(tmp));
        return;
    } 
    else {
        for (int i = offset; i < nums.length; i++) {
            // important: check duplication, this means we one use the element that has this value once (same as permutationsII)
            if (nums[i] == nums[i - 1] && i > 0) continue;
            tmp.add(nums[i]);
            // important: check offset +1? +1means it cannot count itself anymore, no +1 means it can still be used
            dfs(nums, target - num[i], i, result, tmp);
            tmp.remove(tmp.size() - 1);
        }
    }
}



// 深度优先搜索
// 复杂度
// 时间 O(N!) 空间 O(N) 递归栈空间

// 思路
// 因为我们可以任意组合任意多个数，看其和是否是目标数，而且还要返回所有可能的组合，所以我们必须遍历所有可能性才能求解。为了避免重复遍历，我们搜索的时候只搜索当前或之后的数，而不再搜索前面的数。因为我们先将较小的数计算完，所以到较大的数时我们就不用再考虑有较小的数的情况了。这题是非常基本且典型的深度优先搜索并返回路径的题。本题需要先排序，不然过不了Leetcode。

// 注意
// 要先问清楚什么样的组合是有效的，比如该题，是可以连续选择同一个数加入组合的。

// 代码
public class Solution {
    
    List<List<Integer>> res;
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        res = new LinkedList<List<Integer>>();
        List<Integer> tmp = new LinkedList<Integer>();
        // 先将数组排序避免重复搜素
        Arrays.sort(candidates);
        helper(candidates, target, 0, tmp);
        return res;
    }
    
    private void helper(int[] nums, int target, int index, List<Integer> tmp){
        // 如果当前和已经大于目标，说明该路径错误 
        if(target < 0){
            return;
        // 如果当前和等于目标，说明这是一条正确路径，记录该路径
        } else if(target == 0){
            List<Integer> oneComb = new LinkedList<Integer>(tmp);
            res.add(oneComb);
        // 否则，对剩余所有可能性进行深度优先搜索
        } else {
            // 选取之后的每个数字都是一种可能性
            for(int i = index; i < nums.length; i++){
                // 典型的先加入元素，再进行搜索，递归回来再移出元素的DFS解法 
                tmp.add(nums[i]);
                helper(nums, target - nums[i], i, tmp);
                tmp.remove(tmp.size() - 1);
            }
        }
    }
}