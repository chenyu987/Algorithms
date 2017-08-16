// Serialize and Deserialize BST
[root, left, right] -> right solution
[,root,left,right] -> null

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
  Queue<String> queue = new LinkedList<String>();
  String[] nodes = data.split(",");
  for (String node : nodes) {
    queue.offer(node);
  }
  return treeWorker(queue);
}

private TreeNode treeWorker(Queue<String> queue) {
  if (queue == null || queue.size() == 0) return null;
  String node = queue.poll();
  if (node.equals("$")) return null;
  TreeNode root = new TreeNode(Integer.ValueOf(node));
  root.left = treeWorker(queue);
  root.right = treeWorker(queue);
  return root;
}