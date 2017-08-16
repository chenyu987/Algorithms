#2 Binary Tree BFS Template


public class Solution {
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        ArrayList result = new ArrayList();
        
        if (root == null)
            return result;
            
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        
        while (!queue.isEmpty()) {
            ArrayList<Integer> level = new ArrayList<Integer>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode head = queue.poll();
                level.add(head.val);
                if (head.left != null)
                    queue.offer(head.left);
                if (head.right != null)
                    queue.offer(head.right);
            }
            result.add(level);
        }
        
        return result;
    }
}

// from segment fault
public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<List<Integer>>();
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        if(root != null) q.offer(root);
        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> level = new LinkedList<Integer>();
            //控制当前层的遍历次数
            for(int i =0; i < size; i++){
                TreeNode curr = q.poll();
                level.add(curr.val);
                if(curr.left!=null) q.offer(curr.left);
                if(curr.right!=null) q.offer(curr.right);
            }
            res.add(level);
            //对于II， 我们要逆序加入
            //res.add(0, level)
        }
        return res;
    }
}

// exercise


public List<List<Integer>> levelOrderTraversal(TreeNode root) {
    ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    Queue<TreeNode> q = new LinkedList<TreeNode>();
    if (root != null) q.pffer(root);
    while (!q.isEmpty()) {
        int size = q.size();
        List<Integer> level = ArrayList<Integer>();
        for (int i = 0; i < size; i++) {
            TreeNode cur = q.poll();
            level.add(cur.val);
            if (cur.left != null) q.offer(cur.left);
            if (cur.right != null) q.offer(cur.right);
        }
        result.add(level);
    }
    return result;
}