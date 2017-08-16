Binary Tree Inorder Traversal
Given a binary tree, return the inorder traversal of its nodes' values.

For example: Given binary tree {1,#,2,3},

   1
    \
     2
    /
   3
return [1,3,2].
栈迭代
复杂度
时间 O(b^(h+1)-1) 空间 O(h) 递归栈空间 对于二叉树b=2

思路
用栈中序遍历没有先序遍历那么直观，因为我们不能马上pop出当前元素，而要先把它的左子树都遍历完才能pop它自己。所有我们先将将最左边的所有节点都push进栈，然后再依次pop并记录值，每pop一个元素后再看它有没有右子树，如果右的话，我们再将它的右节点和右子树中最左边的节点都push进栈，再依次pop。

代码
public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<Integer>();
        Stack<TreeNode> s = new Stack<TreeNode>();
        //先将最左边的节点都push进栈
        if(root!=null){
            pushAllTheLeft(s, root);
        }
        while(!s.isEmpty()){
            TreeNode curr = s.pop();
            res.add(curr.val);
            //如果有右子树，将右节点和右子树的最左边的节点都push进栈
            if(curr.right != null){
                pushAllTheLeft(s, curr.right);
            }
        }
        return res;
    }
    
    private void pushAllTheLeft(Stack<TreeNode> s, TreeNode root){
        s.push(root);
        while(root.left!=null){
            root = root.left;
            s.push(root);
        }
    }
}


/*
         1
        / \
      2    3
     / \    /\
    4   5  8  9
   / \
  6   7
  
 step1:
  stack [1, 2 , 4, 6]
  cur = 6 -> 4
  res = [6 , 4]
 step2:
  stack ->[1, 2, 7]
  cur = 7
  res = [6, 4 ,7]
 step3"
   stack ->[1,2]-> [1]
   res = 2 -> 5
   res = [6, 4, 7, 2, 5]
  .....
  总之还是要背啊
  
  
*/

Binary Tree Inorder Traversal
Given a binary tree, return the inorder traversal of its nodes' values.

For example: Given binary tree {1,#,2,3},

   1
    \
     2
    /
   3
return [1,3,2].


/
public List<Integer> inorder(TreeNode root) {
  List<Integer> res = new ArrayList<Integer>();
  if (root == null) return res;
  Stack<TreeNode> stack = new Stack<TreeNode>();
  while (root != null || !stack.isEmpty()) {
    if (root != null) {
      stack.push(root);
      root = root.left;
    } else {
      root = stack.pop();
      res.add(root);
      root = root.right;
    }
  }
  return res;
}



// 递归
public List<Integer> inorder(TreeNode root) {
  List<Integer> res = new ArrayList<Integer>();
  helper(root, res);
  return res;
}

private void helper(TreeNode root, List<Integer> res) {
  if (root == null) return res;
  helper(root.left, res);
  res.add(root.val);
  helper(root.right, res);
}
  
  