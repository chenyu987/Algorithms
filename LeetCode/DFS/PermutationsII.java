/**
* Given a collection of numbers that might contain duplicates, return all possible unique permutations.
* 
* For example,
* [1,1,2] have the following unique permutations:
* [
*   [1,1,2],
*   [1,2,1],
*   [2,1,1]
* ]
*/

public List<List<Integer>> permutationsII(int[] nums) {
    List<List<Integer>> result = new ArrayList<ArrayList<Integer>>();
    if (nums == null || nums.length == 0) return result;
    Arrays.sort(nums);
    helper(result, new ArrayList<Integer>(), nums, new boolean[nums.length]);
    return result;
}

private void helper(List<List<Integer>> result, List<Integer> tmp, int[] nums, boolean[] used) {
    if (tmp.size() == nums.length) {
        result.add(new ArrayList<Integer>(tmp);
        return;
    }
    else {
        for (int i = 0; i < nums.length; i++) {
            // 这一块主要是为了去重，已经有一个1进来的话就别让第二个1进来了
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) continue;
            // 用used主要是让每个值unique，不管值一不一样，他们都会被标注好被没被用过
            if (!used[i]) {
                used[i] = true;
                tmp.add(nums[i]);
                helper(result, tmp, nums, used);
                tmp.remove(tmp.size() - 1);
                used[i] = false;
            }
        }
    }
}

// from recite word file
Permutations 2(如果有重复怎么办）
Given a collection of numbers that might contain duplicates, return all possible unique permutations. 

For example, 
[1,1,2] have the following unique permutations: 
[1,1,2], [1,2,1], and [2,1,1].


class Solution {
    /**
     * @param nums: A list of integers.
     * @return: A list of unique permutations.
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
    
        ArrayList<List<Integer>> results = new ArrayList<List<Integer>>();
    
        if (nums == null) {
            return results;
        }
    
        if(nums.length == 0) {
            results.add(new ArrayList<Integer>());
            return results;
        }

        Arrays.sort(nums);
        ArrayList<Integer> list = new ArrayList<Integer>();
        int[] visited = new int[nums.length];
        for ( int i = 0; i < visited.length; i++){
            visited[i] = 0;
        }
     
        helper(results, list, visited, nums);    
        return results;
    }
    
    
    public void helper(ArrayList<List<Integer>> results, 
                   ArrayList<Integer> list, int[] visited, int[] nums) {
        
        if(list.size() == nums.length) {
            results.add(new ArrayList<Integer>(list));
            return;
        }
        
        for(int i = 0; i < nums.length; i++) {
            if ( visited[i] == 1 || ( i != 0 && nums[i] == nums[i - 1]
            && visited[i-1] == 0)){
                continue;
            }
            /*
            上面的判断主要是为了去除重复元素影响。
            比如，给出一个排好序的数组，[1,2,2]，那么第一个2和第二2如果在结果中互换位置，
            我们也认为是同一种方案，所以我们强制要求相同的数字，原来排在前面的，在结果
            当中也应该排在前面，这样就保证了唯一性。所以当前面的2还没有使用的时候，就
            不应该让后面的2使用。
            */
            visited[i] = 1;
            list.add(nums[i]);
            helper(results, list, visited, nums);
            list.remove(list.size() - 1);
            visited[i] = 0;
        }
     } 
}