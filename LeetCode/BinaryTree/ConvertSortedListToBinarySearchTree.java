Convert Sorted List to Binary Search Tree
Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
递归法
复杂度
时间 O(N) 空间 O(H)

思路
建树比较方便的方法是递归，对于有序链表，高度平衡BST的根节点是其中点，然后该根节点的左子树的根节点，又是左半边的中点，该根节点的右子树的根节点，又是右半边的中点，以此往复，链表第一个节点，就是最左边左子树的根节点，而最左边左子树的左节点和右节点都是空。我们可以用start和end两个值来限定子树在链表中的位置，通过递归的方式，实际上可以实现顺序遍历链表然后建树的过程。不过java中，需要将链表当前遍历到节点作为全局变量，保证递归过程中链表也是顺序遍历的。

代码

public class Solution {
    
    ListNode curr;
    
    public TreeNode sortedListToBST(ListNode head) {
        curr = head;
        int len = 0;
        // 先计算出链表的长度
        while(head != null){
            head = head.next;
            len++;
        }
        // 开始建树
        return buildTree(0, len - 1);
    }
    
    private TreeNode buildTree(int start, int end){
        // 如果start>end，说明子树已经小到没有节点了，直接返回null
        if(start > end){
            return null;
        }
        // 找到中点
        int mid = start + (end - start) / 2;
        // 先递归的计算左子树
        TreeNode left = buildTree(start, mid - 1);
        // 然后建立根节点
        TreeNode root = new TreeNode(curr.val);
        // 链表顺序遍历
        curr = curr.next;
        // 最后计算右子树
        TreeNode right = buildTree(mid + 1, end);
        // 将三个节点连接起来
        root.left = left;
        root.right = right;
        return root;
    }
}


/**
* Given a singly linked list where elements are sorted in ascending order, 
* convert it to a height balanced BST.
*/ 

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
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
复杂度
时间:O(n) 空间：O(n)

思路： bottom to up construction 
先递归构建左子树，在构建左子树的同时不断移动链表的头指针，
链表的头指针永远是对应当前子树位置 一直到左叶子节点，左叶子节点对应的就是链表的第一个元素，
生成左叶子节点之后移动链表当前指针
*/ 
public class ConvertSortedListToBinarySearchTree {
  public TreeNode sortedListToBST(ListNode head) {
    if (head == null) return null;          
    ListNode curHead = head;
    int len = 0;
    while (curHead != null) {
      curHead = curHead.next;
      len++;
    }
    List<ListNode> list = new ArrayList<>();
    list.add(head);
    TreeNode root = helper(list, 0, len-1);
    return root;
  }
  
  private TreeNode helper(List<ListNode> list, int idxL, int idxR) {
    if (idxL > idxR) {
      return null;
    }
    int mid = (idxL + idxR) / 2;
    TreeNode left = helper(list, idxL, mid-1);
    TreeNode root = new TreeNode(list.get(0).val);
    root.left = left;
    list.add(0, list.get(0).next);
    root.right = helper(list, mid+1, idxR);
    return root;
  }  
}

