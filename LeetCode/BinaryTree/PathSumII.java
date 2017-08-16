// Path Sum II
// Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

// For example: Given the below binary tree and sum = 22,

//       5
//      / \
//     4   8
//   /   / \
//   11  13  4
//  /  \    / \
// 7    2  5   1
// return

// [
//   [5,4,11,2],
//   [5,8,4,5]
// ]
// 深度优先搜索
// 复杂度
// 时间 O(b^(h+1)-1) 空间 O(h) 递归栈空间 对于二叉树b=2

// 思路
// 基本的深度优先搜索，思路和上题一样用目标和减去路径上节点的值，不过要记录下搜索时的路径，把这个临时路径代入到递归里。

// 代码
public class Solution {
    
    List<List<Integer>> res;
    
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        res = new LinkedList<List<Integer>>();
        List<Integer> tmp = new LinkedList<Integer>();
        if(root!=null) helper(root, tmp, sum);
        return res;
    }
    
    private void helper(TreeNode root, List<Integer> tmp, int sum){
        if(root.val == sum && root.left==null && root.right==null){
            tmp.add(root.val);
            List<Integer> one = new LinkedList<Integer>(tmp);
            res.add(one);
            tmp.remove(tmp.size()-1);
        } else {
            tmp.add(root.val);
            if(root.left!=null) helper(root.left, tmp, sum - root.val);
            if(root.right!=null) helper(root.right, tmp, sum - root.val);
            tmp.remove(tmp.size()-1);
        }
    } 
}


// Zhe wrote in meeting
public List<List<Intger>> pathSumII(TreeNode root, int sum) {
  List<List<Integer>> res = new ArrayList<List<Integer>>();
  if (root == null) return res;
  List<Integer> tmp = new ArrayList<Integer>();
  helper(root, sum, tmp, res);
  return res;
}

private void helper (TreeNode root, int target, List<Integer> tmp, List<List<Integer>> res) {
  if (root == null) return;
  if (root.left == null && root.right == null && target == root.val) {
    tmp.add(root.val);
    res.add(new ArrayList<Integer>(tmp));
    return;
  }
  if (root.left != null) {
    tmp.add(root.left.val);
    helper(root.left, target-root.left.val, tmp, res);
    tmp.remove(tmp.size()-1);
  }
  if (root.right != null) {
    tmp.add(root.right.val);
    helper(root.right, target-root.right.val, tmp, res);
    tmp.remove(tmp.size()-1);
  }
}
