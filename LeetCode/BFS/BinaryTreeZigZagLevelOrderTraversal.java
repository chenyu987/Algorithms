// Binary Tree Zigzag Level Order Traversal
// Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

// For example: Given binary tree {3,9,20,#,#,15,7},

//     3
//   / \
//   9  20
//     /  \
//   15   7
// return its zigzag level order traversal as:

// [
//   [3],
//   [20,9],
//   [15,7]
// ]
// 队列迭代

// 复杂度
// 时间 O(b^(h+1)-1) 空间 O(b^h)

// 思路
// ZigZag遍历时，奇数层正序记录，偶数层逆序记录。可以通过结果中已有的层数来判断。

// 代码
public class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<List<Integer>>();
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        if(root != null) q.offer(root);
        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> level = new LinkedList<Integer>();
            for(int i =0; i < size; i++){
                TreeNode curr = q.poll();
                //根据结果中已有的层数控制正序还是逆序
                if(res.size() % 2 == 0){
                    level.add(curr.val);
                } else {
                    level.add(0,curr.val);
                }
                if(curr.left!=null) q.offer(curr.left);
                if(curr.right!=null) q.offer(curr.right);
            }
            res.add(level);
        }
        return res;
    }
}