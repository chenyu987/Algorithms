LCA in BST.

  
public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
  if (root == null || root == p || root == q) return root;
  if (p.val < root.val && q.val < root.val) return lowestCommonAncestor(root.left, p, q);
  if (p.val > root.val && q.val > root.val) return lowestCommonAncestor(root.right, p, q);
  // think about why here is different from the other method
  return root;
}


LCA in Binary Tree.
  
        _______3______
       /              \
    ___5__          ___1__
   /      \        /      \
   6      _2       0       8
         /  \
         7   4  


  
// if find LCA, return LCA
// if find of one the TreeNode, return this Node
// if find null, return null
public TreeNode lCABinaryTree(TreeNode root, TreeNode p, TreeNode q) {
  if (root == null || root == p || root == q) return root;
  //divide
  TreeNode left = lCABinaryTree(root.left, p, q);
  TreeNode right = lCABinaryTree(root.right, p, q);
  if (left != null && right != null) return root;
  if (left != null) return left;
  if (right != null) return right;
  return null;
}