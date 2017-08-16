// Maximum Depth of Binary Tree
// Given a binary tree, find its maximum depth.

// The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
// 递归法
// 复杂度
// 时间 O(N) 空间 O(H) 递归栈空间

// 思路
// 简单的递归。递归条件是，它的最大深度是它左子树的最大深度和右子树最大深度中较大的那个加1。基础条件是，当遇到空节点时，返回深度为0。该递归的实质是深度优先搜索。

// 代码


public int maxDepth(TreeNode root) {
    if(root == null){
        return 0;
    }
    int left = maxDepth(root.left);
    int right = maxDepth(root.right);
    return Math.max(left, right) + 1;
}


// iterative 
public int maxDepth(TreeNode root) {
  if (root == null) return 0;
  int depth = 0;
  Queue<TreeNode> queue = new LinkedList<>();
  queue.offer(root);
  int curNum = 1;
  int nxtNum = 0;
  while (!queue.isEmpty()) {
    TreeNode curNode = queue.poll();
    curNum--;
    if (curNode.left != null) {
      queue.offer(curNode.left);
      nxtNum++;
    }
    if (curNode.right != null) {
      queue.offer(curNode.right);
      nxtNum++;
    }
    if (curNum == 0) {
      curNum = nxtNum;
      nxtNum = 0;
      depth++;
    }
  }
  return depth;
}
