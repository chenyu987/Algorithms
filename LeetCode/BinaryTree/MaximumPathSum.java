
// Given a binary tree, find the maximum path sum.

// For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The path must contain at least one node and does not need to go through the root.

// For example:
// Given the below binary tree,

//         1
//       /  \
//      2    3
//     / \  / \
//    4  5  6  7
// Return 6.

public int maxPathSum(TreeNode root) {
  int maxValue = Integer.MIN_VALUE;
  maxPathDown(root, maxValue);
  return maxValue;
}

private maxPathDown(TreeNode root, int maxValue) {
  if (node == null) return 0;
  int left = Math.max(0, maxPathDown(node.left, maxValue));
  int right = Math.max(0, maxPathDown(node.right, maxValue));
  maxValue = Math.max(maxValue, left + right + root.val);
  return Math.max(left, right) + root.val;
}
