// Given a collection of distinct numbers, return all possible permutations.

// For example,
// [1,2,3] have the following permutations:
// [
//   [1,2,3],
//   [1,3,2],
//   [2,1,3],
//   [2,3,1],
//   [3,1,2],
//   [3,2,1]
// ]

public List<List<Integer>> permutations(int[] nums) {
    ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    if (nums == null || nums.length == 0) return result;
    helper(result, new ArrayList<Integer>(), nums, new boolean[nums.length]);
    return result;
}

private void helper(List<List<Integer>> result, List<Integer> tmp, int[] nums, boolean[] used) {
    if (tmp.size() == nums.length) {
        result.add(new ArrayList<Integer>(tmp));
        return;
    } else {
        for (int i = 0; i < nums.length; i++) {
            if (!used) {
                used[i] = true;
                tmp.add(nums[i]);
                helper(result, tmp, nums, used);
                tmp.remove(tmp.size() - 1);
                used[i] = false;
            }
        }
    }
}


// From Jiu Zhang

public class Solution {
    public List<List<Integer>> permute(int[] nums) {
         ArrayList<List<Integer>> rst = new ArrayList<List<Integer>>();
         if (nums == null) {
             return rst; 
         }
         
         if (nums.length == 0) {
            rst.add(new ArrayList<Integer>());
            return rst;
         }

         ArrayList<Integer> list = new ArrayList<Integer>();
         helper(rst, list, nums);
         return rst;
    }
    
    public void helper(ArrayList<List<Integer>> rst, ArrayList<Integer> list, int[] nums){
        if(list.size() == nums.length) {
            rst.add(new ArrayList<Integer>(list));
            return;
        }
        
        for(int i = 0; i < nums.length; i++){
            if(list.contains(nums[i])){
                continue;
            }
            // 因为结果里咩有顺序所以不用offset
            list.add(nums[i]);
            helper(rst, list, nums);
            list.remove(list.size() - 1);
        }
        
    }
}


// from the recite word file
#4 Permutations
public class Solution {
    public List<List<Integer>> permute(int[] nums) {
         ArrayList<List<Integer>> rst = new ArrayList<List<Integer>>();
         if (nums == null) {
             return rst; 
         }
         
         if (nums.length == 0) {
            rst.add(new ArrayList<Integer>());
            return rst;
         }

         ArrayList<Integer> list = new ArrayList<Integer>();
         helper(rst, list, nums);
         return rst;
    }
    
    public void helper(ArrayList<List<Integer>> rst, ArrayList<Integer> list, int[] nums){
        if(list.size() == nums.length) {
            rst.add(new ArrayList<Integer>(list));
            return;
        }
        
        for(int i = 0; i < nums.length; i++){
            if(list.contains(nums[i])){
                continue;
            }
            list.add(nums[i]);  // list.add(nums.get(i)
//找到以[1,2..]开头的所有序列
            helper(rst, list, nums);
            list.remove(list.size() - 1);
        }
        
    }
}

// Non-Recursion
class Solution {
    /**
     * @param nums: A list of integers.
     * @return: A list of permutations.
     */
    public List<List<Integer>> permute(int[] nums) {
        ArrayList<List<Integer>> permutations
             = new ArrayList<List<Integer>>();
        if (nums == null) {
            
            return permutations;
        }

        if (nums.length == 0) {
            permutations.add(new ArrayList<Integer>());
            return permutations;
        }
        
        int n = nums.length;
        ArrayList<Integer> stack = new ArrayList<Integer>();
        
        stack.add(-1);
        while (stack.size() != 0) {
            Integer last = stack.get(stack.size() - 1);
            stack.remove(stack.size() - 1);
            
            // increase the last number
            int next = -1;
            for (int i = last + 1; i < n; i++) {
                if (!stack.contains(i)) {
                    next = i;
                    break;
                }
            }
            if (next == -1) {
                continue;
            }
            
            // generate the next permutation
            stack.add(next);
            for (int i = 0; i < n; i++) {
                if (!stack.contains(i)) {
                    stack.add(i);
                }
            }
            
            // copy to permutations set
            ArrayList<Integer> permutation = new ArrayList<Integer>();
            for (int i = 0; i < n; i++) {
                permutation.add(nums[stack.get(i)]);
            }
            permutations.add(permutation);
        }
        
        return permutations;
    }
