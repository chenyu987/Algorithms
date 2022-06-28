Given the root of a binary tree, return the vertical order traversal of its nodes' values. (i.e., from top to bottom, column by column).

If two nodes are in the same row and column, the order should be from left to right.
    

public class Solution {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
        HashMap<TreeNode, Integer> column = new HashMap<TreeNode, Integer>();
        map.put(0, new ArrayList<>());
        column.put(root, 0);
        q.offer(root);
        int min = 0;
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            int col = column.get(node);
            if (!map.containsKey(col)) {
                map.put(col, new ArrayList<>());
            }
            map.get(col).add(node.val);
            if (node.left != null) {
                q.add(node.left);
                column.put(node.left, col - 1);
            }
            if (node.right != null) {
                q.add(node.right);
                column.put(node.right, col + 1);
            }
            min = Math.min(min, col);
        }
        while (map.containsKey(min)) {
            result.add(map.get(min++));
        }
        return result;
    }
}
