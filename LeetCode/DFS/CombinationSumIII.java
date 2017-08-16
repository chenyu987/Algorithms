// Combination Sum III
// Find all possible combinations of k numbers that add up to a number n, given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.

// Ensure that numbers within the set are sorted in ascending order.

// Example 1:

// Input: k = 3, n = 7
// Output:

// [[1,2,4]]
// Example 2:

// Input: k = 3, n = 9
// Output:

// [[1,2,6], [1,3,5], [2,3,4]]
// 深度优先搜索
// 复杂度
// 时间 O(9!) 空间 O(9) 递归栈空间

// 思路
// 这题其实是II的简化版，设想一个[1,2,3,4,5,6,7,8,9]的数组，同样一个元素只能取一次，但是已经预先确定没有重复了。所以可以省去跳过重复元素的部分。不过，我们在递归的时候要加一个额外的变量k来控制递归的深度，一旦超过了预设深度，就停止该分支的搜索。本质上是有限深度优先搜索。

// 代码
public class Solution {
    
    List<List<Integer>> res;
    
    public List<List<Integer>> combinationSum3(int k, int n) {
        res = new LinkedList<List<Integer>>();
        List<Integer> tmp = new LinkedList<Integer>();
        helper(k, n, 1, tmp);
        return res;
    }
    
    private void helper(int k, int target, int i, List<Integer> tmp){
        if(target < 0 || k < 0){
            return;
        } else if (target == 0 && k == 0){
            List<Integer> oneComb = new LinkedList<Integer>(tmp);
            res.add(oneComb);
        } else {
            for(int j = i; j <= 9; j++){
                tmp.add(j);
                helper(k-1, target-j, j+1, tmp);
                tmp.remove(tmp.size() - 1);
            }
        }
    }
}


// from the template version wrote by myself
public List<List<Integer> combinationSum3(int k, int n) {
    ArrayList<ArrayList<Integer>> result = ArrayList<ArrayList<Integer>();
    if (k < 0) return result;
    helper(k, n, start, new ArrayList<Integer>(), result);
    return result;
}

private void helper(int k, int n, int start, ArrayList<Integer> tmp, ArrayList<ArrayList<Integer> result) {
    if (n < 0 || k < 0) {
        return;
    }
    else if (n == 0 && k == 0) {
        result.add(new ArrayList<Integer>(tmp));
    }
    else {
        for (int i = start; i <= 9; i++) {
            tmp.add(i);
            //*这个i + 1代表他不能被重复利用
            helper(k - 1, n - i, i + 1，tmp, result);
            tmp.remove(tmp.size() - 1);
        }
    }
    
}