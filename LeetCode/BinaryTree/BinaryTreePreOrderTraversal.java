#1 Binary Tree Preorder Traversal
Q:Given a binary tree, return the preorder traversal of its nodes' values. 

For example: 
Given binary tree {1,#,2,3}, 

 1 
   \ 
     2 
    / 
  3 
return [1,2,3]. 


Version 0: Non-Recursion (Recommend)
/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        List<Integer> preorder = new ArrayList<Integer>();
        
        if (root == null) {
            return preorder;
        }
        
        stack.push(root);
        while (!stack.empty()) {
            TreeNode node = stack.pop();
            preorder.add(node.val);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        
        return preorder;
    }
}


//Version 1: Traverse
public class Solution {
    // traverse法需要建另一个函数，dc法不用
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        traverse(root, result);
        return result;
    }
    // 递归的定义:把root为跟的preorder加入result里面
    private void traverse(TreeNode root, ArrayList<Integer> result) {
     //递归的出口
        if (root == null) {
            return;
        }
     //递归的拆解
        result.add(root.val);
        traverse(root.left, result);
        traverse(root.right, result);
    }
}

public ArrayList<Integer> preorderTraversal(TreeNode root)

//Version 2: Divide & Conquer
public class Solution {
    // dc法直接在本身进行
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        // null or leaf
        if (root == null) {
            return result;
        }

        // Divide
        ArrayList<Integer> left = preorderTraversal(root.left);
        ArrayList<Integer> right = preorderTraversal(root.right);

        // Conquer
        result.add(root.val);
        result.addAll(left);
        result.addAll(right);
        return result;
    }
}





