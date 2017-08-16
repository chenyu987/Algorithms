dfs backtracking模板




public List<List<Integer>> model(input) {
    ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    if (sanity check) return result;
    // sometimes need to sort to help check duplication
    Arrays.sort(nums);
    //   输入值     offset 放答案    每次循环记录本层循环答案的tmp 
    dfs(nums, target, 0, result, new ArrayList<Integer>());
    return result;
}
//                          要达到的值，可能会和原始target不一样
//              当开始输入值不是nuns数组而是整数是他可能也在backing时候变，看combination sumIII
private void dfs(int[] nums, int target, int offset, ArrayList<ArrayList<Integer>> result, ArrayList<Integer> tmp) {
    // 临界条件
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
        // dfs的难点也是精髓，backtracking过程
        // i的起始点要注意
        for (int i = offset; i < nums.length; i++) {
            // important: check duplication, this means we one use the element that has this value once (same as permutationsII)
            // 用这个来remove duplication in the nums given
            // 在permutation里面，也是这里做查重操作，只是他会在一个tmp里看是否存在
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            tmp.add(nums[i]);
            // important: check offset +1? +1means it cannot count itself anymore, no +1 means it can still be used
            // combinationsum1&2分别需要i+1和保持i
            // 如果结果无序，那么连i也不需要 eg. permutation
            dfs(nums, target - num[i], i, result, tmp);
            tmp.remove(tmp.size() - 1);
        }
    }
}
