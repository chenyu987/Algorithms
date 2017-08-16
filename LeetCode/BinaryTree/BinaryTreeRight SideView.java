
Binary Tree Right Side View
Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.

For example: Given the following binary tree,

   1            <---
 /   \
2     3         <---
 \     \
  5     4       <---
  

   1            <---
 /   \
2     3         <---
 \   
  5     
You should return [1, 3, 4].


// this need to be implemented
// public class Solution {
//     List<Integer> result;
//     int curdepth;
    
//     public List<Integer> rightSideView(TreeNode root) {
//         result = new LinkedList<Integer>();
//         if (root == null) return result;
//         helper(root, 1);
//         return result;
//     }
    
//     private void helper(TreeNode root, int depth) {
//         if (depth > curdepth) {
//             curdepth = depth;
//             result.add(root.val);
//         }
//         if (result.size() == depth) {
//           result.add(root.val);
//         }
//         if (root.right != null) helper(root.right, depth + 1);
//         if (root.left != null) helper(root.left, depth + 1);
//     }
// }

/**
* Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.
* 
* For example:
* Given the following binary tree,
*    1            <---
*  /   \
* 2     3         <---
*  \     \
*   5     4       <---
* You should return [1, 3, 4].
*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

/*
由于每层只选择一个节点，所以优先访问右侧的节点。当List<Integet>的大小与层的深度一致时，说明已经加入了最右侧的节点，
该层的其他节点无需再加入
*/
public class BinaryTreeRightSideView {
  public List<Integer> rightSideView(TreeNode root) {
    List<Integer> res = new ArrayList<Integer>();
    if (root == null) {
      return res;
    }
    helper(root, res, 0);
    return res;
  }
  
  private void helper(TreeNode root, List<Integer> res, int level) {
    if (root == null) {
      return;
    }
    if (res.size() == level) {
      res.add(root.val);
    } 
    helper(root.right, res, level+1);
    helper(root.left, res, level+1);
  }
}


// BFS方法（更好想）
    public List<Integer> rightSideView(TreeNode root) {
        // reverse level traversal
        List<Integer> result = new ArrayList();
        Queue<TreeNode> queue = new LinkedList();
        if (root == null) return result;
        
        queue.offer(root);
        while (queue.size() != 0) {
            int size = queue.size();
            for (int i=0; i<size; i++) {
                TreeNode cur = queue.poll();
                if (i == 0) result.add(cur.val);
                if (cur.right != null) queue.offer(cur.right);
                if (cur.left != null) queue.offer(cur.left);
            }
            
        }
        return result;
    }













