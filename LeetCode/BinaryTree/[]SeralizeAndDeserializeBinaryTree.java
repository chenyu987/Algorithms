/**
* Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.
* 
* Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure.
* 
* For example, you may serialize the following tree
* 
*     1
*    / \
*   2   3
*      / \
*     4   5
     / \
  null  1

* as "[1,2,3,null,null,4,5]", just the same as how LeetCode OJ serializes a binary tree. You do not necessarily need to follow this format, so please be creative and come up with different approaches yourself.
* Note: Do not use class member/global/static variables to store states. Your serialize and deserialize algorithms should be stateless.
*/  
"[1,2,3,null,$,4,5, null, 1, null, null]"
   
   
tail [right, left, root] head

[1, 2, '$','$' ,3, 4,'$', '$', 5, '$', '$'] 

public class XulieHuaHeFanXuLieHuaTree {
  public String serialize(TreeNode root) {
    if (root == null) return "$";
    StringBuilder sb = new StringBuilder();
    sb.append(root.val);
    String left = serialize(root.left);
    String right = serialize(root.right);
    sb.append(",");
    sb.append(left);
    sb.append(",");
    sb.append(right);
    return sb.toString();
  }
  
  public TreeNode deserialize(String data) {
    Queue<String> queue = new LinkedList<>();
    String[] nodes = data.split(",");
    for (String node : nodes) {
      queue.offer(node);
    }
    return treeWorker(queue);
  }
  
  private TreeNode treeWorker(queue<String> queue) {
    if (queue == null || queue.size() == 0) return null;
    String cur = queue.poll();
    if (cur.equals("$")) return null;
    TreeNode root = new TreeNode(Integer.parseInt(cur));
    root.left = treeWorker(queue);
    root.right = treeWorker(queue);
    return root;
  }
}