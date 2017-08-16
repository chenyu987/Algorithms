[Leetcode] Inorder Successor in BST 二叉搜索树中序下一个

leetcode 算法 java  ethannnli 2015年09月25日发布
   |   0   收藏  |  3
3.7k 次浏览
Inorder Successor in BST
Given a binary search tree and a node in it, find the in-order successor of that node in the BST.

Note: If the given node has no in-order successor in the tree, return null.
路径入栈法
复杂度
时间 O(N) 空间 O(N)

思路
题目给定根节点和目标节点。目标节点如果有右节点的情况比较好处理，我们只要返回它的右节点的最左边的节点就行了（右节点自己没有左节点时则是右节点本身）。如果目标节点没有右节点，说明比目标节点稍大的节点应该在上面，因为我们知道目标节点的左节点肯定是比目标节点要小的。

那怎么知道目标节点的上面是什么呢？这时就需要从根节点搜索到目标节点了。这里要注意的是，目标节点的父亲不一定比目标节点大，因为有可能目标节点的是其父亲的右孩子。所以我们要找的上面，实际上是从目标节点向根节点回溯时，第一个比目标节点大的节点。最差的情况下，如果回溯到根节点还是比目标节点要小的话，说明目标节点就是整个数最大的数了，这时候返回空。

那怎么实现目标节点向根节点回溯，这里用一个栈就行了，在我们寻找目标节点时，把路径上的节点都压入栈中。

代码

public class Solution {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        Stack<TreeNode> stk = new Stack<TreeNode>();
        TreeNode curr = root;
        // 找到目标节点并把路径上的节点压入栈
        while(curr != p){
            stk.push(curr);
            if(curr.val > p.val){
                curr = curr.left;
            } else {
                curr = curr.right;
            }
        }
        // 如果目标节点有右节点，则找到其右节点的最左边的节点，就是下一个数
        if(curr.right != null){
            curr = curr.right;
            while(curr.left != null){
                curr = curr.left;
            }
            return curr;
        } else {
        // 如果没有右节点，pop栈找到第一个比目标节点大的节点
            while(!stk.isEmpty() && stk.peek().val < curr.val){
                stk.pop();
            }
            // 如果栈都pop空了还没有比目标节点大的，说明没有更大的了
            return stk.isEmpty() ? null : stk.pop();
        }
    }
}