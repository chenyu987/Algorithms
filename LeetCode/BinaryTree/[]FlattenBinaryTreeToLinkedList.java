
// Flatten Binary Tree to Linked List
// Given a binary tree, flatten it to a linked list in-place.

// For example, Given

//      1
//     / \
//    2   5 
//   / \   \
//  3   4   6
// The flattened tree should look like:

//    1
//     \
//      2
//       \
//        3
//         \
//          4
//           \
//            5
//             \
//              6


root == 1;
right = 5;

prev(0) = 1;
hlper(prev, 2);
helper(prev, 5);

root == 2;
right = 4;
prev(0): 1;
1.left = null;
1.right = 2;
prev(0) = 2;
helper(prev, 3);
hehlper(prev, 4);

root == 3;
prev(0) == 2;
3.left = null;
2.right = 3;
helper(prev, null);
helper(prev, null);

next level: return;






public void flatten(TreeNode root) {
  if (root == null) return;
  List<TreeNode> prev = new ArrayList<TreeNode>();
  prev.add(null);
  helper(prev, root);
}

private void helper(List<TreeNode> prev, TreeNode root) {
  if (root == null) return;
  TreeNode right = root.right;
  if (prev.get(0) != null) {
    prev.get(0).left = null;
     prev.get(0).right = root;
  }
  prev.set(0, root);
  helper(prev, root.left);
  helper(prev, right);
}
