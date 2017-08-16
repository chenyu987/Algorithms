// Path Sum I
// Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.

// For example: Given the below binary tree and sum = 22,

//       5
//      / \
//     4   8
//   /   / \
//   11  13  4
//  /  \      \
// 7    2      1
// return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
// 递归法
// 复杂度
// 时间 O(b^(h+1)-1) 空间 O(h) 递归栈空间 对于二叉树b=2

// 思路
// 要求是否存在一个累加为目标和的路径，我们可以把目标和减去每个路径上节点的值，来进行递归。

// 代码
public class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root==null) return false;
        if(root.val == sum && root.left==null && root.right==null) return true;
        return hasPathSum(root.left, sum-root.val) || hasPathSum(root.right, sum-root.val);
    }
}