/*
Balanced Binary Tree
Given a binary tree, determine if it is height-balanced.

For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.


*/


// Wrong One!!!!!! Think about why!!?
public boolean isBalanced(TreeNode root) {
  if (root == null) {
    return true;
  }
  int leftDepth = helper(root.left);
  int rightDepth = helper(root.right);
  return Math.abs(left -right) <= 1;
  
private int helper(TreeNode root) {
  if (root == null) return 0;
  int left = helper(root.left);
  int right = helper(root.right);
  return Math.max(left, right) + 1;
}

// From JiuZhang
// Version 1: with ResultType
/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */
class ResultType {
    public boolean isBalanced;
    public int maxDepth;
    public ResultType(boolean isBalanced, int maxDepth) {
        this.isBalanced = isBalanced;
        this.maxDepth = maxDepth;
    }
}

public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: True if this Binary tree is Balanced, or false.
     */
    public boolean isBalanced(TreeNode root) {
        return helper(root).isBalanced;
    }
    
    private ResultType helper(TreeNode root) {
        if (root == null) {
            return new ResultType(true, 0);
        }
        
        ResultType left = helper(root.left);
        ResultType right = helper(root.right);
        
        // subtree not balance
        if (!left.isBalanced || !right.isBalanced) {
            return new ResultType(false, -1);
        }
        
        // root not balance
        if (Math.abs(left.maxDepth - right.maxDepth) > 1) {
            return new ResultType(false, -1);
        }
        
        return new ResultType(true, Math.max(left.maxDepth, right.maxDepth) + 1);
    }
}

// Version 2: without ResultType
public class Solution {
    public boolean isBalanced(TreeNode root) {
        return maxDepth(root) != -1;
    }

    private int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        if (left == -1 || right == -1 || Math.abs(left-right) > 1) {
            return -1;
        }
        return Math.max(left, right) + 1;
    }
}

// from segment fault
复杂度
时间 O(N) 空间 O(h) 递归栈空间

思路
非平衡的条件是有两个叶子节点的深度相差大于1，最直接的想法就是把左子树和右子树的高度都算出来，如果相差大于1则说明不是平衡的。在递归中，从叶子结点开始一层层返回高度，叶子结点是1。我们返回-1代表非平衡，返回自然数代表有效的子树高度。

代码
public class Solution {
    public boolean isBalanced(TreeNode root) {
        if(root==null) return true;
        int left = findHeight(root.left);
        int right = findHeight(root.right);
        return left != -1 && right != -1 && Math.abs(left-right)<=1;
    }
    
    private int findHeight(TreeNode root){
        if(root == null) return 0;
        int left = findHeight(root.left);
        int right = findHeight(root.right);
        if(left == -1 || right == -1 || Math.abs(left-right) > 1) return -1;
        return Math.max(left, right)+1;
    }
}